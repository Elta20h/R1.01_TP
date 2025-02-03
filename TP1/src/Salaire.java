/**
 * Ce programme va permettre de en entrant un salaire brut ressortir le salaire net
 * @author Tardy Elie
 */

class Salaire {
	
	void principal() {
		double salaireInitial;
		double salaireFinal;
		
		salaireInitial = SimpleInput.getDouble ("Rentrez votre salaire brut : ");
		
            // Vérifier si le salaire est correct ou non
            if ( salaireInitial < 0 ) {
                System.out.println("Salaire incorrect");
            } else {
                // Afficher le salaire brut
                System.out.println("Le salaire BRUT : " + ( salaireInitial ));
                
                double assuranceMaladie = salaireInitial * 0.75 / 100 ;
                System.out.println ("le prélèvement de l'assurance maladie est de : " + assuranceMaladie);
                
                double assuranceVielleisseD = salaireInitial * 0.1 / 100 ;
                System.out.println ("le prélèvement de l'assurance vieillesse déplafonnée est de : " + assuranceVielleisseD);
                
                double assuranceVieillesseP = salaireInitial * 6.75 / 100 ;
                System.out.println ("le prélèvement de l'assurance vieillesse plafonnée est de : " + assuranceVieillesseP );
                
                double fraisPro = salaireInitial * 1.75 / 100 ;
                System.out.println ("le prélèvement des frais professionnels est de : " + fraisPro);
                
                double chomage = salaireInitial * 2.4 / 100 ;
                System.out.println ("le prélèvement du chômage maladie est de : " + chomage);
                
                double salaireFrais = salaireInitial - chomage - fraisPro - assuranceVieillesseP - assuranceVielleisseD - assuranceMaladie ;
                
                double crds = salaireFrais * 0.5 / 100 ;
                System.out.println ("le prélèvement du crds est de : " + crds);
                
                double contributionSocialG = salaireFrais * 7.5 / 100 ;
                System.out.println ("le prélèvement de la contribution sociale généralisée est de : " + contributionSocialG);
                
                double prelevement = salaireInitial - salaireFrais - crds - contributionSocialG ;
                
                System.out.println (" la totalité des prélèvement s'élevent à : "+prelevement);
                
                double salaireNet = salaireInitial - prelevement ;
                System.out.println ("le salaire net est de : " + salaireNet);
                
            }
		}
	}

