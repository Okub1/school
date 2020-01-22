public class Bludisko {
    private Pacman pacman;
    private Duch duch;
    private char[][] bludisko;

    private static final char STENA = '#';
    private static final char DUCH = 'A';
    private static final char PAC_MAN = 'C';
    private static final char PRAZDNE = ' ';

    public Bludisko() {
        int pocetRiadkov = 5;
        int pocetStlpcov = 9;

        bludisko = new char[pocetRiadkov][pocetStlpcov];

        // inicializacia (vytvorenie) stien
        for (int i = 0; i < bludisko.length; i++) {
            for (int j = 0; j < bludisko[0].length; j++) {
                if (i == 0 || j == 0 || i == bludisko.length - 1 || j == bludisko[0].length - 1) {
                    bludisko[i][j] = STENA;
                } else {
                    bludisko[i][j] = PRAZDNE;
                }
            }
        }

        // podla toho ich dizajnu v zadani, treba aj nejake dve random steny dnu...
        bludisko[2][2] = STENA;
        bludisko[2][6] = STENA;

        // pridanie ducha
        duch = new Duch(this, new Pozicia(1, 4));
        bludisko[duch.getPozicia().getX()][duch.getPozicia().getY()] = DUCH;

        // pridanie pac-mana
        pacman = new Pacman(this, new Pozicia(2,4));
        bludisko[pacman.getPozicia().getX()][pacman.getPozicia().getY()] = PAC_MAN;
    }

    public Pacman getPacman() {
        if (jeStena(pacman.getPozicia())) {
            System.out.println("asdasd");
        }
        return this.pacman;
    }

    // update pozicie ducha
    public void tik() {
        duch.tik();
    }

    // zjednoduseny if, ktory sa pyta ci sa na danej pozicii nenachadza stena
    public boolean jeStena(Pozicia pozicia) {
        return bludisko[pozicia.getX()][pozicia.getY()] == STENA;
    }

    public void vykresli() {
        // prvotne vynulovanie pre dalsie vykreslenie
        for (int i = 0; i < bludisko.length; i++) {
            for (int j = 0; j < bludisko[0].length; j++) {
                if (bludisko[i][j] == PAC_MAN || bludisko[i][j] == DUCH)
                    bludisko[i][j] = PRAZDNE;
            }
        }

        // update znakov kde sa nachadza duch a pac-man
        bludisko[pacman.getPozicia().getX()][pacman.getPozicia().getY()] = PAC_MAN;
        bludisko[duch.getPozicia().getX()][duch.getPozicia().getY()] = DUCH;


        // vypis
        for (char[] chars : bludisko) {
            for (int j = 0; j < bludisko[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }

        // koniec hry, v pripade ze pac-mana zje duch (nepovinne, ale ja som to aj tak pridal)
        if (duch.getPozicia().getX() == pacman.getPozicia().getX() && duch.getPozicia().getY() == pacman.getPozicia().getY()) {
            System.out.println("ZJEDOL TA DUCH!\nKoniec hry...");
            System.exit(0);
        }
    }
}
