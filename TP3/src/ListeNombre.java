/**
 * Le programme tire au sort entre 0 et 9 inclu et dit combien de fois il a eu un nombre
 * @author Tardy Elie
 */


class ListeNombre {
	
	void principal() {
		int valeur;
		int [] t = new int [10];
		System.out.print (" Le tableau avant les tirages : ");
		displayTab (t);
		
		for (int i = 0; i < 1000;i++){
			valeur = (int) (Math.random() * 10 );
			t[valeur] = t[valeur] + 1;
		}
		System.out.print (" Le tableau après les tirages : ");
		displayTab (t);
		
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

