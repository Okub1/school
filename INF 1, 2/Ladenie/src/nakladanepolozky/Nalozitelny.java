

package nakladanepolozky;

import java.io.Serializable;

public interface Nalozitelny extends Serializable{
    /*public*/ String getEvidencneCislo();
    /*public*/ double getHmotnost();
    /*public*/ boolean equals(Object o);
    /*public*/ int hashCode();
    /*public*/ String toString();
}
