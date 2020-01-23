public class Panacik {
    private char znacka;
    private boolean vDomceku;
    private int pozicia;
    private Hrac hrac;

    public Panacik(char znacka) {
        this.znacka = znacka;
        this.vDomceku = true;
    }

    public int getPozicia() {
        if (!this.vDomceku) {
            return this.pozicia;
        } else {
            // -1 v tomto pripade berieme ako indefined
            return -1;
        }
    }

    public boolean jeVDomceku() {
        return vDomceku;
    }

    public char getZnacka() {
        return znacka;
    }

    public Hrac getHrac() {
        // poistka, keby nahodou boli male pismena, in the end, uplne useless, lebo hracov vytvaram ja a nie vy :D
        // resp. hracov vytvara pocitac, a nie uzivatel :)
        String ch = String.valueOf(this.znacka).toUpperCase();

        System.out.println(ch);
        switch (ch) {
            case "A":
            case "B":
            case "C":
            case "D":
                return Hrac.PISMENKOVY;

            case "1":
            case "2":
            case "3":
            case "4":
                return Hrac.CISELKOVY;

            default:
                return hrac;
        }
    }

    public void tah(int hodnota) {
        final int MAX = 39;

        if (this.vDomceku) {
            if (hodnota == 6) {
                this.pozicia = 0;
                this.vDomceku = false;
            }
        } else {
            if ((this.pozicia + hodnota) < MAX) {
                this.pozicia += hodnota;
            } else {
                this.pozicia = (this.pozicia + hodnota) - MAX;
            }
        }
    }

    public void vratDoDomceka() {
        if (!this.vDomceku) {
            this.vDomceku = true;
            this.pozicia = -1;
        }
    }
}
