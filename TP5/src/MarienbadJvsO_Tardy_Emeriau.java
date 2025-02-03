/**
 * Ce programme est une version du jeu de Marienbad où le joueur humain affronte une IA qui possède 3 niveau de difficulté.
 * Le niveau débutant fait des coups au hasard, le moyen utilise la stratégie gagnante quand il reste 3 lignes et l'expert est invicible à moins de jouer parfaitement une position gagnante d'origine
 * @author EMERIAU Emilien et TARDY Elie
 *         Groupe : B
 **/
class MarienbadJvsO_Tardy_Emeriau {

    // Variables pour stocker les scores des joueurs
    int scoreJoueur1 = 0;
    int scoreOrdi = 0;

    // Nom du joueur humain et nom prédéfini pour les ordinateurs
    String ordiFaible = "chatGPT";
    String ordiMoyen = "Deep Blue";
    String ordiExpert = "Enigma";
    String stopPseudo = " ";

    /**
     * Méthode principale pour démarrer et gérer les parties. 
     * Elle permet à l'utilisateur de lancer des parties ou de quitter le jeu.
     */
    void principal() {
        String nickNameJoueur1 = SimpleInput.getString("Selectionnez le pseudo du premier joueur : ");
        while(nickNameJoueur1.equals(stopPseudo)){
            nickNameJoueur1 = SimpleInput.getString("Selectionnez le pseudo du premier joueur (pas un espace) : ");
        }

        char choix;
        boolean continuer = true;

        do {
            choix = SimpleInput.getChar("Pour lancer une partie, tapez : '!'");

            if (choix == '!') {

                //Choix niveaux ordinateur
                System.out.println("Il y a 3 niveaux d'ordinateur, sélectionnez celui que vous souhaitez affronter : ");
                System.out.println("Entrer 1 pour l'ordinateur de niveau débutant");
                System.out.println("Entrer 2 pour l'ordinateur de niveau moyen");
                System.out.println("Entrer 3 pour l'ordinateur de niveau expert");
                int ordi = SimpleInput.getInt("Quel ordinateur voulez-vous affronter : ");


                // Verification de la saisi d'un niveau valable pour l'ordi
                while (ordi != 3 && ordi != 2 && ordi != 1){
                    ordi = SimpleInput.getInt("Quel ordinateur voulez-vous affronter : ");
                }

                // Set up du nom de l'ordi
                String nomOrdi = ordiFaible;

                if(ordi == 2){
                    nomOrdi = ordiMoyen;
                } else if (ordi == 3){
                    nomOrdi = ordiExpert;
                }

                // Demande qui commence la partie : le joueur ou l'ordinateur
                char premierJoueur = SimpleInput.getChar("Qui commence ? Tapez + pour commencer, sinon l'ordinateur aura le premier coup : ");

                jeu(nickNameJoueur1, premierJoueur, ordi);
                System.out.println("Le nombre de partie gagné est de " + scoreJoueur1 + " pour " + nickNameJoueur1 + " et de " + scoreOrdi + " pour " + nomOrdi);
            } else {
                continuer = false;
            }
        } while (continuer);

        System.out.println("Merci d'avoir joué !");
        System.out.println("A la prochaine !");

        //Affichage des tests
        char exec = SimpleInput.getChar ("Si vous voulez voir les test d'exectution entrez 't'");
        if (exec == 't'){
            testTourOrdiFaible();
            testCoupOpti();
        }

    }

