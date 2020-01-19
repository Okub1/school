package nakladanepolozky;

import java.io.Serializable;

public interface Zjeditelny extends Serializable{
    /*public*/ Chut getChut();
    /*public*/ boolean jeToCerstve();
    /*public*/ double getVyziva();
    /*public*/ boolean equals(Object o);
    /*public*/ int hashCode();
    /*public*/ String toString();
}
