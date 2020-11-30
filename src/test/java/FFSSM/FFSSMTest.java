/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 *
 * @author Salomé Chevailler
 */
public class FFSSMTest {
    Plongeur p1;
    Club club;
    Moniteur m;
    Plongee p;
    Site s;
    Embauche e;
    
    @BeforeEach
    public void setUp() {
        p1 = new Plongeur("1", "Dupont", "Jean", "Castres", "tel", LocalDate.of(1975, 5, 23), 1);
        club = new Club(m, "Club", "tel");
        m = new Moniteur ("2", "Durand", "Paul", "Castres", "tel", LocalDate.of(1980, 3, 5), 3, 2);
        p = new Plongee(s, m, LocalDate.of(2020,12,1), 20, 3);
        s = new Site("nom", "details");
        e = new Embauche(LocalDate.of(2019,12,3), m, club); 
    }
    
    @Test
    public void testEstValide(){
        Licence l = new Licence(p1, "1", LocalDate.of(2010, 8, 12), 1, club);
        assertFalse(l.estValide(LocalDate.now()), "La licence n'est pas valide");
    }
    
    @Test
    public void testAjouteParticipant(){
        p.ajouteParticipant(p1);
        assertTrue(p.lesPlongeurs.contains(p1), "Le plongeur n'a pas été ajouté");
    }
    
    @Test
    public void testOrganisePlongee(){
        club.organisePlongee(p);
        assertTrue(club.lesPlongees.contains(p), "La plongée n'a pas été ajoutée");
    }
    
    
    @Test
    public void testPlongeesNonConformes(){
        club.organisePlongee(p);
        Plongeur plongeurNonConforme = new Plongeur("1", "Martin", "Pierre", "Castres", "tel", LocalDate.of(1980,6,12),1);
        Plongee plongeeNonConforme = new Plongee(s, m, LocalDate.of(2020,12,31), 50, 2);
        plongeeNonConforme.ajouteParticipant(plongeurNonConforme);
        plongeurNonConforme.ajouteLicence("1", LocalDate.of(2020,11,30), club);
        club.organisePlongee(plongeeNonConforme);
        assertTrue(club.plongeesNonConformes().contains(plongeeNonConforme), "Le club a organisé une plongée non conforme");
        
    }

    @Test
    public void testAjouteLicence(){
        // On vérifie que la collection lesLicences est bien vide
        assertTrue(p1.getLesLicences().isEmpty());
        // On ajoute une licence et on vérifie la collection
        p1.ajouteLicence("1", LocalDate.of(2020, 11, 30), club);
        assertFalse(p1.getLesLicences().isEmpty());
    }
    
    @Test
    public void testEmbauche(){
        e.terminer(LocalDate.of(2020,2,1));
        assertFalse(m.lesEmbauches.contains(e));
        assertFalse(e.estTerminee());
    }

    @Test 
    public void testNouvelleEmbauche(){
        assertTrue(m.lesEmbauches.isEmpty());
        m.nouvelleEmbauche(club, LocalDate.of(2020,11,30));
        assertFalse(m.lesEmbauches.isEmpty());
        
    }
    
    @Test 
    public void testEmployeurActuel() throws Exception{
        assertTrue(m.emplois().isEmpty(), "Le moniteur ne doit pas avoir d'emploi");
        
        try{
            m.employeurActuel();
            fail();
        }
        catch (Exception e) {
        }
        
        assertEquals(m, e.getEmploye());
        e.estTerminee();
        
        try{
            m.employeurActuel();
            fail();
        }
        catch (Exception e){
        }
    }
    
    
}
