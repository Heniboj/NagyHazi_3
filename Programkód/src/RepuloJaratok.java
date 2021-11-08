import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RepuloJaratok extends Jaratok {
    private List<Repulo> tarolo;

    public RepuloJaratok() {
        tarolo = new ArrayList<Repulo>();
    }

    public void add(Jarmu o) {
        tarolo.add((Repulo)o);
    }

    public Repulo get(int index) {
        return tarolo.get(index);
    }

    public void remove(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id() == id) {
                tarolo.remove(i);
            }
        }
    }

    public int size() {
        return tarolo.size();
    }

    public boolean checkID(String id) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(tarolo.get(i).get_id() == id) {
                return true;
            }
        }
        return false;
    }

    public int getRowCount() {
        return tarolo.size();
    }

    public int getColumnCount() {
        return 6;
    }

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
