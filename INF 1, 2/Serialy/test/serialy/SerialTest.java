package serialy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SerialTest {

    // mozem pouzivat private? alebo tu nemusi byt vobec nic? lebo na stranke s tutorialmi tam nie je ziadny access modifier
    private Serial serial;

    @Before
    public void setUp() throws Exception {
        this.serial = new Serial("serial", "jano", 50, 5);
    }

    @Test
    public void getNazov() {
        Assert.assertEquals("serial", this.serial.getNazov());
    }

    @Test
    public void setNazov() {
        this.serial.setNazov("serial 2");
        Assert.assertEquals("serial 2", this.serial.getNazov());
    }

    @Test
    public void getTvorca() {
        Assert.assertEquals("jano", this.serial.getTvorca());
    }

    @Test
    public void setTvorca() {
        this.serial.setTvorca("jozo");
        Assert.assertEquals("jozo", this.serial.getTvorca());
    }

    @Test
    public void getPocetEpizod() {
        Assert.assertEquals(50, this.serial.getPocetEpizod());
    }

    @Test
    public void setPocetEpizod() {
        this.serial.setPocetEpizod(15);
        Assert.assertEquals(15, this.serial.getPocetEpizod());
    }

    @Test
    public void getHodnotenie() {
        Assert.assertEquals(5, this.serial.getHodnotenie());
    }

    @Test
    public void setHodnotenie() {
        this.serial.setHodnotenie(4);
        Assert.assertEquals(4, this.serial.getHodnotenie());
    }
}