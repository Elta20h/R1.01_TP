/**
 * Programme pour compter les valeurs différentes dans un tableau
 * @author TARDY Elie
 */
class Exo3 {

    void principal() {
        testCompteDiffVal();
    }

/**
* Compte le nombre de valeurs différentes dans un tableau
* @param tab tableau d’entiers
* @return le nombre de valeurs différentes du tableau
*/
    int compteDiffVal(int[] tab) {
        int compteVal = 0;

        for (int i = 0; i < tab.length; i++) {
            boolean verif = false;
            int j = 0;

            // On parcourt les éléments avant i pour vérifier s'il y a un doublon
            while (j < i && verif == false) {
                if (tab[i] == tab[j]) {
                    verif = true;
                }
                j++;
            }

            // Si pas de doublon trouvé, on incrémente le compteur
            if (!verif) {
                compteVal++;
            }
        }

        return compteVal;
    }

/**
* La fonction pour faire des tests de la méthode compteDiffVal
+*/
    void testCompteDiffVal() {
        System.out.println();
        System.out.println("***testCompteDiffVal");
        int[] t1 = {0, 6, 9, 3, 2, 9, 4};
        int[] t2 = {7, 8, 5, 5, 9};
        int[] t3 = {1, 1, 1, 1, 1, 1};
        testCasCompteDiffVal(t1, 6);
        testCasCompteDiffVal(t2, 4); 
        testCasCompteDiffVal(t3, 1);
    }

    void testCasCompteDiffVal(int[] t, int result) {
        int resExec;
        System.out.print("Dans le tableau : ");
        displayTab(t);
        
        System.out.print("Il y a " + result + " nombres différents \t : ");
        resExec = compteDiffVal (t);
        
        if (resExec == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }

/**
* Méthode pour afficher le tableau
* @param t le tableau que l'on veut afficher
*/
    void displayTab(int[] t) {
        System.out.print("{");
        for (int i = 0; i < t.length; i++) {
            if (i < t.length - 1) {
                System.out.print(t[i] + ",");
            } else {
                System.out.print(t[i]);
            }
        }
        System.out.println("}");
    }
    
}
