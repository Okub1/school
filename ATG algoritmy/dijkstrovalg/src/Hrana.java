/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER NB
 */
public class Hrana {
    private String nazovVrchola1;
    private String nazovVrchola2;
    private final int cenaHrany;

    Hrana(int cenaHrany) {
        this.cenaHrany = cenaHrany;
    }
    
    void nastavNazovPrvehoVrchola(String vrchol1) {
        this.nazovVrchola1 = vrchol1;
    }
    
    void nastavNazovDruhehoVrchola(String vrchol2) {
        this.nazovVrchola2 = vrchol2;
    }

    public String getNazovVrchola1() {
        return this.nazovVrchola1;
    }

    public String getNazovVrchola2() {
        return this.nazovVrchola2;
    }

    public int getCenaHrany() {
        return this.cenaHrany;
    }
}
