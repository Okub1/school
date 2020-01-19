import java.util.*;

public class Bankomat {
    int zvysok = 0;
    int patstovky= 0;
    int dvestovky = 0;
    int stovky = 0;
    int padesiatky = 0;
    int dvadsiatky = 0;
    int desiatky = 0;
    int patka = 0;
    int dvojka = 0;
    int jednotka = 0;
    public Bankomat() {

    }


    public void vypocitaj(int vstup) {
        zvysok = vstup;
        patstovky = zvysok / 500;
        zvysok = zvysok % 500;
        dvestovky = zvysok / 200;
        zvysok = zvysok % 200;
        stovky = zvysok / 100;
        zvysok = zvysok % 100;
        padesiatky = zvysok / 50;
        zvysok = zvysok % 50;
        dvadsiatky = zvysok / 20;
        zvysok = zvysok % 20;
        desiatky = zvysok / 10;
        zvysok = zvysok % 10;
        patka = zvysok / 5;
        zvysok = zvysok % 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Prajete si zvyšok(" + zvysok + ") prenechať charite? (y/n) ");
        char c = sc.next().charAt(0);
        if(c == 'y' || c == 'Y') {
            vypisBankovky();
        } else if (c == 'n' || c == 'N') {
            dvojka = zvysok / 2;
            zvysok = zvysok % 2;
            jednotka = zvysok;
            vypisBankovky();
        } else {
            System.out.println("Nesprávna voľba. Skús to znova ty prázdna hlava.");
        }
    }

    public void vypisBankovky() {
        System.out.println("===============================");
        System.out.println("======= Vaše bankovky: ========");
        System.out.println("500: " + patstovky);
        System.out.println("200: " + dvestovky);
        System.out.println("100: " + stovky);
        System.out.println("50: " + padesiatky);
        System.out.println("20: " + dvadsiatky);
        System.out.println("10: " + desiatky);
        System.out.println("5: " + patka);
        System.out.println("2: " + dvojka);
        System.out.println("1: " + jednotka);
        System.out.println("===============================");
    }
}
