// Importations
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariyam Hanfaoui, 2240026
 */
public class Mastermind {
    
    // Déclaration des attributs privés
    private Série solution;
    // Les essais du jeu, dans ce cas, c'est 12
    private int nbEssais;
    // Pour prendre en compte les couleurs saisies par l'utilisateur
    private ArrayList<Série> essai;
    
    // Méthode constructeur qui prend une solution en paramètres
    public Mastermind(Série UneSolution, int nbEssais) {
        solution = UneSolution;
        this.nbEssais = nbEssais;
        this.essai = new ArrayList<>();
    }
    
    // Méthode constructeur qui prend une solution aléatoire
    public Mastermind() {
        this.solution = solutionAléatoire();
        this.nbEssais = 0;
        this.essai = new ArrayList<>();
    }
  
    // Méthode qui génère une solution aléatoire
    public Série solutionAléatoire(){ 
        
        // Déclaration d'une série qui prendra les couleurs aléatoires
        Série sérieAléatoire = new Série();
        
        // Déclaration d'un générateur aléatoire et une série aléatoire
        Random aléatoire = new Random();
        
        // Déclaration d'un maximum et d'un minimum (1 à 7 parce qu'on a 7 couleurs)
        int max = 8;
        int min = 1;
        
        // Ajout d'une couleur 5 fois dans la série aléatoire
        for (int i=0; i<5; i++){
            // Variable qui prend le numéro aléatoire
            int num = (aléatoire.nextInt(max + 1 - min) + min);
            // Conditions qui ajoute une couleur dépendant du nombre généré aléatoirement
            if (num == 1) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Red", 'R'));
            } else if (num == 2) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Yellow", 'Y')); 
            } else if (num == 3) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Blue", 'B')); 
            } else if (num == 4) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Orange", 'O')); 
            } else if (num == 5) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Green", 'G')); 
            } else if (num == 6) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Pink", 'P')); 
            } else if (num == 7) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("White", 'W'));
            } else if (num == 8) {
                    sérieAléatoire.ajouterCouleur (new Couleur ("Turquoise", 'T'));
            }
        }
        // Retourner la série aléatoire
        return sérieAléatoire;
    }
    
    // Méthode accesseurs
    public Série getSolution(){
        return solution;
    }
    
    public int getNbEssais(){
        return nbEssais;
    }
    
    // Méthode essayer qui retourne la comparaison de la solution à celle de la série de l'utilisateur
    public Série essayer(Série uneSérie){
        // Incrémentation du nombre d'essais par l'utilisateur
        nbEssais++;
        // Nécéssaire pour l'affichage de la Série dans le toString à partir du toString de Mastermind
        essai.add(uneSérie);
        return this.solution.comparer(uneSérie);
    }
    
    // Méthode toString
    @Override
    public String toString(){
        // On va fusionner plusieurs String, c'est pour cela que j'utilise StringBuilder
        // J'ai essayé de le faire en convertissant les méthodes en String.ofValue et les attribuer à un String, mais cela ne fonctionne pas.
        StringBuilder mastermind = new StringBuilder();
        
        // Pour chaque essai de l'utilisateur, on l'affiche
        for(Série uneSérie : essai){
            mastermind.append(uneSérie.toString());
            mastermind.append(" : ");
            
            // Méthode comparer en toString()
            Série résultat = solution.comparer(uneSérie);
            mastermind.append(résultat.toString());
            
            // Saute dans une nouvelle ligne
            mastermind.append("\n");
        }
        // Retourne les strings
        return mastermind.toString();
    }
} 