    /**
     * Gère une partie de jeu de Marienbad.
     * @param premierJoueur un caractère indiquant qui commence ('+' pour le joueur, sinon l'ordinateur).
     **/
    void jeu(String nickNameJoueur1,char premierJoueur, int ordi) {
        boolean continuerJeu = true;
        int nbTour = 2; // Ordinateur commence par défaut
        int nbBatons = 0;
        int[] tabJeu = paramJeu(); // Initialisation du tableau avec le nombre de lignes et bâtons

        // Calcul du nombre total de bâtons dans le jeu
        for (int i = 0; i < tabJeu.length; i++) {
            nbBatons += tabJeu[i];
        }

        // Si le joueur commence, le nombre de tour est modifié
        if (premierJoueur == '+') { 
            nbTour++;
        }

        // Boucle principale pour gérer les tours de jeu
        while (continuerJeu) {
            if (nbTour % 2 == 0) { // Tour de l'ordinateur
                if(ordi == 1) {
                    System.out.println("C'est au tour de " + ordiFaible);
                    continuerJeu = tourOrdiFaible(tabJeu); // Tour de l'IA


                    if (!continuerJeu) {
                        scoreOrdi++; // Mise à jour du score de l'ordinateur
                        System.out.println(ordiFaible + " a gagné cette manche !");
                    }
                } else if (ordi == 2) {
                    System.out.println("C'est au tour de " + ordiMoyen);
                    continuerJeu = tourOrdiMoyen(tabJeu); // Tour de l'IA


                    if (!continuerJeu) {
                        scoreOrdi++; // Mise à jour du score de l'ordinateur
                        System.out.println(ordiMoyen + " a gagné cette manche !");
                    }
                } else if (ordi == 3) {
                    System.out.println("C'est au tour de " + ordiExpert);
                    continuerJeu = tourOrdiExpert(tabJeu); // Tour de l'IA

                    if (!continuerJeu) {
                        scoreOrdi++; // Mise à jour du score de l'ordinateur
                        System.out.println(ordiExpert + " a gagné cette manche !");
                    }
                }
            } else { // Tour du joueur
                System.out.println("C'est au tour de " + nickNameJoueur1);
                continuerJeu = tourJeu(tabJeu); // Tour du joueur

                if (!continuerJeu) {
                    scoreJoueur1++; // Mise à jour du score du joueur
                    System.out.println(nickNameJoueur1 + " a gagné cette manche !");
                }
            }
            nbTour++;
        }
    }

    /**
     * Initialise le jeu en demandant à l'utilisateur de choisir le nombre de lignes
     * et en générant le nombre de bâtons pour chaque ligne.
     * @return Un tableau d'entiers dénombrant les bâtons sur chaque ligne.
     */
    int[] paramJeu() {
        int nbBatonsTabDeJeu = 1;
        int nbBatonParLignes = 1;
        int[] tabBatonsParLignes = new int[1];
        int nbLignes = 0;

        // Demande à l'utilisateur de choisir le nombre de lignes
        nbLignes = SimpleInput.getInt("Choisissez le nombre de lignes entre 2 et 15 inclus : ");
        while (2 > nbLignes || nbLignes > 15) {
            nbLignes = SimpleInput.getInt("On a dit un nombre entre 2 et 15 inclus petit chenapan : ");
        }

        // Création du tableau en fonction du nombre de lignes choisi
        tabBatonsParLignes = new int[nbLignes];

        // Remplissage du tableau avec un nombre croissant de bâtons (1, 3, 5, ...)
        for (int i = 0; i < tabBatonsParLignes.length; i++) {
            tabBatonsParLignes[i] = nbBatonParLignes;
            nbBatonParLignes = nbBatonParLignes + 2;
            nbBatonsTabDeJeu = nbBatonsTabDeJeu + nbBatonParLignes;
        }
        afficherJeu(tabBatonsParLignes); // Affiche l'état initial du jeu
        return tabBatonsParLignes;
    }

