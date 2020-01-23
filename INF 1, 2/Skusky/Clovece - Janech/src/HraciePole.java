import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class HraciePole {
    private ArrayList<Panacik> panaciky;
    private char[] pole;
    private Hrac hrac = Hrac.PISMENKOVY; // striedanie hracov

    public HraciePole() {
        this.panaciky = new ArrayList<>(8);
        this.pole = new char[40];

        for (int i = 1; i <= 4; i++) {
            this.panaciky.add(new Panacik((char) (48 + i)));
            this.panaciky.add(new Panacik((char) (64 + i)));
        }

        // nahradi for, ktory naplna cele pole hviezdickami...
        Arrays.fill(pole, '*');
    }

    public void vykresli() {
        // domceky :D
        char[] domcek = new char[8];

        Arrays.fill(domcek, ' ');

        for (Panacik panacik : this.panaciky) {
            switch (panacik.getZnacka()) {
                case 'A':
                    if (panacik.jeVDomceku()) {
                        domcek[0] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[0] = '*';
                        break;
                    }
                case 'B':
                    if (panacik.jeVDomceku()) {
                        domcek[1] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[1] = '*';
                        break;
                    }
                case 'C':
                    if (panacik.jeVDomceku()) {
                        domcek[4] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[4] = '*';
                        break;
                    }
                case 'D':
                    if (panacik.jeVDomceku()) {
                        domcek[5] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[5] = '*';
                        break;
                    }
                case '1':
                    if (panacik.jeVDomceku()) {
                        domcek[2] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[2] = '*';
                        break;
                    }
                case '2':
                    if (panacik.jeVDomceku()) {
                        domcek[3] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[3] = '*';
                        break;
                    }
                case '3':
                    if (panacik.jeVDomceku()) {
                        domcek[6] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[6] = '*';
                        break;
                    }
                case '4':
                    if (panacik.jeVDomceku()) {
                        domcek[7] = panacik.getZnacka();
                        break;
                    } else {
                        domcek[7] = '*';
                        break;
                    }
            }
        }

        // vypis domcekov
        for (int i = 0; i < domcek.length; i++) {
            switch(i) {
                case 2:
                case 6:
                    System.out.print("\t\t");
                    break;
                case 4:
                    System.out.println();
                    break;
            }

            System.out.print(domcek[i] + " ");
        }
        System.out.println("\n");

        // update
        Arrays.fill(pole, '*');
        for (Panacik panacik : panaciky) {
            if (!panacik.jeVDomceku()) {
                this.pole[panacik.getPozicia()] = panacik.getZnacka();
            }
        }

        // vypis hracieho pola
        for (int i = 0; i < pole.length; i++) {
            if (i == 20) {
                System.out.println();
            }

            // za help pri bug fixe vdaka: Jozef Kompan :D
            if (i > 20) {                           //    ↓ tu bol problem btw (20 tam bolo)
                System.out.print(pole[(pole.length - i + 19)] + " ");
            } else {
                System.out.print(pole[i] + " ");
            }
        }
        System.out.println();
    }

    public void tahPanacika(char znacka, int hodnota) {
        Panacik panacik = null;
        // kontrola vstupu, ci sa tam vobec ten panacik nachadza
        boolean jeTamVobecTakyPanacik = false;
        for (Panacik hladanyPanacik : panaciky) {
            if (hladanyPanacik.getZnacka() == znacka) {
                jeTamVobecTakyPanacik = true;
                panacik = hladanyPanacik;
                break;
            }
        }

        if (!jeTamVobecTakyPanacik) {
            return; // skonci sa metoda tu, ak tam ten panacik neexistuje,
            // musi prejst cely for, aby sa prehladali vsetky miesta v arrayliste
        }


        // striedanie hracov...
        if (this.hrac == Hrac.CISELKOVY) {
            // hladame ci sa nahodou na danej pozicii nenachadza nejaky panacik,
            // a ak nachadza, pojde naspat do domceku

            panacik.tah(hodnota);

            for (Panacik hladanyPanacik : this.panaciky) {
                if (panacik.getPozicia() == hladanyPanacik.getPozicia() && hladanyPanacik.getZnacka() != panacik.getZnacka()) {
                    hladanyPanacik.vratDoDomceka(); // rip
                }
            }

            this.hrac = Hrac.PISMENKOVY;
        } else if (this.hrac == Hrac.PISMENKOVY){

            panacik.tah(hodnota);

            for (Panacik hladanyPanacik : this.panaciky) {
                if (panacik.getPozicia() == hladanyPanacik.getPozicia() && hladanyPanacik.getZnacka() != panacik.getZnacka() && !panacik.jeVDomceku()) {
                    hladanyPanacik.vratDoDomceka(); // rip
                    System.out.println("Panacik " + panacik.getZnacka() + " vyhodil panacika " + hladanyPanacik.getZnacka());
                }
            }

            this.hrac = Hrac.CISELKOVY;
        }
    }

    public Hrac getHracNaTahu() {
        return this.hrac;
    }
}
