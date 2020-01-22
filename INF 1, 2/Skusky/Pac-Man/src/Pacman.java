public class Pacman {
    private Bludisko bludisko;
    private Pozicia pozicia;

    public Pacman(Bludisko bludisko, Pozicia pozicia) {
        this.bludisko = bludisko;
        this.pozicia = pozicia;
    }

    public Pozicia getPozicia() {
        return pozicia;
    }

    public void krok(Smer smer) {
        if (!bludisko.jeStena(smer.posunPoziciu(pozicia))) {
            pozicia = smer.posunPoziciu(pozicia);
        }
    }
}
