/**
 * Programme pour calculer les combinaisons avec les factorielle
 * @author Tardy Elie
 */
 
 class CombinaisonEtFactorielle {
	 
	 void principal (){
		 int n = SimpleInput.getInt (" Sélectionnez un chiffre entier positif pour n ");
		 int k = SimpleInput.getInt (" Sélectionnez un chiffre entier positif pour k ");
		 
		 while ( n < k || k < 0){
			 n = SimpleInput.getInt (" Sélectionnez un chiffre entier positif pour n ");
			 k = SimpleInput.getInt (" Sélectionnez un chiffre entier positif pour k ");
		 }
		 System.out.println ( " La factorielle de n est " + factorielle(n) );
		 System.out.println ( " La factorielle de k est " + factorielle(k) );
		 System.out.println ("Le résultat de la combinaison de n et k est "+combinaison (n , k));
		 testFactorielle ();
		 testCombinaison();
	 }
	 
	 int factorielle (int n){
		 int resultatF = 1;
		 while ( n > 0 ){
			 resultatF = resultatF * n;
			 n--;
		 }
		 return resultatF;
	 }
					  
/**
* calcul de la combinaison k parmi n
* @param n cardinalité de l’ensemble
* @param k nombre d’éléments dans n avec 0<=k<=n
* @return nombre de combinaisons de k parmi n
 */
	 int combinaison (int n, int k){
		 int resultatC = 0;
		 resultatC = factorielle(n) / ( factorielle(k) * factorielle( n - k ) );
		 return resultatC;
	 }
	 
/**
* Teste la méthode factorielle()
*/
	 void testFactorielle () {
		 System.out.println ();
		 System.out.println ("*** testFactorielle()");
		 testCasFactorielle (5, 120);
		 testCasFactorielle (0, 1);
		 testCasFactorielle (1, 1);
		 testCasFactorielle (2, 2);
	 }

/**
* test un appel de factorielle
* @param n valeur de la factorielle à calculer
* @param result resultat attendu
*/
	 void testCasFactorielle (int n, int result) {
		 // Affichage
		 System.out.print ("factorielle (" + n + ") \t= " + result + "\t : ");
		 // Appel
		 int resExec = factorielle(n);
		 // Verification
		 if (resExec == result){
			 System.out.println ("OK");
		 } else {
			 System.err.println ("ERREUR");
		 }
	 }
	 
	 void testCombinaison(){
		 System.out.println ();
		 System.out.println ("*** testCombinaison()");
		 testCasCombinaison (7,6,7);
		 testCasCombinaison (3, 2,3);
		 testCasCombinaison (5, 4, 5);
		 testCasCombinaison (9, 8, 9);
	 }
/**
 * test appel combinaison
 * @param n et k valeurs de la combinaison à calculer
 * result qui dis le résultat attendu
 */
	 
	 void testCasCombinaison(int n, int k, int result ) {
		 // Affichage
		 System.out.print ("Combinaison (" + n + ") et (" + k + ") \t= " + result + "\t : ");
		 // Appel
		 int resExec = combinaison(n,k);
		 // Verification
		 if (resExec == result){
			 System.out.println ("OK");
		 } else {
			 System.err.println ("ERREUR");
		 }
	 }
 }
	 
 
 

