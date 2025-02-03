/**
 * code pour de combien est la suite croissante la plus grande.
 * @author Tardy Elie
 */


class Croissance {
	
	void principal() {
		int [] t = {5,7,0,1,2,4,5,6,7,3};
		int i = 1;
		int longueur = 1;
		int longueurMax = 1;
		boolean fin = false;
		int valeurD;
		int valeurF;
		System.out.print ("Le tableau est le suivant : ");
		displayTab(t);
		
		while ( i < t.length && !fin ){
			if (t[i - 1] < t[i]){
				longueur = longueur + 1;
				
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
	System.out.println ("La suite croissante la plus grande du tableau est de : "+ longueurMax );
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
			
			
			
