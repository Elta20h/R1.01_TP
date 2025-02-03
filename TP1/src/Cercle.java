/**
 * Ce programme va servir à calculer le périmètre et l'air d'un cercle.
 * @author Tardy Elie
 */
class Cercle {1
	void principal() {
		double rayon;
		
		rayon = SimpleInput.getInt ("Le rayon est :");
        
        double perimetre = 2 * Math.PI * rayon;
        
        double aire = Math.PI * rayon * rayon;
        
        
        System.out.println("Le périmètre du cercle est : " + perimetre);
        System.out.println("L'aire du cercle est : " + aire);
    }
}
