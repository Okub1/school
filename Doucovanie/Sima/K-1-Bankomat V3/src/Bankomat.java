import java.util.*;

public class Bankomat {
    double zvysok = 0;
    int patstovky= 0;
    int dvestovky = 0;
    int stovky = 0;
    int padesiatky = 0;
    int dvadsiatky = 0;
    int desiatky = 0;
    int patka = 0;
    int dvojka = 0;
    int jednotka = 0;
    int cent50 = 0;
    int cent20 = 0;
    int cent10 = 0;
    int cent5 = 0;
    int cent2 = 0;
    int cent1 = 0;
    public Bankomat() {
    }


    public void vypocitaj(double vstup) {
        zvysok = vstup * 100;
        patstovky = (int)zvysok / 50000;
        zvysok = zvysok % 50000;
        dvestovky = (int)zvysok / 20000;
        zvysok = zvysok % 20000;
        stovky = (int)zvysok / 10000;
        zvysok = zvysok % 10000;
        padesiatky = (int)zvysok / 5000;
        zvysok = zvysok % 5000;
        dvadsiatky = (int)zvysok / 2000;
        zvysok = zvysok % 2000;
        desiatky = (int)zvysok / 1000;
        zvysok = zvysok % 1000;
        patka = (int)zvysok / 500;
        zvysok = zvysok % 500;
        Scanner sc = new Scanner(System.in);
        zvysok = zvysok / 100;
        System.out.println("Prajete si zvyšok(" + zvysok + "eur ) prenechať charite? (y/n) ");
        char c = sc.next().charAt(0);
        if(c == 'y' || c == 'Y') {
            vypisBankovky();
            System.out.println("Charite ste prenechali " + zvysok + "eur, ďakujeme že bojujete s nami a podporujete rakovinu Janáčkovi!" );
            System.out.println("===============================");
        } else if (c == 'n' || c == 'N') {
            zvysok = zvysok * 100;
            dvojka = (int)zvysok / 200;
            zvysok = zvysok % 200;
            jednotka = (int)zvysok / 100;
            zvysok = zvysok % 100;
            cent50 = (int)zvysok / 50;
            zvysok = zvysok % 50;
            cent20 = (int)zvysok / 20;
            zvysok = zvysok % 20;
            cent10 = (int)zvysok / 10;
            zvysok = zvysok % 10;
            cent5 = (int)zvysok / 5;
            zvysok = zvysok % 5;
            cent2 = (int)zvysok / 2;
            zvysok = zvysok % 2;
            cent1 = (int)zvysok / 1;
            zvysok = zvysok % 1;
            vypisBankovky();
            System.out.println("===============================");
        } else {
            System.out.println("Nesprávna voľba. Skús to znova ty prázdna kokotia hlava čo nevie čítať.");
        }
    }

    public void vypisBankovky() {
        System.out.println("===============================");
        System.out.println("======= Vaše bankovky: ========");
        System.out.println("500 eur: " + patstovky);
        System.out.println("200 eur: " + dvestovky);
        System.out.println("100 eur: " + stovky);
        System.out.println("50 eur: " + padesiatky);
        System.out.println("20 eur: " + dvadsiatky);
        System.out.println("10 eur: " + desiatky);
        System.out.println("5 eur: " + patka);
        System.out.println("2 eur: " + dvojka);
        System.out.println("1 eur: " + jednotka);
        System.out.println("50 centov: " + cent50);
        System.out.println("20 centov: " + cent20);
        System.out.println("10 centov: " + cent10);
        System.out.println("5 centov: " + cent5);
        System.out.println("2 centy: " + cent2);
        System.out.println("1 cent: " + cent1);
    }
}
