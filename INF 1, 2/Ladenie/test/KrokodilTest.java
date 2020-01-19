/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nakladanepolozky.Krokodil;
import junit.framework.Assert;
import nakladanepolozky.StavKrokodila;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bohacikj
 */
public class KrokodilTest {
    Krokodil k;
    
    public KrokodilTest() {
    }
    
    @Before
    public void setUp() {
        k = new Krokodil("123",30,120, StavKrokodila.ZIVY);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEvidencneCislo method, of class Krokodil.
     */
    @Test
    public void testujGetEvidencneCislo() {       
        //Assert.assertEquals(k.getEvidencneCislo(),"123");
        Assert.assertTrue(k.getEvidencneCislo().equals("123"));
    }

    @Test
    public void testujGetPocetZubov() {
        //Assert.assertEquals(k.getEvidencneCislo(),"123");
        Assert.assertTrue(k.getPocetZubov() == 30);
    }

    
}
