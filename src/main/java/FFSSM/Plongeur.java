package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
    
    public int niveau;
    List<Licence> lesLicences = new LinkedList<>();
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club club){
        Licence licence = new Licence(this, numero, delivrance, niveau, club);
        lesLicences.add(licence);
    }

    public int getNiveau() {
        return niveau;
    }

    public List<Licence> getLesLicences() {
        return lesLicences;
    }

 
    
    
	
}
