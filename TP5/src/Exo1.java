/**
 * Programme pour déterminer si 2 tableaux sont différents
 * @author TARDY Elie
 */


class Exo1 {
	
	void principal () {
		testSontTousDiff();
		
		
	}
	
/**
* vérifie si deux tableaux n’ont aucune valeur commune
* @param tab1 premier tableau
* @param tab2 deuxième tableau
* @return vrai si les tableaux tab1 et tab2 n’ont aucune valeur commune, faux sinon
*/
	boolean sontTousDiff ( int [] tab1,int [] tab2){
		boolean result = true;
		int i = 0;
		
		while (i < tab1.length && result == true){
			int j = 0;
			while (j < tab2.length && result == true){
				if (tab1[i] == tab2[j]){
					result =false;
				}
				j++;
			}
			i++;
		}
		return result;
	}
	
/**
 * La fonction pour faire des test de la méthode sontTousDiff
 */
	
	void testSontTousDiff(){
		System.out.println ();
		System.out.println ("***sontTousDiff");
		int [] t1 = {0,6,9,3,2,9,4};
		int [] t2 = {7,8,5,5,9};
		int [] t3 = {1,1,1,1,1,1};
		testCasSontTousDiff(t1,t2,false);
		testCasSontTousDiff(t1,t3,true);
		testCasSontTousDiff(t2,t3,true);
	}
	
/**
 * méthode pour afficher le tableau
 * @param int [] t le tableau que l'on veut affcher
 */
 
	void displayTab(int[] t){
		int i = 0;
		System.out.print("{");
		while(i<t.length-1){
			System.out.print(t[i] + ",");
			i=i+1;
		}
		System.out.print(t[i]+"} ");
	}
	
/**
 * pour tester les cas qu'il y a dans test
 * @param int [] t1 et t2 les deux tableaux que l'on va vérifier
 * @param boolean result le resultat normalement attendu à la fin
 */	
	void testCasSontTousDiff(int [] t1,int [] t2,boolean result){
		boolean resExec;
		displayTab(t1);
		System.out.print("et ");
		displayTab(t2);
		System.out.print ( "sont tous différent : "+ result + " \t : ");
		resExec = sontTousDiff(t1,t2);
		if ( resExec == result ){
			System.out.println ("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
}	

