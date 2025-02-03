/**
 * Code pour saisir des valeaur dans un tableau et le trier
 * @author TARDY Elie
 */

class Exo5 {
	
	void principal() {
		int[] tableauTrie = saisirEtTrier();
		System.out.print("Le tableau après le trie: ");
		displayTab(tableauTrie);
	}
	
	/**
	 * Crée et saisit un tableau trié de LG_TAB entiers
	 * @return tableau trié de LG_TAB entiers
	 */
	int[] saisirEtTrier () {
		int LG_TAB;
		do {
			LG_TAB = SimpleInput.getInt("Choisir la taille du tableau: ");
		} while (LG_TAB <= 0);
		
		int[] t = new int[LG_TAB];
		
		// Saisie des valeurs dans le tableau
		for (int i = 0; i < t.length; i++) {
			t[i] = SimpleInput.getInt("Entrer un entier: ");
		}
		System.out.print(" Le tableau avant le trie: ");
		displayTab(t);
		
		// Tri du tableau
		for (int i = 0; i < t.length - 1; i++) {
			for (int j = 0; j < t.length - i - 1; j++) {
				if (t[j] > t[j + 1]) {
					// Échange des valeurs
					int temp = t[j];
					t[j] = t[j + 1];
					t[j + 1] = temp;
				}
			}
		}
		
		// Retourne le tableau trié
		return t;
	}

/**
* Méthode pour afficher le tableau
* @param t le tableau que l'on veut afficher
*/
    void displayTab(int[] t) {
        System.out.print("{");
        for (int i = 0; i < t.length; i++) {
            if (i < t.length - 1) {
                System.out.print(t[i] + ",");
            } else {
                System.out.print(t[i]);
            }
        }
        System.out.println("}");
    }
}
