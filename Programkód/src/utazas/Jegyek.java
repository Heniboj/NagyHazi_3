package utazas;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jegyek<T> implements Serializable{
    private List<T> tarolo;

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
     * Ellenőrzi, hogy a paraméterek alapján megadott hely szabad-e
     * @param kocsi a kocsiszám
     * @param hely az ülés száma
     * @return boolean
     */
    public boolean checkAvailableSeat(String jaratazonosito, int kocsi, int hely, VonatJaratok jaratok) {
        if(kocsi > ((Vonat)jaratok.getByID(jaratazonosito)).get_kocsik_szama()) {
            return false;
        }
        for(int i = 0; i < tarolo.size(); i++) {
            try {
                if(((VonatJegy)tarolo.get(i)).get_jaratazonosito().equals(jaratazonosito) && ((VonatJegy)tarolo.get(i)).get_kocsiszam() == kocsi && ((VonatJegy)tarolo.get(i)).get_hely() == hely) {
                    return false;
                }
            } catch(ClassCastException ex) {}
        }
        return true;
    }
    
    /** 
     * Ellenőrzi, hogy a paraméterek alapján van-e még szabad hely
     * @param jaratazonosito a járatazonosító
     * @param jaratok a járatok tömb
     * @return boolean
     */
    public boolean checkAvailableSeat(String jaratazonosito, RepuloJaratok jaratok) {
        int foglalt = 0;
        for(int i = 0; i < tarolo.size(); i++) {
            try {
                if(((RepuloJegy)tarolo.get(i)).get_jaratazonosito().equals(jaratazonosito)) {
                    foglalt++;
                }
            } catch(ClassCastException ex) {}
        }
        if(foglalt == jaratok.getByID(jaratazonosito).get_ferohely()) {
            return false;
        }
        return true;
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
