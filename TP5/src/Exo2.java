/**
 * Code pour décaler les valeurs de tableaux vers la gauche
 * @author TARDY Elie
*/


class Exo2 {
	
	void principal() {
		int [] t = {3,10,6,20,7};
		int [] t1 = {3,10,6,20,7};
		int [] t2 = {3,10,6,20,7};
		int [] t3 = {3,10,6,20,7};
		int nFois;
		int v;
		int resultOcc;
		int changeVal;
		
		System.out.print ("Le tableau avant le décalage ");
		displayTab (t);
		decalerGauche (t);
		System.out.print ("Le tableau après le décalage ");
		displayTab(t);
		System.out.print ("voici le tableau avant le décalage : ");
		displayTab(t1);
		do {
			nFois = SimpleInput.getInt ("Choisissez le nombre de fois que vous voulez décaler le tableau : ");
			if (nFois > 0){
				System.out.println ("le tableau va être décaler de "+nFois+" fois");
			}
		} while ( nFois < 0 );
		decalerGaucheN (t1,nFois);
		System.out.print("voici le tableau après le décalage de "+nFois+" fois : ");
		displayTab(t1);
		v = SimpleInput.getInt("Choisissez une valeur que vous voulez vérifier dans le tableau ");
		System.out.print("On cherche si le nombre "+v+" est dans le tableau et si oui à quel indice sinon cela renverra -1 : ");
		displayTab(t2);
		resultOcc = indiceTab(t2,v);
		System.out.println (" Le résultat est : "+resultOcc);
		System.out.print ("Ceci est le tableau avant le changement de valeur : ");
		displayTab(t3);
		decaleValeur (t3,resultOcc);
		System.out.print ("Le tableau après le changement : ");
		displayTab(t3);
		
	}
/**
* décale les entiers d’un tableau d’une position vers la gauche
* L’élément en 0 se retrouve à la fin du tableau
* @param tab tableau d’entiers
*/
	void decalerGauche (int [] tab){
		int valTemp = tab[0];
		
		for (int i = 0; i < tab.length - 1;i++){
			tab[i] = tab[i + 1];
		}
		tab [tab.length - 1] = valTemp;
	}
	void decalerGaucheN (int [] tab,int n){
		for (int fois = 0; fois < n; fois++){
			decalerGauche (tab);
			
		}
	}
/**
 * Cherche l’indice de la première occurrence d’une valeur dans un tableau
 * @param tab tableau d’entiers
 * @param v valeur à chercher
 * @return l’indice de la première valeur v dans tab si v est dans tab, -1 sinon
 */
	int indiceTab(int[] tab, int v) {
		int result = -1;
		
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == v) {
				result = i;
				
			}
		}
		return result;
	}
/**
* décale les valeurs d’un tableau de manière à ramener la valeur cherchée
* à l’indice 0
* Si la valeur n’est pas présente, le tableau n’est pas modifié
* @param tab tableau d’entiers
* @param v valeur à chercher
*/
	void decaleValeur (int [] tab, int v){
		int valTemp = tab[0];
		int valTab;
		while (v == -1){
			valTab = SimpleInput.getInt ("choisissez un valeur du tableau ");
			v = indiceTab(tab,valTab);
		}
		tab[0] = tab[v];
		tab[v] = valTemp;
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
		System.out.println(t[i]+"} ");
	}
}

