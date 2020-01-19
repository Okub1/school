/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER NB
 */
public class Vrchol {
    private int miestoVrchola;
    private String nazovVrchola;
    private boolean jeRiadiaci = false;
    private int hodnotaVrchola;
    private boolean bolPouzity = false;
    
    void nastavNazov(String nazovVrchola) {
        this.nazovVrchola = nazovVrchola;
    }

    public String getNazovVrchola() {
        return this.nazovVrchola;
    }

    public void setJeRiadiaci() {
        this.jeRiadiaci = !this.jeRiadiaci;
    }

    public boolean isJeRiadiaci() {
        return this.jeRiadiaci;
    }

    void nastavHodnotuVrchola(int hodnotaVrchola) {
        this.hodnotaVrchola = hodnotaVrchola;
    }

    public int getHodnotaVrchola() {
        return this.hodnotaVrchola;
    }

    public void setBolPouzity() {
        this.bolPouzity = !this.bolPouzity;
    }

    public boolean isBolPouzity() {
        return this.bolPouzity;
    }

    public int getMiestoVrchola() {
        return this.miestoVrchola;
    }

    public void setMiestoVrchola(int miestoVrchola) {
        this.miestoVrchola = miestoVrchola;
    }
    
    
}
