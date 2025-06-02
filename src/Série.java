// Importations
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Mariyam Hanfaoui, 2240026
 */
public class Série {
    
    // Déclaration d'un arraylist contenant les couleurs
    private ArrayList<Couleur> couleurs;
    
    // Méthode constructeur de la classe Série
    public Série() {
        this.couleurs = new ArrayList<>();
    }

    // Méthode accesseur qui retourne la couleur à la position courante
    public Couleur getCouleur(int position) {
      int n = this.couleurs.size()-1;
      Couleur uneCouleur = null;
        try {
            for (position = 0; position < n; position++){
                uneCouleur = this.couleurs.get(position);
            }
        } catch (IllegalArgumentException e){
            e.getMessage();
        }
        return uneCouleur;
    }
    
    // Méthode ajouter qui ajoute une couleur à la série
    public void ajouterCouleur(Couleur uneCouleur){
        this.couleurs.add(uneCouleur);
    }
    
    // Méthode equals qui retourne vrai et seulement si les couleurs sont les mêmes et à la même position
    public boolean equals(Série uneSérie){
        
        // Vérifie la taille
        if (uneSérie.couleurs.size() != this.couleurs.size()){
            return false;
        }
        
        // Vérifie les bonnes couleurs à la bonne position
        for (int i=0; i<couleurs.size(); i++){
            if(!this.couleurs.get(i).equals(uneSérie.couleurs.get(i))){
                return false;
            }
        }
        return true;
    }
    
    // Méthode comparer qui compare la solution à la série
    public Série comparer(Série uneSérie){
        // Création d'objets noir et blanc pour les ajouter à la série nb (qui sera éventuellement retourner)
        Couleur black = new Couleur("Black", 'B');
        Couleur white = new Couleur("White", 'W');
        // Série pour les couleurs noirs et blancs
        Série nb = new Série();
        // ArrayList qui stocke les couleurs qui ont déjà été attribué la couleur noir afin d'éviter la revérification de celles-ci
        // ArrayList afin d'utilisateur contains dans la boucle pour les blancs
        ArrayList<Couleur> sérieCT = new ArrayList<>();
        
        try {
            //Boucle pour trouver les couleurs noires de la série (même couleur & même endroit)
            for(int i=0; i<this.couleurs.size();i++){
                if(this.couleurs.get(i).equals(uneSérie.couleurs.get(i))){
                    nb.ajouterCouleur(black);
                    // Stocke les couleurs qui sont devenu noir dans la sérieCT afin d'éviter leur vérification une deuxième fois dans la boucle pour les couleurs blancs
                    sérieCT.add(uneSérie.couleurs.get(i));
                }
            }
            //Boucle pour trouver les couleurs blancs de la série (même couleur mais dans un endroit différent)
            for(int i=0; i<this.couleurs.size(); i++){
                for(int j=0; j<uneSérie.couleurs.size(); j++){
                    // Si la couleur n'est pas stocké dans sérieCT..
                    if(!sérieCT.contains(uneSérie.couleurs.get(i))){
                    // On la vérifie.
                    if (this.couleurs.get(i).equals(uneSérie.couleurs.get(j)) && !this.couleurs.contains(uneSérie.couleurs.get(j))){
                        nb.ajouterCouleur(white);
                        break;
                        }
                    }  
                }
            }
        } catch (IllegalArgumentException e){
                e.getMessage();
            }
        return nb;
    }
    
    // Méthode toString de la classe Série
    public String toString(){
        for (int i = 0; i < this.couleurs.size(); i++){
            this.couleurs.get(i).getAbréviation();
        }
        return String.valueOf(couleurs);
    }
}
