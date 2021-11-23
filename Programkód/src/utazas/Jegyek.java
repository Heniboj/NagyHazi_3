package utazas;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jegyek<T> implements Serializable{
    List<T> tarolo;

    public Jegyek() {
        tarolo = new ArrayList<T>();
    }

    
    /** 
     * Objektum hozzáadása a tárolóhoz
     * @param o az objektum
     */
    public void add(T o) {
        tarolo.add(o);
    }

    
    /** 
     * Objektum lekérése a tárolóból a foglalás száma alapján
     * @param confirmationNumber a foglalás száma
     * @return T az objektum
     * @throws TicketNotFoundException nem létező foglalás esetén dobott kivétel
     */
    public T get(int confirmationNumber) throws TicketNotFoundException {
        for(int i = 0; i < tarolo.size(); i++) {
            if(((Jegy)tarolo.get(i)).get_ConfirmationNumber() == confirmationNumber) {
                return tarolo.get(i);
            }
        }
        throw new TicketNotFoundException("A keresett jegy nem található!");
    }

    
    /** 
     * Objektum lekérése a tárolóból az indexe alapján
     * @param index az objektum indexe a tárolóban
     * @return T az objektum
     */
    public T getByIndex(int index) {
        return tarolo.get(index);
    }
    
    /** 
     * Foglalás törlése a tárolóból
     * @param confirmationNumber a foglalás száma
     */
    public void remove(int confirmationNumber) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(((Jegy)tarolo.get(i)).get_ConfirmationNumber() == confirmationNumber) {
                tarolo.remove(i);
            }
        }
    }

    
    /** 
     * A tároló mérete
     * @return int a méret
     */
    public int size() {
        return tarolo.size();
    }

    /**
     * tároló szerializálása
     */
    public void save() {
        try {
            FileOutputStream f = new FileOutputStream("jegyek.dat");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(tarolo);
            out.close();
            }
            catch(IOException ex) {  }
    }

    /**
     * szerializált adatok beolvasása
     */
    public void load() {
        try {
            FileInputStream f = new FileInputStream("jegyek.dat");
            ObjectInputStream in = new ObjectInputStream(f);
            this.tarolo = (ArrayList<T>)in.readObject();
            in.close();
            } 
            catch(IOException ex) {} 
            catch(ClassNotFoundException ex) {}
    }
}
