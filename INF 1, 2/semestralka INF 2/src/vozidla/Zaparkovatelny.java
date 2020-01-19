package vozidla;

import exceptions.ZlyParameterException;

/**
 * Interface, ktory implementuju vsetky vozidla, ktora sa daju zaparkovat do garaze.
 */
public interface Zaparkovatelny {

    String getSpz();
    void setSpz(String spz) throws ZlyParameterException;
    double getHmotnost();
    void setHmotnost(double hmotnost) throws ZlyParameterException;
    String toString();
}
