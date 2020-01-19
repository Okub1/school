/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cvicenie3;

/**
 *
 * @author gonsorova
 */
public class cvicenie3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LesnyZavod lesnyZavod = new LesnyZavod(1000000);
        Korytnacka korytnacka = new Korytnacka();
        lesnyZavod.pridajBezca(korytnacka);
        Jezko jezko = new Jezko();
        lesnyZavod.pridajBezca(jezko);
        Zajac zajac = new Zajac();
        lesnyZavod.pridajBezca(zajac);
        System.out.println(lesnyZavod.informacieOBehu());
        lesnyZavod.simulujBeh();
        
    }
    
}
