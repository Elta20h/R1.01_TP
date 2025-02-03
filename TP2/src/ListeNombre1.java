/**
 * Le programme doit demander à l'utilisateur de choisir une suite de nombre et il doit lui préciser que pour arrêter il faut mettre -1
 * @author Tardy Elie
 */


class ListeNombre1 {
	
	void principal() {
		double liste ;
		do {
			liste = SimpleInput.getDouble ("veuillez saisir votre liste de nombre et pour arrêter la saisie entré le chiffre -1 : ");
			if (liste != -1 ){
			System.out.println ( liste );
			} else { 
			System.out.println ( "Vous avez fini votre liste de nombres");
			}
		} while ( liste != -1 );
		
		
		
	}
}
