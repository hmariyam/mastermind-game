// Importations
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariyam Hanfaoui, 2240026
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Création des objets couleurs
        Couleur rouge = new Couleur("Red", 'R');
        Couleur jaune = new Couleur("Yellow", 'Y');
        Couleur bleu = new Couleur("Blue", 'B');
        Couleur orange = new Couleur("Orange", 'O');
        Couleur vert = new Couleur("Green", 'G');
        Couleur rose = new Couleur("Pink", 'P');
        Couleur blanc = new Couleur("White", 'W');
        Couleur turquoise = new Couleur("Turquoise", 'T');
        
        // Démarre un jeu aléatoire
        Mastermind solution = new Mastermind();
        
        // Scanner pour les essais de l'utilisateur
        Scanner couleurs = new Scanner(System.in);
        
        // Consignes du jeu Mastermind
        System.out.println("Mastermind Game - Guess all the colors!");
        System.out.println("B corresponds to the right color at the right position");
        System.out.println("W corresponds to the right color but at the wrong position");
        System.out.println("You have 12 chances.");
        System.out.println("Here are the colors : Red, Yellow, Blue, Orange, Green, Pink, White, Turquoise");
        System.out.println("P.S You can enter the name of the color or just it's first letter (in caps or no caps).");
        
        // Boucle qui permet de saisir 12 fois les 5 couleurs
        int compteurTour = 0; // counter that increments each time a turn is done
        for (int i=0; i<12; i++) {
            // Déclaration d'une série pour la saisi des 5 couleurs de l'utilisateur
            Série utilisateur = new Série();
            for (int j=0; j < 5; j++){
                System.out.print("Enter a color : ");
                String couleur = couleurs.nextLine();
                if(couleur.equalsIgnoreCase("Red") || couleur.equalsIgnoreCase("R")){
                        utilisateur.ajouterCouleur(rouge);
                    }
                else if(couleur.equalsIgnoreCase("Yellow") || couleur.equalsIgnoreCase("Y")){
                        utilisateur.ajouterCouleur(jaune);
                    }
                else if(couleur.equalsIgnoreCase("Blue") || couleur.equalsIgnoreCase("B")){
                        utilisateur.ajouterCouleur(bleu);
                    }
                else if(couleur.equalsIgnoreCase("Orange") || couleur.equalsIgnoreCase("O")){
                        utilisateur.ajouterCouleur(orange);
                    }
                else if(couleur.equalsIgnoreCase("Green") || couleur.equalsIgnoreCase("G")){
                        utilisateur.ajouterCouleur(vert);
                    }
                else if(couleur.equalsIgnoreCase("Pink") || couleur.equalsIgnoreCase("P")){
                        utilisateur.ajouterCouleur(rose);
                    }
                else if(couleur.equalsIgnoreCase("White") || couleur.equalsIgnoreCase("W")){
                        utilisateur.ajouterCouleur(blanc);
                    }
                else if(couleur.equalsIgnoreCase("Turquoise") || couleur.equalsIgnoreCase("T")){
                        utilisateur.ajouterCouleur(turquoise);
                    }
                else {
                    System.out.println("This color doesn't exist in the list. Try again..");
                    // Décompte pour revenir en arrière afin de permettre à l'utilisateur de réessayer
                    j--;
                }
            }
            
            compteurTour++; // increment the round counter
            
            // Comparer la solution à celle de l'utilisateur et afficher son résultat
            System.out.println(solution.essayer(utilisateur));
            System.out.println(solution.toString());
            
            // Condition pour l'égalité de la série aléatoire de la solution
            if (utilisateur.equals(solution.getSolution())){
                System.out.println("Good job! You found all the colors in their right position.");
                break;
            }
        
            // Condition pour afficher un message qui indique le jeu est terminé après 12 essais
            if(compteurTour == 12){
                System.out.println("Game over. You spent all of your 12 chances..");
            }
        }
    }
}