import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Jaratok<T> {
    List<T> tarolo;

    public Jaratok(int i) {
        tarolo = new ArrayList<T>();
    }

    public void add(T o) {
        tarolo.add(o);
    }
    public T get(int index) {
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
            FileOutputStream f = new FileOutputStream("jaratok.txt");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(tarolo);
            out.close();
            }
            catch(IOException ex) {  }
    }

    public void load() {
        try {
            FileInputStream f = new FileInputStream("jaratok.txt");
            ObjectInputStream in = new ObjectInputStream(f);
            this.tarolo = (ArrayList<T>)in.readObject();
            in.close();
            } 
            catch(IOException ex) {} 
            catch(ClassNotFoundException ex) {}
    }
}
