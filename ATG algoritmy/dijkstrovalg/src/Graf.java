/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author ACER NB
 */
public class Graf {
    private Vrchol[] meniaceSaPoleVrcholov;
    private Vrchol[] vrcholy;
    private Hrana[] hrany;
    private Scanner scanner;
    private int pocitadloVrcholov1 = -1;
    private int pocitadloVrcholov2 = -1;
    private int pocitadloHran1 = -1;
    private int pocitadloHran2 = -1;
    private boolean riadenie;
    
    void vytvorPolePreVrcholy(int pocetVrcholov) throws FileNotFoundException {
        File vstup = new File("Input files/vrcholyAHrany.txt");
        this.scanner = new Scanner(vstup);
        this.vrcholy = new Vrchol[pocetVrcholov];
        this.meniaceSaPoleVrcholov = new Vrchol[pocetVrcholov];
        for (int cisloVrchola = 0; cisloVrchola < this.meniaceSaPoleVrcholov.length; cisloVrchola++) {
            this.meniaceSaPoleVrcholov[cisloVrchola] = null;
        }
    }

    void zadajVrcholy() {
        this.pocitadloVrcholov1++;
        this.vrcholy[this.pocitadloVrcholov1] = new Vrchol();
        this.vrcholy[this.pocitadloVrcholov1].nastavNazov(this.scanner.nextLine());
        this.vrcholy[this.pocitadloVrcholov1].setMiestoVrchola(this.pocitadloVrcholov1);
    }

    public String getVrcholy() {
        this.pocitadloVrcholov2++;
        return this.vrcholy[this.pocitadloVrcholov2].getNazovVrchola() + " ";
    }

    void vytvorPolePreHrany(int pocetHran) {
        this.hrany = new Hrana[pocetHran];
    }

    void zadajHrany() {
        int cenaHrany;
        this.pocitadloHran1++;
        cenaHrany = this.scanner.nextInt();
        this.hrany[this.pocitadloHran1] = new Hrana(cenaHrany);
        this.hrany[this.pocitadloHran1].nastavNazovPrvehoVrchola(this.scanner.next());
        this.hrany[this.pocitadloHran1].nastavNazovDruhehoVrchola(this.scanner.next());
    }

    public String getHrany() {
        this.pocitadloHran2++;
        return this.hrany[this.pocitadloHran2].getNazovVrchola1() + this.hrany[this.pocitadloHran2].getNazovVrchola2() + "(" + this.hrany[this.pocitadloHran2].getCenaHrany() + ")" + ", ";
    }
    
    public boolean boliVsetkyRiadiaceVrcholyPouzite() {
        for (Vrchol vrcholy1 : this.vrcholy) {
            if (!vrcholy1.isBolPouzity()) {
                this.riadenie = false;
            }
        }
        return this.riadenie;
    }

