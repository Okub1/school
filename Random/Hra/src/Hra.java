import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Hra {

    private HashMap hraci;
    private int kolo = 0;

    public Hra (int pocetHracov) {
        hraci = new HashMap<Integer, Hrac>();

        for (int i = 0; i < pocetHracov; i++) {
            this.hraci.put(i,new Hrac("hrac " + i));
        }
    }

    public void vypisHracov() {
        System.out.println("\nHrac" + "\t\t" + "skore" + "\t\t" + "pocet zivotov");
        for (int i = 0; i < this.hraci.size(); i++) {
            Hrac hrac = (Hrac) this.hraci.get(i);
            System.out.println(hrac.getNick() + "\t\t" + hrac.getSkore() + "\t\t\t\t" + hrac.getPocetZivotov());
        }
    }

    public void pridajBody(String menoHraca, int pocetBodov) {
        for (int i = 0; i < this.hraci.size(); i++) {
            Hrac hrac = (Hrac) this.hraci.get(i);
            if (hrac.getNick().equals(menoHraca)) {
                System.out.println("\nBolo pridane " + pocetBodov + " bodov hracovi: " + hrac.getNick());
                hrac.setSkore(hrac.getSkore() + pocetBodov);
            }
        }
    }

    public void uberZivot(String menoHraca, int pocetZivotov) {
        for (int i = 0; i < this.hraci.size(); i++) {
            Hrac hrac = (Hrac) this.hraci.get(i);
            if (hrac.getNick().equals(menoHraca)) {
                System.out.println();
                hrac.setPocetZivotov(hrac.getPocetZivotov() - pocetZivotov);
            }
            vykonajKolo();
        }
    }

    public void zacniHru() {

        for (int i = 0; i < 9999; i++) {
            Hrac hrac = (Hrac) this.hraci.get(randomNum());
            if (hrac.getPocetZivotov() <= 0 || hrac.getSkore() >= 100) {
                reset();
                break;
            } else if (!(hrac.getPocetZivotov() <= 0 || hrac.getSkore() >= 100)) {
                if (randomNum() % 4 == 0) {
                    uberZivot(hrac.getNick(), 1);
                    continue;
                }

                if (randomNum() % 3 == 0) {
                    pridajBody(hrac.getNick(), 10);
                    continue;
                }

                if (randomNum() % 5 == 0) {
                    pridajBody(hrac.getNick(), -10);
                    continue;
                }
                vykonajKolo();
            } else {
                reset();
                break;
            }
        }
    }

    private void vykonajKolo() {
        this.kolo++;
        System.out.println("Kolo: " + this.kolo);
    }

    private int randomNum () {
        int randomNum = ThreadLocalRandom.current().nextInt(0, this.hraci.size() - 1);
        return randomNum;
    }

    public void reset() {
        System.out.println("\f\nKoniec hry, vysledna tabulka: ");
        vypisHracov();
        this.kolo = 0;
        this.hraci.clear();
    }
}