/**
* Rôle à deviner
* @author M.Adam
*/
class ADeviner {
	void principal() {
		int val1;
		int val2;
		
		do {
			val1 = SimpleInput.getInt ("Première valeur obligatoirement positif : ");
			val2 = SimpleInput.getInt ("Deuxième valeur obligatoirement positif : ");
			if (val2 > 0 && val1 > val2 ) {
				val1 = val1 - val2;
				} if (val1 > 0 && val2 > val1 ) {
					val2 = val2 - val1;
				} else { 
					System.out.println ("veuillez saisir des bonnes valeurs");
				}
					
			} while (val1 != val2);
					System.out.println("Le résultat est : " + val1);
				}
			}
