/**
 * Ce programme implémente un jeu de Marienbad, où deux joueurs retirent des bâtons à tour de rôle.
 * Le gagnant est le joueur qui prend le dernier baton.
 * @author EMERIAU Emilien et TARDY Elie
 * Groupe : B1
 **/
class MarienbadJvsJ_Tardy_Emeriau {

  // Variables de score pour les deux joueurs
  int scoreJoueur1 = 0;
  int scoreJoueur2 = 0;

  String stopPseudo = " ";
  /**
  * Méthode principale du programme. Elle permet de lancer une nouvelle partie, affiche les scores et 
  * arrête le jeu si le joueur le décide.
  **/
  void principal() {

    // Les pseudos des joueurs sont demandés au début du jeu
    String nickNameJoueur1 = SimpleInput.getString("Selectionnez le pseudo du premier joueur : ");
    while(nickNameJoueur1.equals(stopPseudo)){
      nickNameJoueur1 = SimpleInput.getString("Selectionnez le pseudo du premier joueur (pas un espace) : ");
    }
    String nickNameJoueur2 = SimpleInput.getString("Selectionnez le pseudo du deuxième joueur : ");
    while(nickNameJoueur1.equals(nickNameJoueur2) || nickNameJoueur2.equals(stopPseudo)){
      nickNameJoueur2 = SimpleInput.getString("Selectionnez le pseudo du deuxième joueur (pas un espace et différent du premier joueur): ");
    }
    char choix;
    boolean continuer = true;
    jeu(nickNameJoueur1,nickNameJoueur2);

    // Boucle principale permettant de rejouer ou d'arrêter le jeu
    do {
      choix = SimpleInput.getChar("Pour lancer une partie, tapez : '!'");
      if (choix == '!') {
        jeu(nickNameJoueur1,nickNameJoueur2); // Lance une nouvelle partie

        // Affiche le score de chaque joueur après une partie (seulement après la 2ème partie car non nécessaire si il n'y en à qu'une)
        System.out.println("Le score est de " + scoreJoueur1 + " pour " + nickNameJoueur1 + " et de " + scoreJoueur2 + " pour " + nickNameJoueur2);
      } else {
        continuer = false; // Arrête la boucle et donc le jeu
      }
    } while (continuer);

    // Messages de fin
    System.out.println("Merci d'avoir joué !");
    System.out.println("A la prochaine !");
  }

  /**
  * Gère une partie complète, alternant entre les deux joueurs jusqu'à ce que l'un d'eux gagne.
  * Le score du joueur gagnant est incrémenté.
  **/
  void jeu(String nickNameJoueur1, String nickNameJoueur2) {
    boolean continuerJeu = true;
    int nbTour = 0;
    int nbBatonsTotal = 0;

    // Paramètre initial du jeu (nombre de lignes et bâtons)
    int[] tabJeu = paramJeu();

    // Calcul du nombre total de bâtons dans le jeu
    for (int i = 0; i < tabJeu.length; i++) {
      nbBatonsTotal += tabJeu[i];
    }

    // Boucle principale de la partie (chaque joueur joue à tour de rôle)
    while (continuerJeu) {
      nbTour++;

      if (nbTour % 2 == 0) {
        // Tour du joueur 2
        System.out.println("C'est au tour de " + nickNameJoueur2 + " : ");
        continuerJeu = tourJeu(tabJeu);

        if (!continuerJeu) {
          scoreJoueur2++; // Joueur 2 gagne
          System.out.println(nickNameJoueur2 + " a gagné cette partie !");
        }
      } else {
        // Tour du joueur 1
        System.out.println("C'est au tour de " + nickNameJoueur1 + " : ");
        continuerJeu = tourJeu(tabJeu);

        if (!continuerJeu) {
          scoreJoueur1++; // Joueur 1 gagne
          System.out.println(nickNameJoueur1 + " a gagné cette partie !");
        }
      }
    }
  }

