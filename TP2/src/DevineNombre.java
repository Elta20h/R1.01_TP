/**
 * Ce programme choisit un chiffre aléatoire et l'utilisateur doit le deviner
 * @author Tardy Elie 
 */
class DevineNombre {
    void principal() {
        int min = 0;
        int max = 1000;
        int tentatives = 0;
        boolean nombreTrouve = false;
        int entre2;
        
        System.out.println("Pensez à un nombre entre 0 et 1000.");
        while (!nombreTrouve) {
            int guess = (min + max) / 2;
            tentatives++;
            System.out.println("Je propose : " + guess);
            System.out.print("Votre réponse (+ si trop petit, - si trop grand, = si correct) : ");
            
            char reponse = SimpleInput.getChar("");
            
            if (reponse == '=') {
                if (tentatives == 1) {
                    System.out.println("J'ai trouvé votre nombre du premier coup !!!!!!!");
                    nombreTrouve = true;
                } else {
                    System.out.println("J'ai trouvé votre nombre " + guess + " en " + tentatives + " tentatives!");
                    nombreTrouve = true;
                }
                
            } else if (reponse == '+') {
                min = guess + 1;
            } else if (reponse == '-') {
                max = guess - 1;
            } else {
                System.out.println("Réponse non valide... Donc j'arrête.");
                nombreTrouve = true;
                
            }
        }
    }
}
