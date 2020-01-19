package serialy;

import javax.xml.crypto.Data;

public class main {

    public static void main(String[] args) {
        Serial serial1 = new Serial("Susedia", "Janko Hrasko", 25, 4);
        Serial serial2 = new Serial("GoT", "Ferko Mrkvicka", 50, 1);
        Serial serial3 = new Serial("Westworld", "HBO", 50, 5);
        DatabazaSerialov databazaSerialov = new DatabazaSerialov();
        databazaSerialov.pridajSerial(serial1);
        databazaSerialov.pridajSerial(serial2);
        databazaSerialov.pridajSerial(serial3);
        databazaSerialov.najdiVsetkySerialyTvorcu("Janko Hrasko");
        databazaSerialov.najdiVsetkySerialySDanymHodnotenim(4);
        databazaSerialov.najdiVsetkySerialySDanymHodnotenim(1);
        databazaSerialov.najdiVsetkySerialySDanymHodnotenim(5);
        databazaSerialov.vypisVsetkySerialy();
    }

}
