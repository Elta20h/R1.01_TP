/**
 * Le programme sert à saisir des nombres de manières croissante et dès que c'est en dessous de celui d'avant ça s'arrête
 * @author Tardy Elie 
 */


class ListeCroissante {
	void principal () {
		double nombre1 ;
		double nombre2 ;
		
		nombre1 = SimpleInput.getDouble ("Saisir un nombre : ");
		nombre2 = nombre1 - 1;
	 while (nombre1 > nombre2) {
		System.out.println ( nombre1 );
		nombre2 = nombre1;
		nombre1 = SimpleInput.getDouble ("Saisir un nombre plus grand que le précédent ");
	}
	System.out.println ("Vous avez mis un nombre plus petit que le précédent");
		
		
		
	}
}

