
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariyam Hanfaoui, 2240026
 */
public class Couleur {
    
    // Déclaration des attributs privés de la classe couleurs
    private String nom;
    private char abréviation;
    
    // Méthode constructeur de Couleur
    public Couleur(String unNom, char uneAbréviation){
        nom = unNom;
        abréviation = uneAbréviation;
    }
    
    // Méthodes accesseurs des attributs
    public String getNom(){
        return nom;
    }
    
    public char getAbréviation(){
        return abréviation;
    }
    
    // Méthode equals qui compare les couleurs
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Couleur uneCouleur = (Couleur) obj;
        return this.getNom().equals(((Couleur)uneCouleur).getNom()) && this.abréviation == uneCouleur.getAbréviation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, abréviation);
    }
    
    // Méthode toString qui prend l'abréviation
    @Override
    public String toString(){
        return String.valueOf(abréviation);
    }
}
