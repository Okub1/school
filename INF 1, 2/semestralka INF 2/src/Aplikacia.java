import exceptions.MiestoJeObsadeneException;
import exceptions.ZlyParameterException;
import osoby.Hasic;
import osoby.Pohlavie;
import vozidla.HasicskeAuto;
import budovy.HasicskaZbrojnica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Aplikacia {

    public static void main(String[] args) throws ZlyParameterException {
        HasicskaZbrojnica hasicskaZbrojnica = new HasicskaZbrojnica(150, 10, 35, 50, 5);
        HasicskeAuto hasicskeAuto = null;
        HasicskeAuto hasicskeAuto1 = null;

        try {
            hasicskeAuto = new HasicskeAuto("a6s54d", 350.5, 5);
            hasicskeAuto1 = new HasicskeAuto("a6s54d", 350.5, 5);
        } catch (ZlyParameterException e) {
            e.printStackTrace();
        }

        try {
            hasicskaZbrojnica.pridajHasicskeAuto(hasicskeAuto, 1);
        } catch (MiestoJeObsadeneException e) {
            e.printStackTrace();
        }

        try {
            hasicskaZbrojnica.pridajHasicskeAuto(hasicskeAuto1, 2);
        } catch (MiestoJeObsadeneException e) {
            e.printStackTrace();
        }

        Hasic hasic = new Hasic(18, Pohlavie.MUZ, 80.5, "Janko Hrasko", 450);
        hasicskeAuto.pridajHasica(hasic);
        hasicskaZbrojnica.pridajHasica(hasic);

        String nazovSuboru = "databaza vsetkeho";
        File parentDir = new File("src/data");

        try (PrintWriter zapisovac = new PrintWriter(new File(parentDir, nazovSuboru + ".txt"))) {
            zapisovac.println("Zaciatok suboru");
            zapisovac.println(hasicskaZbrojnica.toString());
            zapisovac.println("Koniec suboru.");
        } catch (FileNotFoundException e) {
//            throw new ZlyParameterException("Zly subor alebo cesta k suboru...");
            e.printStackTrace();
        }
    }
}
