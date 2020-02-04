public class Obvody {
    public static void main(String[] args) {
        // vytvaranie dvoch obvodov (serioveho a paralelneho)
        Obvod obvod1 = new Obvod(TypObvodu.SERIOVY);
        Obvod obvod2 = new Obvod(TypObvodu.PARALELNY);

        // vytvaranie suciastok pre nasledne vlozenie do obvodu
        Rezistor rezistor1 = new Rezistor(Farba.HNEDA, Farba.CIERNA, Farba.ZLTA, Farba.ZLATA);
        Rezistor rezistor2 = new Rezistor(Farba.ZLTA, Farba.FIALOVA, Farba.ZLTA, Farba.HNEDA);
        Rezistor rezistor3 = new Rezistor(Farba.CERVENA, Farba.ORANZOVA, Farba.CERVENA, Farba.ZLATA);

        // pridavanie suciastok do druheho (serioveho) obvodu
        obvod1.pridajSuciastku(rezistor1);
        obvod1.pridajSuciastku(rezistor2);
        obvod1.pridajSuciastku(rezistor3);

        // pridavanie suciastok do druheho (paralelneho) obvodu
        obvod2.pridajSuciastku(rezistor1);
        obvod2.pridajSuciastku(rezistor2);
        obvod2.pridajSuciastku(rezistor3);

        // vypis oboch obvodov (suciastky + celkovy vypocitany odpor)
        obvod1.vypisObvod();
        obvod2.vypisObvod();
    }
}
