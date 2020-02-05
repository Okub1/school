public class HraciePole {
    private Karta[][] hraciePole;

    public HraciePole() {
        this.hraciePole = new Karta[8][8];

        int znak = 65;
        for (int i = 0; i < this.hraciePole.length; i++) {
            for (int j = 0; j < this.hraciePole[0].length; j += 2) {
                this.hraciePole[i][j] = new Karta((char) (znak), i, j);
                this.hraciePole[i][j + 1] = new Karta((char) (znak), i, j);
                znak++;
            }
        }
    }

    public void odstran(Karta[] karty) {

        for (int i = 0; i < karty.length; i++) {
            for (int j = 0; j < this.hraciePole.length; j++) {
                for (int k = 0; k < this.hraciePole[j].length; k++) {
                    if (karty[i] == this.hraciePole[j][k]) {
                        this.hraciePole[j][k] = null;
                    }
                }
            }
        }
    }

    public void vypis() {
        String pom = "";

        for (int i = 0; i < this.hraciePole.length; i++) {
            for (int j = 0; j < this.hraciePole[0].length; j++) {
                if (this.hraciePole[i][j] == null) {
                    pom += "  ";
                } else {
                    pom += this.hraciePole[i][j].naformatuj() + " ";
                }
            }
            pom += "\n";
        }

        System.out.println(pom);
    }

    public Karta getKarta(int riadok, int stlpec) {
        return this.hraciePole[riadok][stlpec];
    }

    public boolean jePrazdne() {

        for (int i = 0; i < this.hraciePole.length; i++) {
            for (int j = 0; j < this.hraciePole[i].length; j++) {
                if (this.hraciePole[i][j] != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
