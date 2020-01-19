public class Matica {

    private int[][] matica;
    private int velkostMaticeX;
    private int velkostMaticeY;
    private int velkostMatice;

    public Matica(int velkostMaticeX, int velkostMaticeY) {
        if (velkostMaticeX > 0) {
            this.velkostMaticeX = velkostMaticeX;
        }

        if (velkostMaticeY > 0) {
            this.velkostMaticeY = velkostMaticeY;
        }
        this.matica = new int[velkostMaticeX][velkostMaticeY];
    }

    public boolean jeMaticaStvorcova() {
        if (this.velkostMaticeX == this.velkostMaticeY) {
//            System.out.println("\nMatica je stvorcova. ");
            this.velkostMatice = velkostMaticeX;
            return true;
        } else {
//            System.out.println("\nMatica nie je stvorcova. ");
            return false;
        }
    }

    public void setHodnotaPozicie(int x, int y, int hodnota) {
        if (!jeMaticaStvorcova()) {
            if (x >= 0 && y >= 0 && x <= this.velkostMaticeX && y <= this.velkostMaticeY) {
                this.matica[x][y] = hodnota;
            }
        }
        if (x >= 0 && y >= 0 && x <= this.velkostMatice) {
            this.matica[x][y] = hodnota;
        }
    }

    public int getHodnotuNaPozicii(int x, int y) {
        int hodnota = 0;
        if (x > -1 && y > -1 && x < this.velkostMaticeX && y < this.velkostMaticeY) {
            hodnota = this.matica[x][y];
//            x++;
//            y++;
//            System.out.println("\nHodnota matice na pozicii x: " + x + ", y: " + y + ", je: " + hodnota);
        }
        return hodnota;
    }

    public int[] dajVelkostMatice() {
        int[] velkostMatice;
            velkostMatice = new int[2];
            velkostMatice[0] = this.velkostMaticeX;
            velkostMatice[1] = this.velkostMaticeY;
            return velkostMatice;
    }

    public void vypisMatice() {
//        String vypis = "\nVypis matice: ";
//        System.out.println(vypis);

        for (int i = 0; i < this.velkostMaticeY; i++) {
            for (int j = 0; j < this.velkostMaticeX; j++) {
                System.out.print(this.matica[j][i] + " ");
            }
            System.out.println();
        }
    }

}
