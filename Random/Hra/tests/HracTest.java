import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HracTest {

    private Hrac hrac;

    @Before
    public void setUp() throws Exception {
        this.hrac = new Hrac("hrac 1");
        this.hrac.setSkore(5);
        this.hrac.setPocetZivotov(5);
    }

    @Test
    public void getNick() {
        Assert.assertEquals("hrac 1", this.hrac.getNick());
    }

    @Test
    public void setNick() {
        this.hrac.setNick("hrac 2");
        Assert.assertEquals("hrac 2", this.hrac.getNick());
    }

    @Test
    public void getSkore() {
        Assert.assertEquals(5, this.hrac.getSkore());
    }

    @Test
    public void setSkore() {
        this.hrac.setSkore(10);
        Assert.assertEquals(10, this.hrac.getSkore());
    }

    @Test
    public void getPocetZivotov() {
        Assert.assertEquals(5, this.hrac.getPocetZivotov());
    }

    @Test
    public void setPocetZivotov() {
        this.hrac.setPocetZivotov(10);
        Assert.assertEquals(10, this.hrac.getPocetZivotov());
    }
}