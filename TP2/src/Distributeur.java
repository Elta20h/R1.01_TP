/**
 * Ce programme va simuler un distributeur automatique
 * @author Tardy Elie
 */

class Distributeur{
	
	void principal() {
		int  prix;
		int montant1 = 0;
		int montant;
		int monnaie = 0;
		int nbbillet1 = 0;
		int nbbillet2 = 0;
		int nbbillet3 = 0;
		int nbbillet4 = 0;
		int nbpiece1 = 0;
		int nbpiece2 = 0;
		
			prix = SimpleInput.getInt ("Veuillez saisir le prix du produit ");
			montant = SimpleInput.getInt ("Veuillez entrer de l'argent : ");
			
			if ( prix > 0 && montant > 0) {
				montant1 = montant + montant1;
			
			do {	
			if ( montant >= 0 && prix > montant){
			montant = SimpleInput.getInt ("Rajoutez de l'argent : ");
		}
		montant1 = montant + montant1;
			
				} while ( prix > montant1 && montant1 > 0 );
				monnaie = montant1 - prix;
			
			if ( monnaie >= 0 ){
				System.out.print ("Produit acheté et ");
			}
			
			if ( monnaie == 0){
				System.out.print ("pas de rendu de monnaie.");
			}
			
			
				System.out.println ("le distributeur vous rend ");
			
			while ( monnaie >= 50 ){
				monnaie = monnaie - 50;
				nbbillet1 = nbbillet1 + 1;
				if (monnaie < 50){
					if (nbbillet1 == 1){
					System.out.println ("- "+nbbillet1 + " billet de 50€");
				} else {
					System.out.println ("- "+nbbillet1 + " billets de 50€");
				}
			}
		}
			
			while ( monnaie >= 20 ){
				monnaie = monnaie - 20;
				nbbillet2 = nbbillet2 + 1;
				if (monnaie < 20){
					if (nbbillet2 == 1){
					System.out.println ("- "+ nbbillet2 + " billet de 20€");
				} else { 
					System.out.println ("- "+ nbbillet2 + " billets de 20€");
				}
			}
		}
		
			while ( monnaie >= 10 ){
				monnaie = monnaie - 10;
				nbbillet3 = nbbillet3 + 1;
				if (monnaie < 10){
					if (nbbillet3 == 1){
					System.out.println ("- "+ nbbillet3 +" billet de 10€");
				} else {
					System.out.println ("- "+ nbbillet3 +" billets de 10€");
				}
			}
		}
		
			while ( monnaie >= 5 ){
				monnaie = monnaie - 5;
				nbbillet4 = nbbillet4 + 1;
				if (monnaie < 5){
					if ( nbbillet4 == 1){
					System.out.println ("- "+ nbbillet4 +" billet de 5€");
				} else {
					System.out.println ("- "+ nbbillet4 +" billets de 5€");
				}
			}
		}
					
					
					while ( monnaie >= 2 ){
				monnaie = monnaie - 2;
				nbpiece1 = nbpiece1 + 1;
				if (monnaie < 2){
					if ( nbpiece1 == 1){
						System.out.println ("- "+ nbpiece1 +" pièce de 2€");
					} else {
						System.out.println ("- "+ nbpiece1 +" pièces de 2€");
					}
				}
			}
			while ( monnaie >= 1 ){
				monnaie = monnaie - 1;
				nbpiece2 = nbpiece2 + 1;
				if (monnaie < 1){
					System.out.println ("- 1 pièce de 1€");
				}
			}
			
		} else {
			System.out.println ("valeur invalide");
		}
		
	}
}
