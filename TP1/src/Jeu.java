/**
 * Ce programme est pour le jeu de Marienbad
 * 
 * @author EMERIAU Emilien et TARDY Elie
 *         Groupe : B
 */

class Jeu {
  int scoreJoeur1 = 0;
  int scoreJoueur2 = 0;

  String nickNameJoueur1 = SimpleInput.getString("Selectionnez votre pseudo : ");
  String nickNameJoueur2 = SimpleInput.getString("Selectionnez votre pseudo : ");

  void principal() {
    char choix;
    boolean continuer = true;
    do {
      choix = SimpleInput.getChar("Pour continuer à jouer, tapez 'o' ou 'O'");
      if (choix == 'o' || choix == 'O') {
        jeu();
        System.out.println("Le score est de " + scoreJoeur1 + " pour " + nickNameJoueur1 + " et de " +scoreJoueur2+" pour "+nickNameJoueur2);

      } else {
        continuer = false;
      }
    } while (continuer);
    System.out.println("Merci d'avoir joué !");
  }

void jeu() {
    boolean continuerJeu = true;
    int nbTour = 0;
    int nbBatons = 0;
    int [] tabJeu = paramJeu ();
   // System.out.println(tabJeu.length); vérification de la taille du tableau
    for (int i=0;i < tabJeu.length;i++){
    nbBatons += tabJeu[i];
   }

    while (continuerJeu) {
      nbTour++;
      if (nbTour % 2 == 0) {
        System.out.println("C'est au tour de " + nickNameJoueur2);
        continuerJeu = tourJeu(nbBatons,tabJeu);
        if (continuerJeu == false) {
          scoreJoueur2++;
          System.out.println(nickNameJoueur2 + " à gagné cette manche !");

        }
        nbTour++;
      } else {
        System.out.println("C'est au tour de " + nickNameJoueur1);
        continuerJeu = tourJeu(nbBatons,tabJeu);
        if (continuerJeu == false) {
          scoreJoeur1++;
          System.out.println(nickNameJoueur1 + " à gagné cette manche !");
        }
      }
    }
}

  int [] paramJeu(){
    int nbBatons = 1;
    int nbBatonParLignes = 1;
    int [] tabBatonsParLignes = new int [1];
    int nbLignes = 0;
    do{
      nbLignes = SimpleInput.getInt("Choisissez le nombre de lignes entre 3 et 15 : ");
    } while (3 > nbLignes || nbLignes > 15);
    tabBatonsParLignes = new int [nbLignes];
    for (int i = 0; i < tabBatonsParLignes.length; i++){
      tabBatonsParLignes[i] = nbBatonParLignes;
      nbBatonParLignes = nbBatonParLignes + 2;
      nbBatons = nbBatons + nbBatonParLignes;
    }
    afficherJeu (tabBatonsParLignes);
    return tabBatonsParLignes;
  }



  // affichage des batons
  void afficherJeu (int [] tabAffiche){
    for(int i = 0;i<tabAffiche.length;i++){
      for (int j = 0; j < tabAffiche[i]; j++) {
        if (j == 0) {
          System.out.print(i + ": ");
        }
        System.out.print(" | ");

      }
      System.out.println();
    }
  }


  // boucle de jeu pour qu'il continue
  boolean tourJeu(int nbBatons, int[] t) {
     boolean continuerJeu = true;
      int ligneMax = t.length - 1;

      int choisirL = SimpleInput.getInt("Choisissez une ligne entre 0 et " + ligneMax + " : ");
      while (choisirL < 0 || choisirL > ligneMax || t[choisirL] == 0) {
        choisirL = SimpleInput.getInt("Choisissez vraiment une ligne entre 0 et " + ligneMax + " où il reste des batons : ");
      }
      int choisirB = SimpleInput.getInt("Choisissez un nombre de batons à retirer entre 1 et " + t[choisirL] + " : ");
      while (1 > choisirB || choisirB > t[choisirL]) {
      choisirB = SimpleInput.getInt("Choisissez un nombre de batons à retirer vraiment  entre 1 et " + t[choisirL] + " : ");
      }

      t[choisirL] = t[choisirL] - choisirB;
      afficherJeu(t);
      continuerJeu = false;
      for (int i = 0; i < t.length; i++){
        if (t[i] != 0){
          continuerJeu = true;
        }
      }
    return continuerJeu;
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

