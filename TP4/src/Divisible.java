/**
 * Le programme va servir à savoir si un nombre est diviseur d'un autre
 * @author Tardy Elie
 */


class Divisible {
	
	void principal() {
		int p;
		int q;
		do {
			p = SimpleInput.getInt ("choisissez un numérateur positif ");
			q = SimpleInput.getInt ("Choisissez un dénumérateur strictement positif ");
		} while ( 0 > p || 0 >= q );
		
		System.out.println ( estDiviseur (p,q) );
		testEstDiviseur();
	}
	
	
/**
* teste la divisibilité de deux entiers
* @param p entier positif à tester pour la divisibilité
* @param q diviseur strictement positif
* @return vrai ssi q divise p
*/
	boolean estDiviseur (int p, int q){
		boolean result;
		if ( p % q == 0 ){
			result = true;
		} else {
			result = false;
		}
		return result;
	}

/**
 * test la méthode de Cas diviseur
 */
 
	void testEstDiviseur(){
		System.out.println ();
		System.out.println ("*** testDiviseur() ");
		testCasEstDiviseur (6,3,true);
		testCasEstDiviseur (10,5,true);
		testCasEstDiviseur (5,5,true);
		testCasEstDiviseur (3,4,false);
	}
/**
 * test un appel de diviseur
 * @param p et q les deux valeurs qui servent pour la division à calculer
 * @param result le résultat attendu
 */
 
	void testCasEstDiviseur(int p,int q,boolean result){
		// Affichage
		System.out.print ( p + "divisible par " + q + " est "+ result + "\t : " );
		// Appel
		boolean resExec = estDiviseur(p,q);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
}

