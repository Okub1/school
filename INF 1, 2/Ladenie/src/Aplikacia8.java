
import Vynimky.OdobratiePolozkyException;
import Vynimky.PridaniePolozkyException;
import nakladanepolozky.AgenturnyPracovnik;
import nakladanepolozky.Pracovnik;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prochazka6
 */
public class Aplikacia8 {
     public static void main(String[] args) {
     
         AgenturnyPracovnik p = new AgenturnyPracovnik("123", 25, 800, 70, "Ofajc, s.r.o.", 0, 100);
         // Nasledujuci kod sposobi vynimku
        // AgenturnyPracovnik p = new AgenturnyPracovnik("123", 25, 800, 70, "Ofajc, s.r.o.", 0, 100);
         
         Pracovnik pk = new Pracovnik("156", 20, 500, 80);
         System.out.println(p);
         System.out.println(pk);
         
        /*
         NakladnyPriestor6 np = new NakladnyPriestor6(3, 10, 1000);
         try { 
         np.pridajPolozku(p);
         
         } catch (PridaniePolozkyException pridanieE) {
             System.out.println(pridanieE.getMessage());
           //  pridanieE.printStackTrace();
         }
         
         */
        
        
         /*
         try {
         
            NakladnyPriestor6 np = new NakladnyPriestor6(3, 10, 40);
            np.pridajPolozku(p);
            
             System.out.println("Dosiel som na koniec chraneneho kodu");
         
         } catch (PridaniePolozkyException pridanieE) {
             System.out.println(pridanieE.getMessage());
           //  pridanieE.printStackTrace();
         } finally {
             System.out.println("Toto sa vykona vzdy.");
         }*/
         
         /*
         try {
         
            NakladnyPriestor6 np = new NakladnyPriestor6(3, 10, 1000);
            np.pridajPolozku(p);
            np.odoberPolozku("1234");
             System.out.println("Dosiel som na koniec chraneneho kodu");
         
         } catch(OdobratiePolozkyException odobranieE) {
             System.out.println(odobranieE);
         } catch (PridaniePolozkyException pridanieE) {
             System.out.println(pridanieE.getMessage());
           //  pridanieE.printStackTrace();
         } finally {
             System.out.println("Toto sa vykona vzdy.");
         } */
         
         
         try {
         
            NakladnyPriestor6 np = new NakladnyPriestor6(3, 10, 1000);
            np.pridajPolozku(p);
            np.odoberPolozku("123");
             System.out.println("Dosiel som na koniec chraneneho kodu");
         
         }  catch(OdobratiePolozkyException odobranieE) {
             System.out.println(odobranieE);
         } catch (PridaniePolozkyException pridanieE) {
             System.out.println(pridanieE.getMessage());
           //  pridanieE.printStackTrace();
         } catch(Exception chybaE) {
             System.out.println(chybaE.getMessage());
         } finally {
             System.out.println("Toto sa vykona vzdy.");
         }
         
         System.out.println("Program pokracuje bez spadnutia");
         
     }
}
