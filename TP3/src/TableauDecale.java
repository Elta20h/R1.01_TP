/**
 * Le programme va permettre de décaler le tableau d'une case
 * @author Tardy Elie
 */


class TableauDecale {
	void principal() {
		
		int [] t = { 5, 7, 0, 6, 10, 8, 4, 1 };
		System.out.print ("Le tableau avant : ");
		displayTab(t);
		int tmp = t[t.length - 1];
		
		for(int i = t.length - 1 ; i > 0 ;i-- ){
			t[i] = t [i - 1];
		}
		t[0] = tmp;
		System.out.print ("Le tableau après le décalage : ");
		displayTab(t);
		
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
