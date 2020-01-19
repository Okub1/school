/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvicenie3;

import java.util.Random;

public class Zajac implements IBeziaci {

    private int pocetBehov;
    private int prejdeneJednotky;

    public Zajac() {
        this.prejdeneJednotky = 0;
        this.pocetBehov = 0;
    }

    public String getNazov() {
        return "zajac";
    }

    public int getPocetBehov() {
        return this.pocetBehov;
    }

    @Override
    public void bez() {
        Random rand = new Random();
        int pravdepodobnost = 0;
        int pom = rand.nextInt(9) + 0;

        if (pom < 9 - this.pocetBehov) {
            this.prejdeneJednotky = this.prejdeneJednotky + 5;
        } else {
             this.prejdeneJednotky = this.prejdeneJednotky + 1;
        }
        if (pravdepodobnost <= 8) {
            pravdepodobnost++;
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
