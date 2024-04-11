import java.util.ArrayList;
import java.util.Scanner;

import pays.*;

public class demoPays {
    static ArrayList<Pays> paysList = new ArrayList<Pays>();

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

        System.out.println("Bonjour sur l'Atlas Numerique quelle pays cherchez-vous ?");
        System.out.println("1. Comparer ! ");
        System.out.println("2. Chercher ! ");

        Scanner choixScan = new Scanner(System.in);
        int choix = choixScan.nextInt();

        if(choix == 2){
            System.out.println("\033[H\033[2J");
            Scanner pays = new Scanner(System.in);
            String paysChercher = pays.nextLine();
            
            Pays paysRetourner = chercher(paysChercher);

            if(paysRetourner != null){
                System.out.println(paysRetourner.toString());
            } else {
                System.out.println("Pas trouve");
            }
        } 

        else if(choix == 1){
            comparateur();
        }
    }


    public static void comparateur(){
        System.out.println("\033[H\033[2J");
        System.out.println("** COMPARATEUR **");

        System.out.println("Entrez le 1er pays");
        Scanner pays = new Scanner(System.in);
        String paysChercher = pays.nextLine();
        
        Pays pays1 = chercher(paysChercher);

        System.out.println("Entrez le 2eme pays");


        String paysChercher2 = pays.nextLine();
        Pays pays2 = chercher(paysChercher2);

        if(pays1 != null && pays2 != null){
            int retour = pays1.compareTo(pays2);
            if(retour == 1){
                System.out.println(paysChercher + " a une plus grande surface que " + paysChercher2);
            } else if(retour == -1){
                System.out.println(paysChercher2 + " a une plus grande surface que " + paysChercher);
            } else if(retour == 0){
                System.out.println(paysChercher2 + " a la meme superficie que " + paysChercher);
            }
        } else {
            System.out.println("Pays non reconnu");
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
