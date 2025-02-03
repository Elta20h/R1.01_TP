/**
 * Ce programme sert à dire strike spare ou autres score de bowling tout en évitant la fraude avec un nombre de quilles renversées impossible
 * @author Tardy Elie
 */
class Bowling {
    void principal() {
		int premierLancer;
		int deuxiemeLancer;
		
            premierLancer = SimpleInput.getInt ("Nombre de quilles renversées au premier lancer : ");
            

            // Vérifier la validité du nombre de quilles renversées au premier lancer
            if (premierLancer < 0 || premierLancer > 10) {
                System.out.println("Nombre incorrect");
                return;
            }

            // Si le premier lancer est un strike
            if (premierLancer == 10) {
                System.out.println("Strike !");
                return;
            }

            // Demander le nombre de quilles renversées au deuxième lancer
            deuxiemeLancer = SimpleInput.getInt ("Nombre de quilles renversées au deuxième lancer : ");
          

            // Vérifier la validité du nombre de quilles renversées au deuxième lancer
            if (deuxiemeLancer < 0 || deuxiemeLancer > 10 || (premierLancer + deuxiemeLancer > 10)) {
                System.out.println("Nombre incorrect");
                return;
            }

            // Vérifier si le deuxième lancer est un spare
            if (premierLancer + deuxiemeLancer == 10) {
                System.out.println("Spare");
            } else {
                // Afficher le nombre total de quilles renversées
                System.out.println("Nombre total de quilles renversées : " + (premierLancer + deuxiemeLancer));
            }
		}
	}
