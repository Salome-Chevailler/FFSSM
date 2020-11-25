/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author schevail
 */
public class MoniteurTest {
    
    public MoniteurTest() {
    }

    
    @BeforeEach
    public void setUp() {
    }
    

    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    @org.junit.jupiter.api.Test
    public void testEmployeurActuel() {
        System.out.println("employeurActuel");
        Moniteur instance = null;
        Optional<Club> expResult = null;
        Optional<Club> result = instance.employeurActuel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nouvelleEmbauche method, of class Moniteur.
     */
    @org.junit.jupiter.api.Test
    public void testNouvelleEmbauche() {
        System.out.println("nouvelleEmbauche");
        Club employeur = null;
        LocalDate debutNouvelle = null;
        Moniteur instance = null;
        instance.nouvelleEmbauche(employeur, debutNouvelle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emplois method, of class Moniteur.
     */
    @org.junit.jupiter.api.Test
    public void testEmplois() {
        System.out.println("emplois");
        Moniteur instance = null;
        List<Embauche> expResult = null;
        List<Embauche> result = instance.emplois();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
