/**
 * code pour de combien est la suite croissante la plus grande.
 * @author Tardy Elie
 */


class CroissanceN {
	
	void principal() {
		int [] t = {5,7,0,1,9,4,5,6,7,8,9,10};
		int i = 1;
		int longueur = 1;
		int longueurMax = 1;
		boolean fin = false;
		int valeurD = 0;
		int valeurF = 0;
		System.out.print ("Le tableau est le suivant : ");
		displayTab(t);
		
		while ( i < t.length && !fin ){
			if (t[i - 1] < t[i]){
				longueur = longueur + 1;
				valeurD = i- longueurMax;
				valeurF = i;
				
			if (longueurMax < longueur){
				longueurMax = longueur;
			}
		} else {
			
			longueur = 1;
			if (i+longueurMax > t.length){
				fin = true;
			}
		}
		i++;
	}
	System.out.println ("La suite croissante la plus grande du tableau est de : "+ longueurMax +" qui commence à l'indice " + valeurD + " jusqu'à l'indice " + valeurF);
}
void displayTab(int[] t){
	int i = 0;
	System.out.print("{");
	while(i<t.length-1){
		System.out.print(t[i] + ",");
		i=i+1;
		}
		System.out.println(t[i]+"}");
		}
		}	
			
			
			
