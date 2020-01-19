/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nakladanepolozky.Pracovnik;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bohacikj
 */
public class PracovnikTest {
    
    public PracovnikTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEvidencneCislo method, of class Pracovnik.
     */
    @Test
    public void testujZmenuMzdy() {
        Pracovnik p = new Pracovnik("123",20,800,75);
        p.setVyskaMzdy(900);
        Assert.assertTrue(Math.abs(p.getVyskaMzdy()-900)<0.005);
    }
 
}
