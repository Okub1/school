public enum Smer {
    VLAVO, VPRAVO, HORE, DOLE;

    public Pozicia posunPoziciu(Pozicia staraPozicia) {
        // posral som niekde indexy v kode, a mam to otocene o 90° doprava, tak som to iba tu poprepisoval
        // preto to mozno nebude davat zmysel :D
        switch (this) {
            case VLAVO:
                return new Pozicia(staraPozicia.getX(), staraPozicia.getY() - 1);
            case VPRAVO:
                return new Pozicia(staraPozicia.getX(), staraPozicia.getY() + 1);
            case HORE:
                return new Pozicia(staraPozicia.getX() - 1, staraPozicia.getY());
            default:
                return new Pozicia(staraPozicia.getX() + 1, staraPozicia.getY());
        }
    }

    public Smer vyberNahodnySmer() {

        // generacia nahodneho cisla
        int min = 0;
        int max = 3;
        int nahodneCiselko = (int)(Math.random()*((max-min)+1))+min;

        // vyber na zaklade vygenerovaneho nahodneho cisla
        switch (nahodneCiselko) {
            case 0: return VLAVO;
            case 1: return VPRAVO;
            case 2: return HORE;
            case 3: return DOLE;
        }

        // DEBUG: (null nikdy nenastane, ale musi tam byt, lebo by sa java stazovala :) )
        //System.out.println("Chyba vyberu nahodneho cisla");
        return null;
    }
}
