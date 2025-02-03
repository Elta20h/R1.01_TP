/**
 * Le programme doit demander à l'utilisateur de choisir une suite de nombre et il doit lui préciser que pour arrêter il faut mettre -1 et une fois cela fais il fait une moyenne
 * @author Tardy Elie
 */


class ListeNombre2 {
	
	void principal() {
		double liste ;
		int n = 1;
		double moyenne = 0;
		double nbNombre = 1;
		double totalNombre = 0;
		
		liste = SimpleInput.getDouble ("veuillez saisir votre liste de nombre et pour arrêter la saisie entré le chiffre -1 : ");
		
		while ( liste != -1 ) {
			liste = SimpleInput.getDouble ("veuillez saisir votre liste de nombre et pour arrêter la saisie entré le chiffre -1 : ");
			if (liste != -1 ){
			System.out.println ( liste );
			totalNombre = totalNombre + liste;
			nbNombre = nbNombre * n;
			n = n + 1;
			} 
			
			
		}
		System.out.println ( "Vous avez fini votre liste de nombres");
		moyenne = totalNombre / nbNombre;
		System.out.println (" La moyenne des nombres est : " + moyenne);
		
		
		
	}	
}
