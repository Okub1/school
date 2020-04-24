/**
 * Trieda sluziaca na kontrolu nad polickami v hracom poli
 */
public class HraciePole {

    private Policko[][] hraciePole;
    private int riadky;
    private int stlpce;

    /**
     * Konstruktor sluziaci na deklaraciu a nasledne
     * inicializaciu hracieho pola
     * vytvorenim prazdnych policok v hracom poli.
     * @param riadky riadky hracieho pola
     * @param stlpce stlpce hracieho pola
     */
    public HraciePole(int riadky, int stlpce) {
        this.riadky = riadky;
        this.stlpce = stlpce;

        this.hraciePole = new Policko[this.riadky][this.stlpce];

        for (int i = 0; i < this.riadky; i++) {
            for (int j = 0; j < this.stlpce; j++) {
                this.hraciePole[i][j] = new Policko(' ');
            }
        }
    }

    /**
     * Getter: jednoducha metoda na ziskavanie celeho hracieho pola.
     * @return
     */
    public Policko[][] getHraciePole() {
        return hraciePole;
    }

    /**
     * Getter: jednoducha metoda na ziskavanie riadkov hracieho pola.
     * @return riadky hracieho pola
     */
    public int getRiadky() {
        return riadky;
    }

    /**
     * Getter: jednoducha metoda na ziskavanie stlpcov hracieho pola.
     * @return stlpce hracieho pola
     */
    public int getStlpce() {
        return stlpce;
    }

    /**
     * Metoda sluziaca na vypis celeho pola,
     * medzi kazde policko vlozi "ciary"
     * a ocisluje jednotlive riadky a stlpce
     */
    public void vypis() {

        System.out.println();
        for (int i = 1; i <= this.stlpce ; i++) {
            System.out.print(i-1 + " | ");
        }


        System.out.println();
        for (int i = 0; i < this.riadky; i++) {


            if (i == 0) {
                continue;
            }

            for (int j = 0; j < this.stlpce; j++) {
                System.out.print("--+-");
                if (j >= 9) {
                    System.out.print("-");
                }
            }
            System.out.println();

            System.out.print(i);

            for (int j = 0; j < this.stlpce; j++) {

                if (i < 10) {
                    System.out.print(" | ");
                } else {
                    System.out.print("|  ");
                }

                if (j >= 9) {
                    System.out.print(" ");
                }
                System.out.print(this.hraciePole[i-1][j].vypis());
            }
            System.out.println();
        }

        for (int j = 0; j < this.stlpce; j++) {
            System.out.print("--+-");
            if (j >= 9) {
                System.out.print("-");
            }
        }

        System.out.println();
    }
}
