/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvicenie3;

import java.util.Random;


public class Jezko implements IBeziaci {

    private int prejdeneJednotky;
    private int pocetBehov;
    
    public Jezko() {
        this.prejdeneJednotky = 0;
        this.pocetBehov = 0;
    }
    
    public String getNazov() {
        return "jezko";
    }
    
    public int getPocetBehov() {
        return this.pocetBehov;
    }

    @Override
    public void bez() {
        Random rand = new Random();
        int pom = rand.nextInt(1) + 0;
        if (pom == 0) {
            this.prejdeneJednotky = this.prejdeneJednotky + 2;
        }
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
