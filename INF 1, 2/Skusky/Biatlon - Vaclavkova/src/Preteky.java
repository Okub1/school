import java.util.ArrayList;

public class Preteky {
    private int startovacieCislo = 100;
    private ArrayList<Pretekar> pretekari;

    /**
     * objekty tejto triedy umožňujú uchovávať informácie o pretekoch (zoznam jednotlivých pretekárov
     * s ich údajmi) , preteky automaticky pridelia pri prihlásení sa do preteku pretekárovi štartovacie
     * číslo, pričom čísla sa prideľujú od hodnoty 100 smerom vyššie,
     */

    /**
     * inicializuje pretek, pripraví kontajner pre reprezentáciu zoznamu pretekárov
     */
    public Preteky() {
        this.pretekari = new ArrayList<>();
    }

    /**
     * vloží jedného pretekára do zoznamu pretekárov, pričom mu
     * pridelí štartovacie číslo, návratová hodnota metódy je štartovacie číslo pridaného pretekára
     * @param paMenoPretekara
     * @return
     */
    public int pridajPretekara(String paMenoPretekara) {
        int docasnaPremennaNeodpisujteTotoOdoMnaNazviteSiToPodlaSeba = this.startovacieCislo;
        this.pretekari.add(new Pretekar(paMenoPretekara, this.startovacieCislo));
        this.startovacieCislo++;

        return docasnaPremennaNeodpisujteTotoOdoMnaNazviteSiToPodlaSeba;
    }

    /**
     * metóda, ktorá vráti poradie (index) pretekára v zozname
     * pretekárov, hľadá ho v zozname na základe jeho štartovacieho čísla , vráti záporné číslo ak
     * pretekára v zozname nenájde
     * @param paStartovacieCislo
     * @return
     */
    public int dajIndexPretekara(int paStartovacieCislo) {
        for (Pretekar pretekar : this.pretekari) {
            if (pretekar.getStartovacieCislo() == paStartovacieCislo) {
                return this.pretekari.indexOf(pretekar);
            }
        }
        return -1;
    }

    /**
     * vráti znakovú reprezentáciu preteku - informácie o  jednotlivých
     * pretekároch, každého na samostatnom riadku . Príklad ako by mal vyzerať výstup z metódy po
     * vypísaní:
     * Pretekaju:
     * 101 .Bjorndahlen dobehol za 1:38,88 a nastrielal Hodnoty:X X X X X
     * 102 .Kuzmina dobehol za 3:40,00 a nastrielal Hodnoty:X - X - X
     * @return
     */
    public String toString() {
        StringBuilder pretakariString = new StringBuilder();

        for (Pretekar pretekar : this.pretekari) {
            pretakariString.append(pretekar.toString()).append("\n");
        }

        return "Pretekaju: \n" + pretakariString;
    }

    /**
     * má celočíselný parameter štartovacie číslo pretekára a celočíselný parameter s hodnotou odbehnutého času pretekára
     */
    public void natavCasPretekarovi(int paStartovacieCislo, int paOdbehnutyCas) {
        this.pretekari.get(dajIndexPretekara(paStartovacieCislo)).nastavCasBehu(paOdbehnutyCas);
    }

    /**
     * má celočíselný parameter štartovacie číslo pretekára, objektový parameter s hodnotami nastrieľaných terčov pretekára
     */
    public void nastavStrelbuPretekarovi(int paStartovacieCislo, Strelba paStrelba) {
        this.pretekari.get(dajIndexPretekara(paStartovacieCislo)).vlozStrelbu(paStrelba);
    }

    /**
     * bezparametrická metóda vráti pretekára s najlepším výsledkom t.j.
     * s najnižším celkovým časom
     * @return
     */
    public Pretekar najdiVitaza() {
        int najCas = this.pretekari.get(0).dajCelkovyCas();
        Pretekar najPretekar = null;

        for (Pretekar pretekar : this.pretekari) {
            if (pretekar.dajCelkovyCas() < najCas) {
                najCas = pretekar.dajCelkovyCas();
                najPretekar = pretekar;
            }
        }

        return najPretekar;
    }
}
