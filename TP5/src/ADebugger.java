/**
* Compte le nombre de jours entre deux dates
* @author Stagiaire LN
*/
class ADebugger {
    void principal() {
        int total = nbJour(1, 1, 2020, 2, 1, 2020);
        System.out.println(total);
    }

    /**
     * Programme qui sert à savoir si une année est bissextile ou pas
     * @param annee c'est l'année choisie pour savoir
     * @return boolean qui renvoie vrai si l'année est bissextile
     */
    boolean bisextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }

    /**
     * Programme pour obtenir le nombre de jours dans une année
     * @param annee c'est l'année
     * @return int nombre de jours pour l'année
     */
    int nbjAnnee(int annee) {
        return bisextile(annee) ? 366 : 365;
    }

    /**
     * Programme pour obtenir le nombre de jours dans un mois donné
     * @param mois c'est le mois (1 à 12)
     * @param annee l'année pour vérifier si elle est bissextile ou non
     * @return le nombre de jours dans ce mois
     */
    int nbjMois(int mois, int annee) {
        switch (mois) {
            case 2:
                return bisextile(annee) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    /**
     * Méthode pour calculer le nombre de jours entre deux dates
     * @param jour1 le jour de la première date
     * @param mois1 le mois de la première date
     * @param annee1 l'année de la première date
     * @param jour2 le jour de la deuxième date
     * @param mois2 le mois de la deuxième date
     * @param annee2 l'année de la deuxième date
     * @return le nombre de jours entre les deux dates
     */
    int nbJour(int jour1, int mois1, int annee1, int jour2, int mois2, int annee2) {
        int nb = 0;

        // Si les deux dates sont dans la même année
        if (annee1 == annee2) {
            if (mois1 == mois2) {
                // Si les deux dates sont dans le même mois
                return jour2 - jour1;
            } else {
                // Jours restants dans le premier mois
                nb += nbjMois(mois1, annee1) - jour1;

                // Ajouter les jours des mois intermédiaires
                for (int i = mois1 + 1; i < mois2; i++) {
                    nb += nbjMois(i, annee1);
                }

                // Ajouter les jours du mois final
                nb += jour2;
            }
        } else {
            // Jours restants dans la première année
            nb += nbjMois(mois1, annee1) - jour1;

            // Ajouter les jours des mois restants de la première année
            for (int i = mois1 + 1; i <= 12; i++) {
                nb += nbjMois(i, annee1);
            }

            // Ajouter les jours pour les années intermédiaires
            for (int i = annee1 + 1; i < annee2; i++) {
                nb += nbjAnnee(i);
            }

            // Ajouter les jours des mois avant le mois final dans l'année finale
            for (int i = 1; i < mois2; i++) {
                nb += nbjMois(i, annee2);
            }

            // Ajouter les jours du mois final dans l'année finale
            nb += jour2;
        }

        return nb;
    }
}
