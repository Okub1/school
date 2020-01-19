package osoby;

import exceptions.ZlyParameterException;

/**
 * Trieda hasic, ktora definuje co moze hasic vykonat.
 */
public class Hasic extends Osoba {
    /**
     * Atribut, ktory definuje vek hasica.
     */
    private int vek;
    /**
     * Atribut, ktory definuje pohlavie hasica.
     */
    private Pohlavie pohlavie;
    /**
     * Atribut, ktory definuje hmotnost hasica.
     */
    private double hmotnost;
    /**
     * Atribut, ktory definuje meno hasica.
     */
    private String meno;
    /**
     * Atribut, ktory definuje mzdu hasica.
     */
    private int mzda;


    /**
     * Konstruktor hasica, ktory nam umoznuje vytvorit objekt Hasic, v pripade zle zadaneho parametru vyhodi chybu.
     *
     * @param vek vek hasica.
     * @param pohlavie pohlavie hasica.
     * @param hmotnost hmotnost hasica.
     * @param meno meno hasica.
     * @param mzda mzda hasica.
     * @throws ZlyParameterException vynimka v pripade zleho parametra.
     */
    public Hasic(int vek, Pohlavie pohlavie, double hmotnost, String meno, int mzda) throws ZlyParameterException {
        if (vek >= Osoba.VEK_DOSPELOSTI) {
            this.vek = vek;
        } else {
            throw new ZlyParameterException("Zly vek osoby: " + vek);
        }

        if (pohlavie == Pohlavie.MUZ || pohlavie == Pohlavie.ZENA) {
            this.pohlavie = pohlavie;
        } else {
            throw new ZlyParameterException("Zla pohlavie osoby: " + pohlavie);
        }

        if (hmotnost >= 0) {
            this.hmotnost = hmotnost;
        } else {
            throw new ZlyParameterException("Zla hmotnost osoby: " + hmotnost);
        }

        if (mzda >= Osoba.MINIMALNA_MZDA) {
            this.mzda = mzda;
        } else {
            throw new ZlyParameterException("Zla mzda osoby: " + mzda);
        }

        if (meno != null) {
            this.meno = meno;
        } else {
            throw new ZlyParameterException("Zle meno osoby.");
        }
    }

    /**
     * Metoda na vracanie veku hasica.
     *
     * @return vrati vek hasica.
     */
    @Override
    public int getVek() {
        return this.vek;
    }

    /**
     * Metoda na zadavanie veku hasica, kontroluje sa ci je spravne zadany parameter.
     *
     * @param vek zadavany vek hasica.
     * @throws ZlyParameterException vynimka v pripade zle zadaneho veku.
     */
    @Override
    public void setVek(int vek) throws ZlyParameterException {
        if (vek >= 0) {
            this.vek = vek;
        } else {
            throw new ZlyParameterException("Zly vek osoby: " + vek);
        }
    }

    /**
     * Metoda na ziskanie pohlavia hasica.
     *
     * @return vrati pohlavie hasica.
     */
    @Override
    public Pohlavie getPohlavie() {
        return this.pohlavie;
    }

    /**
     * Metoda na nastavanie pohlavia hasica, v pripade zle zadaneho parametru vyhodi chybu.
     * Pohlavie moze byt len Pohlavie.MUZ, alebo Pohlavie.ZENA.
     *
     * @param pohlavie pohlavie hasica.
     * @throws ZlyParameterException vyhodi chybu v pripade zle zadaneho paramatra.
     */
    @Override
    public void setPohlavie(Pohlavie pohlavie) throws ZlyParameterException {
        if (pohlavie == Pohlavie.MUZ || pohlavie == Pohlavie.ZENA) {
            this.pohlavie = pohlavie;
        } else {
            throw new ZlyParameterException("Zla pohlavie osoby: " + pohlavie);
        }
    }

    /**
     * Metoda na vracanie mzdy hasica.
     *
     * @return vrati mzdu hasica.
     */
    @Override
    public int getMzda() {
        return this.mzda;
    }

    /**
     * Metoda na nastavenie mzdy hasica, v pripade zle zadaneho parametru vyhodi chybu.
     *
     * @param mzda nova mzdy hasica.
     * @throws ZlyParameterException vynimka v pripade zle zadaneho parametra.
     */
    @Override
    public void setMzda(int mzda) throws ZlyParameterException {
        if (mzda >= Osoba.MINIMALNA_MZDA) {
            this.mzda = mzda;
        } else {
            throw new ZlyParameterException("Zla mzda osoby: " + mzda);
        }
    }

    /**
     * Metoda na vracanie mena hasica.
     *
     * @return vrati meno hasica.
     */
    @Override
    public String getMeno() {
        return this.meno;
    }

    /**
     * Metoda na vracanie hmotnost hasica.
     *
     * @return vrati hmotnost hasica.
     */
    @Override
    public double getHmotnost() {
        return this.hmotnost;
    }

    /**
     * Metoda na nastavenie hmotnost hasica, v pripade zle zadaneho parametra, vyhodi chybu.
     *
     * @param hmotnost nova hmotnost hasica.
     * @throws ZlyParameterException vynimka v pripade zle zadaneho parametra.
     */
    @Override
    public void setHmotnost(double hmotnost) throws ZlyParameterException {
        if (hmotnost >= 0) {
            this.hmotnost = hmotnost;
        } else {
            throw new ZlyParameterException("Zla hmotnost osoby: " + hmotnost);
        }
    }

    /**
     * Metoda na vracanie textoveho retazca s informaciami o hasicovi.
     *
     * @return vrati vsetky informacie o hsaicovi v textovom retazci.
     */
    @Override
    public String toString() {
        return "\nHasic\n\tMeno: \t\t\t" + this.meno
                + "\n\tVek: \t\t\t" + this.vek
                + "\n\tPohlavie: \t\t" + this.pohlavie
                + "\n\tHmotnost: \t\t" + this.hmotnost
                + "\n\tMzda: \t\t\t" + this.mzda;
    }
}