    /**
     * Affiche l'état actuel du jeu, ligne par ligne, avec les bâtons.
     * @param tabAffiche Un tableau d'entiers représentant les bâtons sur chaque ligne.
     */
    void afficherJeu(int[] tabAffiche) {
        // Affichage du tableau ligne par ligne
        for (int i = 0; i < tabAffiche.length; i++) {
            for (int j = 0; j < tabAffiche[i]; j++) {
                if (j == 0) {
                    if (i < 10) {
                        System.out.print(i + " : ");
                    } else {
                        System.out.print(i + ": ");
                    }
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    /**
     * Gère le tour du joueur humain.
     * @param t Un tableau représentant l'état actuel des bâtons.
     * @return true si le jeu doit continuer, false si la partie est terminée.
     */
    boolean tourJeu(int[] t) {
        boolean besoinNouveauTourDeJeu = false;
        int ligneMax = t.length - 1;

        // Le joueur choisit une ligne
        int choisirL = SimpleInput.getInt("Choisissez une ligne entre 0 et " + ligneMax + " : ");
        while (choisirL < 0 || choisirL > ligneMax || t[choisirL] == 0) {
            choisirL = SimpleInput.getInt("Choisissez vraiment une ligne entre 0 et " + ligneMax + " où il reste des bâtons : ");
        }

        // Le joueur choisit un nombre de bâtons à retirer
        int choisirB = SimpleInput.getInt("Choisissez un nombre de bâtons à retirer entre 1 et " + t[choisirL] + " : ");
        while (1 > choisirB || choisirB > t[choisirL]) {
            choisirB = SimpleInput.getInt("Choisissez un nombre de bâtons à retirer vraiment entre 1 et " + t[choisirL] + " : ");
        }

        // Mise à jour du tableau après le retrait des bâtons
        t[choisirL] = t[choisirL] - choisirB;
        afficherJeu(t);

        // Vérification si le jeu doit continuer
        for (int i = 0; i < t.length; i++) {
            if (t[i] != 0) {
                besoinNouveauTourDeJeu = true;
            }
        }
        return besoinNouveauTourDeJeu;
    }

    /**
     * Gère le tour de l'ordinateur (IA simple qui choisit des coups aléatoires).
     * @param t Un tableau représentant l'état actuel des bâtons.
     * @return true si le jeu doit continuer, false si la partie est terminée.
     */
    boolean tourOrdiFaible(int[] t) {
        boolean besoinNouveauTourDeJeuIA = false;
        int ligneMax = t.length - 1;

        // Choix aléatoire d'une ligne où il reste des bâtons
        int choisirL = (int) (Math.random() * (ligneMax + 1));
        while (t[choisirL] == 0) {
            choisirL = (int) (Math.random() * (ligneMax + 1));
        }

        // Choix aléatoire du nombre de bâtons à retirer
        int choisirB = (int) (Math.random() * t[choisirL]) + 1;

        //Mise en place des conséquences du coup effectuer par l'ordi sur le jeu 
        System.out.println("L'ordinateur choisit de retirer " + choisirB + " bâtons à la ligne " + choisirL);
        t[choisirL] = t[choisirL] - choisirB;
        afficherJeu(t);

        // Vérification si le jeu doit continuer
        for (int i = 0; i < t.length; i++) {
            if (t[i] != 0) {
                besoinNouveauTourDeJeuIA = true;
            }
        }
        return besoinNouveauTourDeJeuIA;
    }

     /**
     * Gère le tour de l'ordinateur (IA simple qui choisit des coups aléatoires).
     * @param t Un tableau représentant l'état actuel des bâtons.
     * @return true si le jeu doit continuer, false si la partie est terminée.
     */
    boolean tourOrdiMoyen(int[] t) {
        boolean besoinNouveauTourDeJeuIA = false;
        int ligneMax = t.length - 1;
        int ligneAvecBaton = 0;

        //Verification du nombre de ligne restante
        for(int i = 0; i < t.length; i++){
            if(t[i] != 0){
                ligneAvecBaton++;
            }
        }

        //Changement de comportement de l'odri quand il reste 3 coups ou moins, l'ordi choisit les coups optimaux
        if(ligneAvecBaton <= 3) {

            //Appel de la fonction coupOpti qui donne le meilleur coup pour l'ordi si il est en situation gagnante
            int [] coupIA = coupOpti(t,ligneMax);
            int choisirB = coupIA[1];
            int choisirL = coupIA[0];

            //Mise en place des conséquences du coup effectuer par l'ordi sur le jeu 
            System.out.println("L'ordinateur choisit de retirer " + choisirB + " batons à la ligne " + choisirL);
            t[choisirL] = t[choisirL] - choisirB;
            System.out.println(" ");
            System.out.println(" ");
            afficherJeu(t);

            // Vérification si le jeu doit continuer
            for (int i = 0; i < t.length; i++) {
                if (t[i] != 0) {
                    besoinNouveauTourDeJeuIA = true;
                }
            }
        } else {

            // Choix aléatoire d'une ligne où il reste des bâtons
            int choisirL = (int) (Math.random() * (ligneMax + 1));
            while (t[choisirL] == 0) {
                choisirL = (int) (Math.random() * (ligneMax + 1));
            }

            // Choix aléatoire du nombre de bâtons à retirer
            int choisirB = (int) (Math.random() * t[choisirL]) + 1;

            //Mise en place des conséquences du coup effectuer par l'ordi sur le jeu 
            System.out.println("L'ordinateur choisit de retirer " + choisirB + " bâtons à la ligne " + choisirL);
            t[choisirL] = t[choisirL] - choisirB;
            afficherJeu(t);

            // Vérification si le jeu doit continuer
            for (int i = 0; i < t.length; i++) {
                if (t[i] != 0) {
                    besoinNouveauTourDeJeuIA = true;
                }
            }
        }
        return besoinNouveauTourDeJeuIA;
    }

    /**
     * Tour de jeu optimal effectuer par l'ia quand elle arrive en fin de partie au niveau moyen ou quand ell est en niveau expert
     * param t[] ramène un tableau qui compte le nombre de baton par ligne
     * return besoinNouveauTourDeJeuIA un boolean qui permet de verifier si il y a besoin d'un nouveau tour de jeu après la fin du tour
     **/
     boolean tourOrdiExpert(int[] t) {
        boolean besoinNouveauTourDeJeuIA = false;
        int ligneMax = t.length - 1;

        //Appel de la fonction coupOpti qui donne le meilleur coup pour l'ordi si il est en situation gagnante
        int [] coupIA = coupOpti(t,ligneMax);
        int choisirB = coupIA[1];
        int choisirL = coupIA[0];

        //Mise en place des conséquences du coup effectuer par l'ordi sur le jeu 
        System.out.println("L'ordinateur choisit de retirer " + choisirB + " batons à la ligne " + choisirL);
        t[choisirL] = t[choisirL] - choisirB;
        System.out.println(" ");
        System.out.println(" ");
        afficherJeu(t);

        for (int i = 0; i < t.length; i++) {
            if (t[i] != 0) {
                besoinNouveauTourDeJeuIA = true;
            }
        }

        return besoinNouveauTourDeJeuIA;
    }
    /**
     * Cette méthode calcule le coup optimal pour un jeu d'allumettes (ou de bâtons), 
     * où l'ordinateur doit choisir une ligne d'allumettes et combien en retirer pour gagner. 
     * @param tableauJeu Un tableau représentant le nombre d'allumettes dans chaque ligne. Chaque élément du tableau est le nombre d'allumettes sur une ligne.                 
     * @param ligneMax   Le nombre maximal de lignes de jeu.
     * @return Un tableau contenant deux entiers :
     *         - L'indice de la ligne choisie (ligneChoisie).
     *         - Le nombre d'allumettes à retirer de cette ligne (nbAllumettesARetirer).
     */
    int [] coupOpti ( int [] tableauJeu, int ligneMax ){
        int xorTotal = 0;
        int ligneChoisie = -1;
        int nbAllumettesARetirer = 0;

        //Pour assurer que l'ordinateur effectue un coup valide et ne triche pas
        while (ligneChoisie < 0 || ligneChoisie > ligneMax || tableauJeu[ligneChoisie] == 0 || 1 > nbAllumettesARetirer || nbAllumettesARetirer > tableauJeu[ligneChoisie]) {

            // Permet de 
            for (int i = 0; i < tableauJeu.length; i ++) {
                xorTotal ^=  tableauJeu[i];
            }

            if(xorTotal == 0) {

                //Coup random car xorTotal est égale à 0 donc le joueur joue parfaitement donc l'ordi ne voit pas de coup gagnant dans l'immédiat	
                for (int i = 0; i < tableauJeu.length; i++){

                    if (tableauJeu[i]>0){
                        int allumettesARetirer = 1 + (int) (Math.random() * tableauJeu[i]);
                    }
                }
            } else {
                System.out.println("L'ordinateur voit désormais une situation gagnante!");

                //Coup intelligent car xorTotal n'est pas égale à 0 donc l'ordi voit qu'il peut gagner ( il cherche un coup qui met xorTotal à 0 pour que le joueur arrive sur une position perdante.
                for(int i = 0; i < tableauJeu.length; i++){

                    if(tableauJeu[i] > 0){
                        int allumettesRestantes = tableauJeu[i] ^ xorTotal;

                        if(allumettesRestantes < tableauJeu[i]){

                            ligneChoisie = i;
                            nbAllumettesARetirer = tableauJeu[i] - allumettesRestantes;
                        }
                    }
                }
            }

            // Pour assurer que l'ordinateur choisisse une ligne si un bug survient et il ne rentre pas dans le if else de départ
            if(ligneChoisie == -1){
                for(int i = 0; i < tableauJeu.length; i++){
                    if(tableauJeu[i] > 0){
                        ligneChoisie = i;
                        nbAllumettesARetirer = 1 + (int) (Math.random() * tableauJeu[i]);
                    }
                }
            }
        }
        return new int[]{ligneChoisie, nbAllumettesARetirer};
    }

    /**
    * méthode pour test à l'unitaire pour vérifier si la méthode tourOrdiFaible fonctionne correctement
    */
    void testTourOrdiFaible() {
        System.out.println();
        System.out.println("***testOrdiFaible");
        int [] t1 = {1,3,3,0,4};
        int [] t2 = {0,0,0,1};
        int [] t3 = {4,5,6};

        testCasTourOrdiFaible (t1,true);
        testCasTourOrdiFaible (t2,false);
        testCasTourOrdiFaible (t3,false);

    }

    /**
    * méthode pour test si l'ordinateur renvoie bien des valeurs corrects et ne fais pas planter le jeu pendant l'utilisation de la méthode TourOrdiFaible
    * @param int []t un tableau qui contient le nombre de baton par ligne
    * @param result le résultat attendu en boolean
    */
    void testCasTourOrdiFaible (int [] t, boolean result){
        boolean resExec;

        System.out.print("L'ordinateur va renvoyer une valeur aléatoire, si il reste des batons alors ce sera vrai : " + result + " \t : ");
        System.out.println("");
        resExec = tourOrdiFaible(t);

        if (resExec == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
    * méthode pour test à l'unitaire pour vérifier si la méthode coupOpti fonctionne correctement
    */
    void testCoupOpti() {
        System.out.println();
        System.out.println("***testCoupOpti");
        int [] t1 = {1,2};
        int [] t2 = {0,0,0,1};
        int [] t3 = {1,1};
        int [] t4 = {3,1};

        testCasCoupOpti (t2,3,t4);
        testCasCoupOpti (t1,1,t3);
    }

    /**
    * méthode pour test si l'ordinateur renvoie bien des valeurs correct et ne fais pas planter le jeu pendant l'appel de la méthode coupOpti
    * @param int []t un tableau qui contient le nombre de baton par ligne
    * @param int ligneMax renvoie la ligne maximum du tableau 
    * @param int []result le résultat attendu en tableau
    */
    void testCasCoupOpti (int [] t, int ligneMax, int[] result){

        System.out.print("L'ordinateur va renvoyer une valeur aléatoire, si il reste des baton alors ce sera vrai : "); 
        displayTab(result);  
        System.out.println(" \t : ");

        int[] resExec = coupOpti(t,3);
        System.out.println("");
        displayTab(resExec);
        System.out.println("");

        boolean tabEgale= true;

        for(int i = 0; i < resExec.length; i++){
            if(result[i] != resExec[i]){
                tabEgale= false;
            }
        }

        if (tabEgale) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

    /**
     * Affiche un tableau
     * @param int[]t
     **/
    void displayTab(int[] t){
        if(t.length == 0){
            System.out.print("{}");
        } else {
            int i = 0;

            System.out.print("{");

            while(i<t.length-1){
                System.out.print(t[i] + ",");
                i=i+1;
            }
            System.out.print(t[i]+"}");
        }

    }
}
