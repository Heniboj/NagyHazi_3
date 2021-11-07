import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class VonatJaratok extends Jaratok  {
    private List<Vonat> tarolo;

    public VonatJaratok() {
        tarolo = new ArrayList<Vonat>();
    }

    public void add(Jarmu o) {
        tarolo.add((Vonat)o);
    }

    public Vonat get(int index) {
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
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vonatjaratok.dat"));
            out.writeObject(tarolo);
            out.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("vonatjaratok.dat"));
            tarolo = (List<Vonat>)in.readObject();
            in.close();
        } 
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    public Object getValueAt(int rowIndex, int columnIndex) {

        Vonat v = tarolo.get(rowIndex);
        switch(columnIndex) {
            case 0: return v.get_id();
            case 1: return v.get_ind_all();
            case 2: return v.get_erkez_all();
            case 3: return v.get_ind_dt().toString();
            case 4: return v.get_erkez_dt().toString();
            default: return v.get_kocsik_szama();
        }
    }
        
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "ID";
            case 1: return "Indulási állomás";
            case 2: return "Érkezési állomás";
            case 3: return "Indulási dátum";
            case 4: return "Érkezési dátum";
            default: return "Kocsik Száma";
        }
    }
}
