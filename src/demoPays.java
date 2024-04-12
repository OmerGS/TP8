import java.util.ArrayList;
import java.util.Scanner;

import pays.*;

public class demoPays {
    static ArrayList<Pays> paysList = new ArrayList<Pays>();
    
    final static String RESET = "\033[0m";  // Réinitialiser
    final static String RED = "\033[0;31m";  // Rouge
    final static String GREEN = "\033[0;32m";  // Vert
    final static String YELLOW = "\033[0;33m";  // Jaune
    final static String BLUE = "\033[0;34m";  // Bleu
    final static String CYAN = "\033[0;36m";  // Cyan
    final static String WHITE = "\033[0;37m";  // Blanc

    public static void main(String[] args) {
        Pays France = new Pays("France", 60000000, 551000);
        paysList.add(France);
        Pays Allemagne = new Pays("Allemagne", 80000000, 357592);
        paysList.add(Allemagne);
        Pays Autriche = new Pays("Autriche", 8901000, 83871);
        paysList.add(Autriche);
        Pays Belgique = new Pays("Belgique", 11589623, 30528);
        paysList.add(Belgique);
        Pays Espagne = new Pays("Espagne", 47329981, 505990);
        paysList.add(Espagne);
        Pays Italie = new Pays("Italie", 60550075, 301340);
        paysList.add(Italie);
        Pays PaysBas = new Pays("Pays-Bas", 17134872, 41526);
        paysList.add(PaysBas);

        System.out.println("\033[H\033[2J");
        System.out.println("Bonjour sur l'Atlas Numerique quelle pays cherchez-vous ?");
        System.out.println("1. Comparer");
        System.out.println("2. Chercher");

        Scanner choixScan = new Scanner(System.in);
        int choix = choixScan.nextInt();

        if(choix == 2){
            System.out.println("\033[H\033[2J");
            System.out.println("Entrez un pays");
            Scanner pays = new Scanner(System.in);
            String paysChercher = pays.nextLine();
            
            Pays paysRetourner = chercher(paysChercher);

            if(paysRetourner != null){
                System.out.println(paysRetourner.toString());
            } else {
                System.out.print(RED);
                System.out.println("Pas trouve");
                System.out.print(RESET);
            }
        } 

        else if(choix == 1){
            comparateur();
        }
    }


    public static void comparateur(){
        System.out.println("\033[H\033[2J");
        System.out.println("** COMPARATEUR **");

        System.out.print("Entrez le 1er pays : ");
        Scanner pays = new Scanner(System.in);
        String paysChercher = pays.nextLine();
        
        Pays pays1 = chercher(paysChercher);

        System.out.print("Entrez le 2eme pays : ");


        String paysChercher2 = pays.nextLine();
        Pays pays2 = chercher(paysChercher2);

        if(pays1 != null && pays2 != null){
            int retour = pays1.compareTo(pays2);
            if(retour == 1){
                System.out.println(BLUE + paysChercher + " a une plus grande surface que " + paysChercher2 + RESET);
            } else if(retour == -1){
                System.out.println(GREEN + paysChercher2 + " a une plus grande surface que " + paysChercher + RESET);
            } else if(retour == 0){
                System.out.println(YELLOW + paysChercher2 + " a la meme superficie que " + paysChercher + RESET);
            }
        } else {
            System.out.println(RED);
            System.out.println("Pays non reconnu");
            System.out.println(RESET);
        }
    }

    public static Pays chercher(String paysChercher){

            for(Pays cherche : paysList){
                if(cherche.getNom().equals(paysChercher)){
                    return(cherche);
                }
            }
            return null;
    }
}
