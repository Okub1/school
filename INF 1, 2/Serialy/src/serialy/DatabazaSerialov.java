package serialy;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

public class DatabazaSerialov {

    private ArrayList<Serial> serialy = new ArrayList<>();
    private int pocetSerialov;

    public DatabazaSerialov() {
    }

    public int dajPocetSerialov() {
        int size = this.serialy.size();
        System.out.println(size);
        return size;
    }

    public void pridajSerial(Serial serial) {
        boolean existujeSerial = false;

        for (int i = 0; i < this.serialy.size(); i++) {
            if (this.serialy.get(i).getNazov().equals(serial.getNazov())) {
                existujeSerial = true;
                continue;
            } else {
                existujeSerial = false;
                break;
            }
        }

        if (!existujeSerial) {
            this.serialy.add(serial);
        } else {
            System.out.println("Tento serial uz existuje.");
        }
    }

    public void odoberSerial (String nazovSerialu) {
        for (int i = 0; i < this.serialy.size(); i++) {
            if (this.serialy.get(i).getNazov().equals(nazovSerialu)) {
                this.serialy.remove(this.serialy.get(i));
            } else {
                System.out.println("Tento serial neexistuje.");
            }
        }
    }

    public DatabazaSerialov najdiVsetkySerialyTvorcu(String menoTvorcu) {
        if (this.serialy.size() != 0) {
            DatabazaSerialov databazaSerialov = new DatabazaSerialov();

            int pocetSerialov = 0;
            for (Serial aSerialy : this.serialy) {
                if (aSerialy.getTvorca().equals(menoTvorcu)) {
                    databazaSerialov.pridajSerial(aSerialy);
                    pocetSerialov++;
                }
            }

            String pom = "Serialy od tvorcu " + menoTvorcu + ": " + "\n\t";
            for (int i = 0; i < pocetSerialov; i++) {

                pom += databazaSerialov.vypisSerial(i) + ", ";
            }

            System.out.println(pom);
            return databazaSerialov;

        } else {
            System.out.println("Neexistuje serial s danym menom tvorcu.");
            return null;
        }
    }


    //toto potrebujem este opravit nejako, ale nejak sa mi tu nad tym nechce travit zas hodinu...
    //Problem: vypisuje to navyse pridanie serialu...

    public DatabazaSerialov najdiVsetkySerialySDanymHodnotenim(int hodnotenie) {

        if (this.serialy.size() != 0) {
            DatabazaSerialov databazaSerialov = new DatabazaSerialov();

            int pocetSerialov = 0;
            for (Serial aSerialy : this.serialy) {
                if (aSerialy.getHodnotenie() >= hodnotenie) {
                    databazaSerialov.pridajSerial(aSerialy);
                    pocetSerialov++;
                }
            }

            String pom = "Serialy s hodnotenim väčším alebo rovným ako " + hodnotenie + ": " + "\n\t";
            for (int i = 0; i < pocetSerialov; i++) {

                pom += databazaSerialov.vypisSerial(i) + ", ";
            }

            System.out.println(pom);
            return databazaSerialov;
        } else {
            return null;
        }
    }

    public void vypisVsetkySerialy() {
        System.out.println("\n--------------------------------");
        System.out.println("Databaza serialov:");
        for (Serial serial : this.serialy) {
            System.out.println("\nSerial\n\tNazov: " + serial.getNazov()
                    + "\n\tTvorca: " + serial.getTvorca()
                    + "\n\tPocet epizod: " + serial.getPocetEpizod()
                    + "\n\tHodnotenie: " + serial.getHodnotenie());
        }
        System.out.println("--------------------------------");
    }

    private String vypisSerial(int index) {
        return this.serialy.get(index).getNazov();
    }
}
