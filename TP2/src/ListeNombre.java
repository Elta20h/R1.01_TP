/**
 * Le programme doit demander à l'utilisateur de choisir une suite de nombre et il doit lui préciser que pour arrêter il faut mettre -1
 * @author Tardy Elie
 */


class ListeNombre {
	
	void principal() {
		double liste ;
		liste = SimpleInput.getDouble ("veuillez saisir votre liste de nombre et pour arrêter la saisie entré le chiffre -1 : ");
		while ( liste != -1 ) {
			if (liste != -1 ){
			liste = SimpleInput.getDouble ( "saisissez vos chiffre : ");
			if (liste != -1 ){
			System.out.println ( liste );
		}
			
			} 
			
			
		}
		System.out.println ( "Vous avez fini votre liste de nombres");
		
		
		
	}
}
