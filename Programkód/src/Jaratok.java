import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import java.io.*;

public class Jaratok extends AbstractTableModel {
    private ArrayList<Jarmu> tarolo;

    public Jaratok() {
        tarolo = new ArrayList<Jarmu>();
    }

    public void add(Jarmu o) {
        tarolo.add(o);
    }
    public Jarmu get(int index) {
        return tarolo.get(index);
    }
    public void remove(String jaratazonosito) {
        // TODO
    
    }
    public int size() {
        return tarolo.size();
    }

    public void save() {
        try {
            FileOutputStream f = new FileOutputStream("jaratok.dat");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(tarolo);
            out.close();
            }
            catch(IOException ex) {  }
    }

    public void load() {
        try {
            FileInputStream f = new FileInputStream("jaratok.dat");
            ObjectInputStream in = new ObjectInputStream(f);
            this.tarolo = (ArrayList<Jarmu>)in.readObject();
            in.close();
            } 
            catch(IOException ex) {} 
            catch(ClassNotFoundException ex) {}
    }

    public int getRowCount() {
        return tarolo.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        return null;

    }
}
