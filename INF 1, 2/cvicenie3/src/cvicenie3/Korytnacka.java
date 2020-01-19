/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvicenie3;


public class Korytnacka implements IBeziaci {
    
    private int prejdeneJednotky;
    private int pocetBehov;
    
    public Korytnacka() {
        this.prejdeneJednotky = 0;
        this.pocetBehov = 0;
    }
    
    public int getPocetBehov() {
        return this.pocetBehov;
    }
    
    public String getNazov() {
        return "korytnacka";
    }
    
    public int getPrejdeneJednotky() {
        return this.prejdeneJednotky;
    }

    @Override
    public void bez() {
        this.prejdeneJednotky = this.prejdeneJednotky + 1;
        this.pocetBehov++;
    }

    @Override
    public boolean somVCieli(int dlzkaTrate) {
        if (this.prejdeneJednotky < dlzkaTrate) {
            return false;
        } else {
            return true;
        }
    }
    
}
