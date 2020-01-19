public class Operacie {

    public Operacie() {
    }

    //pozn. autora, zistil som, ze ak chceme scitavat matice, musia mat obidve rovnaku velkost (x == x && y == y)
    public Matica scitajDveMatice(Matica matica1, Matica matica2) {

        int[] velkostMatice1 = matica1.dajVelkostMatice();
        int velkostMatice1X = velkostMatice1[0];
        int velkostMatice1Y = velkostMatice1[1];

        int[] velkostMatice2 = matica2.dajVelkostMatice();
        int velkostMatice2X = velkostMatice2[0];
        int velkostMatice2Y = velkostMatice2[1];

        Matica vyslednaMatica;

        if (velkostMatice1X == velkostMatice2X && velkostMatice1Y == velkostMatice2Y) {
            vyslednaMatica = new Matica(velkostMatice1X, velkostMatice1Y);
            for (int i = 0; i < velkostMatice1X; i++) {
                for (int j = 0; j < velkostMatice1Y; j++) {
                    vyslednaMatica.setHodnotaPozicie(j,i,(matica1.getHodnotuNaPozicii(i,j) + matica2.getHodnotuNaPozicii(i,j)));
                }
            }
//            vyslednaMatica.vypisMatice();
            return vyslednaMatica;
        } else {
            System.out.println("Matice musia mat rovnaku velkost...");
            return null;
        }
    }

    public Matica vynasobDveMatice(Matica matica1, Matica matica2) {
        int[] velkostMatice1 = matica1.dajVelkostMatice();
        int velkostMatice1X = velkostMatice1[0];
        int velkostMatice1Y = velkostMatice1[1];

        int[] velkostMatice2 = matica2.dajVelkostMatice();
        int velkostMatice2X = velkostMatice2[0];
        int velkostMatice2Y = velkostMatice2[1];

        Matica vyslednaMatica = new Matica(velkostMatice1Y, velkostMatice2X);
        int vysledok;

        for (int i = 0; i < velkostMatice1X; i++) {
            for (int j = 0; j < velkostMatice1Y; j++) {
                for(int k = 0; k < velkostMatice2Y; k++) {
                    vysledok = matica1.getHodnotuNaPozicii(i, k) * matica2.getHodnotuNaPozicii(k, j);
                    vyslednaMatica.setHodnotaPozicie(i ,j , vyslednaMatica.getHodnotuNaPozicii(i, j) + vysledok);
                }
            }
        }

        vyslednaMatica.vypisMatice();
        return vyslednaMatica;
    }
}
