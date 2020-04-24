public class Duch {
    private Pozicia pozicia;
    private Bludisko bludisko;

    public Duch(Bludisko bludisko, Pozicia pozicia) {
        this.pozicia = pozicia;
        this.bludisko = bludisko;
    }

    public Pozicia getPozicia() {
        return pozicia;
    }

    public void tik() {
        Smer smer = Smer.DOLE;
        smer = smer.vyberNahodnySmer();

        boolean koniec = false;

        while (!koniec) {
            assert smer != null;
            if (!bludisko.jeStena(smer.posunPoziciu(pozicia))) {
                pozicia = smer.posunPoziciu(pozicia);
                koniec = true;
            } else {
                smer = smer.vyberNahodnySmer();
            }
        }
    }
}
