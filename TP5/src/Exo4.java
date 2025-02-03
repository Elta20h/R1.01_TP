/**
 * code pour voir les chaines de caractères qui se répète
 * @author TARDY Elie
 */

class Exo4 {
/**
 * là où l'on va appeler le testEstSousChaine
 */
	
	void principal() {
		testEstSousChaine();
    }

/**
 * Teste si une chaîne est une sous-chaîne d'une autre.
 * @param mot chaîne de caractères
 * @param phrase chaîne de caractères
* @return vrai si mot est présent dans phrase
*/
    boolean estSousChaine(String mot, String phrase) {
        int longueurMot = mot.length();
        int longueurPhrase = phrase.length();

        // Parcours de la phrase
        for (int i = 0; i <= longueurPhrase - longueurMot; i++) {
            // Comparaison caractère par caractère
            int j;
            for (j = 0; j < longueurMot; j++) {
                if (phrase.charAt(i + j) != mot.charAt(j)) {
                    break;
                }
            }
            // Si le mot est trouvé, retourner vrai
            if (j == longueurMot) {
                return true;
            }
        }
        return false;
    }
 
/**
 * méthode pour test à l'unitaire pour vérifier si le code marche
 */
    void testEstSousChaine() {
		System.out.println();
        System.out.println("***testEstSousChaine");
        testCasEstSousChaine ( "ses","abcdsesdef",true);
        testCasEstSousChaine ( "ses","abcdef",false);
        testCasEstSousChaine ("ses","abcdefse",false);
	}
/**
 * méthode pour test chaque cas
 * @param String mot et chaine ce sont les valeur que l'on va tester
 * @param result le résultat attendu en boolean
 */
	void testCasEstSousChaine (String mot,String chaine,boolean result){
		boolean resExec;
        
        System.out.print("La suite " + mot + " est sous chaine de  "+chaine+" : "+result+" \t : ");
        resExec = estSousChaine(mot,chaine);
        
        if (resExec == result) {
            System.out.println("OK");
        } else {
            System.out.println("ERREUR");
        }
    }


}
