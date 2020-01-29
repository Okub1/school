public class Test {

    /**
     * slúži na overenie správnosti riešenia
     * metóda triedy, pomocou ktorej sa overuje funkčnosť jednotlivých metód
     * Hodnoty pre jednotlivé parametre konštruktorov a metód  môžete zadávať ako konštanty / literály alebo
     * načítať z klávesnice.
     * V metóde main vytvorte preteky a pridajte pretekom dvoch pretekárov. Vytvorte dve streľby , ktoré
     * priradíte dvom pretekárom v preteku. Zmeňte pretekárom v preteku dobehnuté časy. Vypíšte informácie
     * o objekte preteky . Nájdite a vypíšte víťaza pretekov.
     * Vytvorte metódu main tak, aby sa po spustení metódy main zobrazil v terminálovom okne približne
     * nasledovný výstup:
     *
     * Pretekaju:
     * 101.Bjorndahlen dobehol za 1:38,88 a nastrielal Hodnoty:X X X X X
     * 102 .Kuzmina dobehol za 3:40,00 a nastrielal Hodnoty:X - X - X
     * Vitazom pretekov je:101 .Biorndahlen dobehol za 1:38,88 a nastrielal Hodnoty:X X X X X
     */
    public static void main(String[] args) {
        Preteky preteky = new Preteky();

        preteky.pridajPretekara("Bjorndahlen"); // 100
        preteky.pridajPretekara("Kuzmina"); // 101

        Strelba strelba1 = new Strelba(5);

        strelba1.vlozZasah(1);
        strelba1.vlozZasah(2);
        strelba1.vlozZasah(3);
        strelba1.vlozZasah(4);
        strelba1.vlozZasah(5);

        Strelba strelba2 = new Strelba(5);

        strelba2.vlozZasah(1);
        strelba2.vlozZasah(3);
        strelba2.vlozZasah(5);


        preteky.nastavStrelbuPretekarovi(100, strelba1);
        preteky.nastavStrelbuPretekarovi(101, strelba2);

        preteky.natavCasPretekarovi(100, 22000);
        preteky.natavCasPretekarovi(101, 9888);

        System.out.println(preteky.toString());

        System.out.println(preteky.najdiVitaza().toString());

        // TODO dorobit vypocet casu na zaklade trafenych/netrafenych tercov

    }
}
