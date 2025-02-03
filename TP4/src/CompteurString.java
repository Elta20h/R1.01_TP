/**
 * code pour compter le nombre de charactères qui se répètent 
 * @author TARDY Elie
 */



class CompteurString {
	
/**
* cherche combien de fois un caractère est présent dans une chaîne de caractères
* @param chaine Chaine de caractère
* @param car Caractere a rechercher
* @return nombre d’occurences de car dans chaine
*/

    int nbOcc(String chaine, char c) {
        int count = 0;
        for (int i = 0; i < chaine.length(); i++) {
            if (chaine.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

/**
* Méthode pour tester nbOcc avec quelques exemples de test
* appel testCasNbOcc
*/

    void testNbOcc() {
		System.out.println ();
		System.out.println ("***TestNbOcc");
        testCasNbOcc("hello", 'l', 2);
        testCasNbOcc("world", 'o',1);
        testCasNbOcc("java", 'a',2);
        testCasNbOcc("programming", 'g', 2);
        testCasNbOcc("test", 'z', 0);
	} 
    
/**
 * Méthode pour tester nbOcc avec des cas spécifiques
 * @param String mot le mot que l'on veux tester
 * @param char lettre la lettre que l'on cherche dans le mot
 * @param int result le nombre de fois que la lettre ce répète est attendu
 */
   
    void testCasNbOcc(String mot,char lettre, int result) {
		System.out.print (mot +" a "+ result +" fois la lettre "+lettre+" \t : ");
		int resExec = nbOcc(mot,lettre);
		if ( resExec == result ){
			System.out.println ("OK");
		} else {
			System.out.println ("ERREUR");
		}
		
    }

    void principal() {
        testNbOcc();
    }
}
