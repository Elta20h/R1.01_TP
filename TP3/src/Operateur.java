/**
 *Le programme doit redemander un entier tant que celui entré par l’utilisateur n’est pas strictement positif. Puis, tant que cet entier n’est pas égal à 1, le programme le divise par deux s’il est pair ou le multiplie par trois et lui ajoute un s’il est impair. Ce programme doit afficher le nombre d’étapes pour arriver à la valeur 1 et le nombre maximal rencontré en chemin. Par exemple, avec 7 comme nombre de départ : le nombre d’étapes doit être de 16 et le nombre max rencontré est 52. 
 *
 */

class Operateur {
	
	void principal () {
		int chiffreUser;
		int etape = 0;
		int chiffreMax = 0;
		int chiffreDebut;
		do {
			chiffreUser = SimpleInput.getInt ("Choisissez un chiffre positif ");
		} while (0 >= chiffreUser);
		
		chiffreDebut = chiffreUser;
		while ( chiffreUser != 1 ){
			if ( chiffreUser > chiffreMax ){
				chiffreMax = chiffreUser;
			}
			
			if ( chiffreUser % 2 == 0 ){
				chiffreUser = chiffreUser / 2;
			} else {
				chiffreUser = chiffreUser * 3 + 1;
			}
			etape++;
		}
		System.out.println ("Pour " + chiffreDebut + " le nombre d'étape doit être de " + etape + " et le nombre max rencontré est de " + chiffreMax);
			
		
	}
}

