package osoby;

import exceptions.ZlyParameterException;

/**
 * Abstraktna trieda, na vytvaranie osob.
 */
public abstract class Osoba implements Nalozitelny {
    protected static final int VEK_DOSPELOSTI = 18;
    protected static final int MINIMALNA_MZDA = 450;

    public abstract int getVek();

    public abstract void setVek(int vek) throws ZlyParameterException;

    public abstract Pohlavie getPohlavie();

    public abstract void setPohlavie(Pohlavie pohlavie) throws ZlyParameterException;

    public abstract int getMzda();

    public abstract void setMzda(int mzda) throws ZlyParameterException;

    public abstract void setHmotnost(double hmotnost) throws ZlyParameterException;
}