    void rataj() {
        String nazovZaciatocnehoVrchola;
        String nazovKoncovehoVrchola;
        nazovZaciatocnehoVrchola = this.scanner.next();
        nazovKoncovehoVrchola = this.scanner.next();
        int najmensiaHodnotaRiadiacehoVrchola;
        this.vrcholy[0].nastavHodnotuVrchola(0);
        int zapametanieHodnotyKoncovehoVrchola = 0;
        
        //inicializacia
        for (int i = 1; i < this.vrcholy.length; i++) {
            this.vrcholy[i].nastavHodnotuVrchola(20000);
        }
        System.out.println("Dijkstrov algoritmus: ");
        Vrchol koncovyVrchol = new Vrchol();
        Vrchol aktualnyVrchol = new Vrchol();
        Vrchol novyRiadiaciVrchol = this.vrcholy[0];
        int aktualnaCenaHrany;
        for (int k = 0; k < this.vrcholy.length; k++) { //TODO premen to na WHILE !
            najmensiaHodnotaRiadiacehoVrchola = 150000;
            for (Vrchol vrcholy1 : this.vrcholy) {
                if (najmensiaHodnotaRiadiacehoVrchola > vrcholy1.getHodnotaVrchola() && !vrcholy1.isBolPouzity()) {
                    novyRiadiaciVrchol = vrcholy1;
                    najmensiaHodnotaRiadiacehoVrchola = vrcholy1.getHodnotaVrchola();
                }
            }
            novyRiadiaciVrchol.setJeRiadiaci();
            for (int i = 0; i < this.vrcholy.length; i++) {
                System.out.print("(" + this.vrcholy[i].getNazovVrchola() + ")" + this.vrcholy[i].getHodnotaVrchola() + "/" + this.getNazovVrchola(i));
                if (this.vrcholy[i].isJeRiadiaci() && !this.vrcholy[i].isBolPouzity()) {
                    aktualnyVrchol = this.vrcholy[i];
                    this.vrcholy[i].setBolPouzity();
                }
            }
            System.out.println();
            for (Hrana hrany1 : this.hrany) {
                if (aktualnyVrchol.getNazovVrchola().equals(hrany1.getNazovVrchola1())) {
                    koncovyVrchol.nastavNazov(hrany1.getNazovVrchola2());
                    for (Vrchol vrchol1 : this.vrcholy) {
                        if (vrchol1.getNazovVrchola().equals(koncovyVrchol.getNazovVrchola())) {
                            zapametanieHodnotyKoncovehoVrchola = vrchol1.getMiestoVrchola();
                            koncovyVrchol.nastavHodnotuVrchola(vrchol1.getHodnotaVrchola());
                        }
                    }
                    aktualnaCenaHrany = hrany1.getCenaHrany();
                    if (koncovyVrchol.getHodnotaVrchola() > aktualnyVrchol.getHodnotaVrchola() + aktualnaCenaHrany) {
                        koncovyVrchol.nastavHodnotuVrchola(aktualnyVrchol.getHodnotaVrchola() + aktualnaCenaHrany);
                        this.meniaceSaPoleVrcholov[zapametanieHodnotyKoncovehoVrchola] = aktualnyVrchol;
                        this.vrcholy[zapametanieHodnotyKoncovehoVrchola].nastavHodnotuVrchola(koncovyVrchol.getHodnotaVrchola());
                    }
                }
            }
        }
        
        //vypis
        ArrayList<Vrchol> vyslednaCesta = new ArrayList<>();
        Vrchol zaciatocnyVrchol = null;
        Vrchol poslednyVrchol = null;
        for (Vrchol vrchol : this.vrcholy) {
            if (vrchol.getNazovVrchola().equals(nazovZaciatocnehoVrchola)) {
                zaciatocnyVrchol = vrchol;
            }
            if (vrchol.getNazovVrchola().equals(nazovKoncovehoVrchola)) {
                poslednyVrchol = vrchol;
            }
        }
        if (nazovZaciatocnehoVrchola.equals(nazovKoncovehoVrchola)) {
            System.out.println("Zacinas v cieli. :D");
            return;
        }
        if (this.meniaceSaPoleVrcholov[poslednyVrchol.getMiestoVrchola()] == null) {
            System.out.println("Do toho vrchola sa nedá dostat.");
            return;
        }
        
        vyslednaCesta.add(poslednyVrchol);
        while (zaciatocnyVrchol != poslednyVrchol) {
            poslednyVrchol = this.meniaceSaPoleVrcholov[poslednyVrchol.getMiestoVrchola()];
            vyslednaCesta.add(0, poslednyVrchol);
        }
        System.out.print("Najkratsia cesta je:");
        for (Vrchol vrchol : vyslednaCesta) {
            System.out.print(" -> " + vrchol.getNazovVrchola());
        }
        System.out.println("\nCena tejto cesty je: " + vyslednaCesta.get(vyslednaCesta.size() - 1).getHodnotaVrchola());
    }

    private String getNazovVrchola(int i) {
        if (this.meniaceSaPoleVrcholov[i] == null) {
            return "null";
        }
        return this.meniaceSaPoleVrcholov[i].getNazovVrchola();
    }
}
