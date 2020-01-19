/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvicenie3;

import java.util.ArrayList;

/**
 *
 * @author gonsorova
 */
public class LesnyZavod {

    private ArrayList<IBeziaci> zoznamBezcov;
    private int dlzkaTrate;

    public LesnyZavod(int dlzkaTrate) {
        this.zoznamBezcov = new ArrayList<IBeziaci>();
        this.dlzkaTrate = dlzkaTrate;
    }

    public void pridajBezca(IBeziaci beziaci) {
        this.zoznamBezcov.add(beziaci);
    }

    public void simulujBeh() {
        for (IBeziaci beziaci : this.zoznamBezcov) {
            do {
                beziaci.bez();
            } while (!beziaci.somVCieli(this.dlzkaTrate));
            System.out.println("odbehol ");
        }
        IBeziaci pom = this.zoznamBezcov.get(0);
        for (IBeziaci beziaci : zoznamBezcov) {
            if (beziaci.getPocetBehov() < pom.getPocetBehov()) {
                pom = beziaci;
            }
        }
        System.out.println("vitazom je " + pom.getNazov());
    }

    public void setDlzkaTrate(int novaDlzka) {
        this.dlzkaTrate = novaDlzka;
    }

    public String informacieOBehu() {
        int pom = this.zoznamBezcov.size();
        return String.format("Behu sa zucastnilo " + pom + " bezcov, trat ma dlzku " + this.dlzkaTrate);
    }
}
