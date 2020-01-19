
import Vynimky.PridaniePolozkyException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import nakladanepolozky.Cukrik;
import nakladanepolozky.Krokodil;
import nakladanepolozky.PrichutCukrika;
import nakladanepolozky.StavKrokodila;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prochazka6
 */
public class Aplikacia9 {

    public static void main(String[] args) {
        Cukrik c = new Cukrik("123", 0.05, PrichutCukrika.JAHODOVA, System.currentTimeMillis());
        System.out.println(c);
        System.out.println(c.ulozDoSuboru("cukrik.txt"));
        
        try {
            Cukrik c2 = new Cukrik("cukrik.txt");
            System.out.println(c2);
        } catch (IOException cukrikE) {
            System.out.println(cukrikE.getMessage());
        }
        
        try {
        NakladnyPriestor7 np = new NakladnyPriestor7(3, 10, 1000);
        np.pridajPolozku(c);
        System.out.println(np);
        
        File prud = new File("np.bin");
        FileOutputStream prudVyst = new FileOutputStream(prud);
        ObjectOutputStream zapisovac = new ObjectOutputStream(prudVyst);
        
        zapisovac.writeObject(np);
        
        zapisovac.close();
        
        FileInputStream prudVst = new FileInputStream(prud);
        ObjectInputStream citac = new ObjectInputStream(prudVst);
        NakladnyPriestor7 np2 = (NakladnyPriestor7)citac.readObject();
        citac.close();
        
            System.out.println(np2);
            } catch(IOException npE) {
            System.out.println(npE.getMessage());
        } catch (PridaniePolozkyException pridanieE ) {
            System.out.println(pridanieE.getMessage());
        } catch (ClassNotFoundException np2E) {
            System.out.println(np2E.getMessage());
        }
        
        Krokodil k = new Krokodil("12345", 50, 700, StavKrokodila.ZIVY);
        System.out.println(k);
        k.ulozDoSuboru("krokodil");
    }
    
}
