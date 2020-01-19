
import java.util.ArrayList;
import java.util.Iterator;


public class NakladnyPriestor8<E> implements Iterable<E>{
    private ArrayList<E> nalozenePolozky;
    private int maxPocetPoloziek;
    
public NakladnyPriestor8 (int maxPocetPoloziek) {
    
    nalozenePolozky = new ArrayList<E>();
    
    this.maxPocetPoloziek = maxPocetPoloziek;

    }

    public boolean naloz(E polozka) {
        boolean vysl = false;
        
        if(nalozenePolozky.size() < this.maxPocetPoloziek) {
            nalozenePolozky.add(polozka);
            vysl = true;
        }
        
        return vysl;
    }
    
    public E dajNaklad(int index) {
        if (index < 0 || index >= nalozenePolozky.size()) {
            return null;
        }
        return nalozenePolozky.get(index);
    }
    
    @Override
    public String toString(){
        String vysl = "Nakladny priestor s kapacitou " + maxPocetPoloziek + " ma nalozene nasledovne polozky: \n";
        
        for (E p : nalozenePolozky) {
            vysl = vysl + p.toString() + "\n";
  
        }
        return vysl;
    }
    
    @Override
    public Iterator<E> iterator() {
        return nalozenePolozky.iterator();
    }
    
    
}
