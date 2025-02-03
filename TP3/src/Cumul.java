/**
 * code pour faire un cumul d'un tableau
 * @author Tardy Elie
 */


class Cumul {
	
	void principal() {
		int [] t = {1,2,3,4,5,6,7};
		int [] cumul = new int[t.length];
		System.out.print ("Le tableau avant le cumul : ");
		displayTab(cumul);
		System.out.print ("Le tableau prit pour le cumul : ");
		displayTab (t);
		cumul[0] = t[0];
		
		for (int i = 1; i < t.length ;i++){
			cumul[i] = t[i - 1] + t[i];
		}
		System.out.print ("Le tableau après le cumul : ");
		displayTab(cumul);
	}
	void displayTab(int[] cumul){
		int i = 0;
		System.out.print("{");
		while(i<cumul.length-1){
			System.out.print(cumul[i] + ",");
			i=i+1;
			}
			System.out.println(cumul[i]+"}");
		}
	}

