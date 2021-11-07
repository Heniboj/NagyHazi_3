import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jegyek<T> {
    List<T> tarolo;

    public Jegyek() { //maybe int i ?
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
            FileOutputStream f = new FileOutputStream("jegyek.dat");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(tarolo);
            out.close();
            }
            catch(IOException ex) {  }
    }

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
