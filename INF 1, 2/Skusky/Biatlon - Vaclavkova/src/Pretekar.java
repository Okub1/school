public class Pretekar {
    private String meno;
    private Strelba strelba;
    private int startovacieCislo;
    private int cas;
    private final int PENALIZACIA = 6000;

    /**
     * Objekty tejto triedy budú reprezentovať jednotlivých pretekárov v súťaži, pre každého pretekára
     * budeme evidovať čas jeho preteku v stotinách sekundy a jeho streľbu v preteku. Za nezasiahnuté
     * terče pretekár dostáva trestné body vo výške 1 minúty (6000 stotín sekundy) za každý.
     * @param paMeno
     * @param paStartovacieCislo
     */
    public Pretekar(String paMeno, int paStartovacieCislo) {
        this.meno = paMeno;
        this.startovacieCislo = paStartovacieCislo;
        this.cas = 0;
    }

    /**
     * metóda vráti štartovné číslo pretekára
     * @return
     */
    public int getStartovacieCislo() {
        return this.startovacieCislo;
    }

    /**
     * celočíselný parameter reprezentuje odbehnutý čas pretekára
     * v stotinách sekundy, návratový typ je void
     * @param paCas
     */
    public void nastavCasBehu(int paCas) {
        this.cas = paCas;
    }

    /**
     * s objektovým parametrom typu Strelba, vloží pretekárovi
     * záznamy o jeho nastrieľaných terčoch
     * @param paStrelba
     */
    public void vlozStrelbu(Strelba paStrelba) {
        this.strelba = paStrelba;
    }

    /**
     * vráti počet terčov, ktoré pretekár trafil
     * @return
     */
    public int dajKolkoNastrielal() {
        return this.strelba.dajPocetZasahov();
    }

    /**
     * metóda vracajúca číslo reprezentujúce trestný
     * čas pretekára (sumár za všetky nezasiahnuté terče, pričom zohľadňuje penalizáciu)
     */
    public int dajTrestnyCasZaStrelbu() {

        return this.strelba.dajPocetNetrafenych() * this.PENALIZACIA;
    }

    /**
     * metóda vráti výsledný čas pretekára (v stotinách sekundy), ktorý
     * je závislý na jeho behu a výsledkoch v streľbe
     */
    public int dajCelkovyCas() {
        return this.cas + dajTrestnyCasZaStrelbu();
    }

    /**
     * metóda zistí, či pretekár dobehol t.j. či jeho čas za
     * beh nie je nulový
     */
    public boolean pretekarDobeholDoCiela() {
        if (this.cas == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * metóda vracia reťazec, v ktorom je výsledný čas
     * pretekára naformátovaný na minúty, sekundy a stotiny sekúnd. Príklad pre 10000 stotín
     * sekundy : 1:40,00
     */
    public String dajFormatovanyCas() {
        int minuty = (this.cas / 100) / 60;
        int sekundy = (this.cas / 100) % 60;
        int stotiny = this.cas - (minuty * 100 * 60 + sekundy * 100);
        String stotinyString = "0";
        if (stotiny < 10) {
             stotinyString += stotiny;
        }

        // TODO dokoncit vypocet stotin (rata to zle trosku)

        return minuty + ":" + sekundy + "," + stotinyString;
    }

    public String toString() {

        if (pretekarDobeholDoCiela()) {
            return this.startovacieCislo + ". " + this.meno + " dobehol za " + dajFormatovanyCas()
                    + " a nastrielal " + this.strelba.toString();
        } else {
            return  this.startovacieCislo + ". " + this.meno + " este nedobehol.";
        }
    }
}
