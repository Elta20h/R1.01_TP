/**
 * ce programme va servire à savoir si un tableau est croissant ou non
 * @author Tardy Elie
 */
 
 class TabCroissant {
	 void principal (){
		 testEstCroissant ();
	 }
/**
 * appel testCasEstCroissant
 */
 
	 void testEstCroissant (){
		 int [] t1 = { 1,1,3,4,6,7,9,34};
		 int [] t2 = { 1,1,3,4,8,7,9,34};
		 System.out.println ();
		 System.out.println ("***testEstCroissant");
		 testCasEstCroissant ( t1,true);
		 testCasEstCroissant ( t2 ,false);
	 }
	 
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
 * appel EstCroissant pour vérifier les résultats
 * @param int [] t le tableau que l'on va analyser
 * @param result le resultat que l'on doit obtenir
 */
	void testCasEstCroissant (int [] t,boolean result){
		 boolean resExec;
		 displayTab(t);
		 System.out.print ( " est un tableau croissant : "+ result + " \t : ");
		 resExec = estCroissant(t);
		 if ( resExec == result ){
			 System.out.println ("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
/**
* teste si les valeurs d’un tableau sont triées par ordre croissant
* @param t tableau d’entiers
* @return vrai ssi les valeurs du tableau sont en ordre croissant
*/
	boolean estCroissant(int [] t){
		int valeur = 0;
		boolean result = true;
		int i = 1;
		while (i < t.length && result != false) { 
			if ( t[i] >= t[valeur] ){
				i++;
				valeur++;
			} else {
				result = false;
			}
		}
		return result;
	}
	

}
