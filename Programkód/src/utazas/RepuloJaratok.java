package utazas;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RepuloJaratok extends Jaratok {
    private List<Repulo> tarolo;

    public RepuloJaratok() {
        tarolo = new ArrayList<Repulo>();
    }

    
    /** 
     * Objektum hozzáadása a tárolóhoz
     * @param o az objektum
     */
    public void add(Jarmu o) {
        tarolo.add((Repulo)o);
    }

    
    /** 
     * Repülő lekérése a tárolóból
     * @param index sorszám
     * @return Repulo a repülő
     */
    public Repulo get(int index) {
        return tarolo.get(index);
    }

    
    /** 
     * Repülő eltávolítása a tárolóból
     * @param id azonosító
     */
    public void remove(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id() == id) {
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
     * Azonosító ellenőrzése
     * @param id az azonosító
     * @return boolean igaz, ha a megadott azonosító már benne van a tárolóban
     */
    public boolean checkID(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id() == id) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * @return int
     */
    public int getRowCount() {
        return tarolo.size();
    }

    
    /** 
     * @return int
     */
    public int getColumnCount() {
        return 6;
    }

    /**
     * tároló szerializálása
     */
    public void save() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("repulojaratok.dat"));
            out.writeObject(tarolo);
            out.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * szerializált adatok beolvasása
     */
    public void load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("repulojaratok.dat"));
            tarolo = (List<Repulo>)in.readObject();
            in.close();
        } 
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /** 
     * @param rowIndex
     * @param columnIndex
     * @return Object
     */
    public Object getValueAt(int rowIndex, int columnIndex) {

        Repulo r = tarolo.get(rowIndex);
        switch(columnIndex) {
            case 0: return r.get_id();
            case 1: return r.get_ind_all();
            case 2: return r.get_erkez_all();
            case 3: return r.get_ind_dt().toString();
            case 4: return r.get_erkez_dt().toString();
            default: return r.get_ferohely();
        }
    }
        
    /** 
     * @param column
     * @return String
     */
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "Indulási repülőtér";
            case 2: return "Érkezési repülőtér";
            case 3: return "Indulási dátum";
            case 4: return "Érkezési dátum";
            default: return "Férőhely";
        }
    }
}