  /**
  * Initialise les paramètres du jeu (nombre de lignes et bâtons par ligne).
  * 
  * @return un tableau représentant le nombre de bâtons par ligne.
  **/
  int[] paramJeu() {
    int nbBatonsTabDeJeu = 1;
    int nbBatonParLignes = 1;
    int[] tabBatonsParLignes = new int[1];
    int nbLignes = 0;

    // Demande à l'utilisateur de choisir un nombre de lignes entre 2 et 15
    nbLignes = SimpleInput.getInt("Choisissez le nombre de lignes entre 2 et 15 inclus : ");
    while (2 > nbLignes || nbLignes > 15) {
      nbLignes = SimpleInput.getInt("On a dit un nombre entre 2 et 15 inclus petit chenapan : ");
    }

    // Initialise le tableau représentant les bâtons par ligne
    tabBatonsParLignes = new int[nbLignes];

    for (int i = 0; i < tabBatonsParLignes.length; i++) {
      tabBatonsParLignes[i] = nbBatonParLignes;
      nbBatonParLignes += 2; // Augmente le nombre de bâtons par ligne
      nbBatonsTabDeJeu += nbBatonParLignes;
    }

    // Affiche le jeu initial
    System.out.println(" ");
    System.out.println(" ");
    afficherJeu(tabBatonsParLignes);
    return tabBatonsParLignes;
  }

  /**
  * Affiche le jeu sous forme de bâtons. Chaque ligne correspond à un certain nombre de bâtons. 
  * @param tabAffiche le tableau contenant le nombre de bâtons par ligne
  **/
  void afficherJeu(int[] tabAffiche) {
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
  * Effectue un tour de jeu pour le joueur actuel. Le joueur choisit une ligne et un nombre de bâtons à retirer.
  * @param t tableau représentant le nombre de bâtons restant par ligne
  * @return true si le jeu continue, false si le joueur a gagné (tous les bâtons ont été retirés)
  **/
  boolean tourJeu(int[] t) {
    boolean besoinNouveauTourDeJeu = false;
    int ligneMax = t.length - 1;

    // Le joueur choisit une ligne où retirer les bâtons
    int choisirL = SimpleInput.getInt("Choisissez une ligne entre 0 et " + ligneMax + " : ");
    while (choisirL < 0 || choisirL > ligneMax || t[choisirL] == 0) {
      choisirL = SimpleInput.getInt("Choisissez vraiment une ligne entre 0 et " + ligneMax + " où il reste des bâtons : ");
    }

    // Le joueur choisit combien de bâtons retirer
    int choisirB = SimpleInput.getInt("Choisissez un nombre de bâtons à retirer compris entre 1 et " + t[choisirL] + " inclus : ");
    while (choisirB < 1 || choisirB > t[choisirL]) {
      choisirB = SimpleInput.getInt("Choisissez un nombre de bâtons à retirer vraiment compris entre 1 et " + t[choisirL] + " inclus : ");
    }

    // Mise à jour du tableau
    t[choisirL] = t[choisirL] - choisirB;
    System.out.println(" ");
    System.out.println(" ");
    afficherJeu(t);

    // Vérifie si le jeu doit continuer (il reste des bâtons)
    for (int i = 0; i < t.length; i++) {
      if (t[i] != 0) {
        besoinNouveauTourDeJeu = true;
      }
    }
    return besoinNouveauTourDeJeu;
  }

  /**
  * Affiche le contenu d'un tableau d'entiers.
  * @param t tableau d'entiers à afficher
  **/
  void displayTab(int[] t) {
    if (t.length == 0) {
      System.out.print("{}");
    } else {
      int i = 0;
      System.out.print("{");

      while (i < t.length - 1) {
        System.out.print(t[i] + ",");
        i = i + 1;
      }
      System.out.print(t[i] + "}");
    }
  }
}
