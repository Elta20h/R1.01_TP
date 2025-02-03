/**
 * programme pour tester la péthode qui vérifie si un nombre est parfait ou non
 * @author Tardy Elie
 */

class DivibleParfait {
	
	void principal() {
		int p;
		do {
			p = SimpleInput.getInt ("choisissez un numérateur positif ");
		} while ( p < 0 );
		
		System.out.println (p + " est-il un nombre parfait ? ");
		System.out.println (estParfait(p));
		testEstParfait();
		quatreNbParfaits();
	}
/**
* teste si un nombre est parfait
* @param a entier positif
* @return vrai ssi a est un nombre parfait
*/
	boolean estParfait ( int p ){
		boolean result;
		int total = 0;
		for ( int n = p - 1 ; n > 0 ; n-- ){
			if ( p % n == 0 ){
				total = total + n;
			}
		}
		if ( total == p ){
			result = true;
		} else {
			result = false;
		}
		return result;
	}
/**
 * appel testCasEstParfait 
 */
	
	void testEstParfait (){
		System.out.println ();
		System.out.println ("*** testEstParfait()");
		testCasEstParfait (6,true);
		testCasEstParfait (10,false);
		testCasEstParfait (28,true);
		testCasEstParfait (496,true);
	}

/**
 * test un appel de estParfait
 * @param p la valeur à calculer
 * @param resultat le resultat attendu
 */
  
	void testCasEstParfait (int p,boolean resultat){
		System.out.print ( p + " nombre parfait : " + resultat + " \t : " );
		boolean resExec = estParfait ( p );
		if ( resultat == resExec ){
			System.out.println ( "OK" );
		} else {
			System.out.println ("ERREUR");
		}
	}

/**
 * trouver les quatres premiers nombres parfaits existants
 */
 
	void quatreNbParfaits() {
		System.out.println("*** Affichage des quatre premiers nombres parfaits ***");
		int nbParfaits = 0; // Compte le nombre de nombres parfaits trouvés
		int i = 1; // Démarre à 1 pour tester chaque entier
		while (nbParfaits < 4) {
			if (estParfait(i)) {
				System.out.println(i + " est un nombre parfait.");
				nbParfaits++;
			}
			i++;
		}
	}
}

