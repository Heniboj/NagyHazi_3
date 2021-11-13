package utazas;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jegyek<T> implements Serializable{
    List<T> tarolo;

    public Jegyek() {
        tarolo = new ArrayList<T>();
    }

    public void add(T o) {
        tarolo.add(o);
    }

    public T get(int confirmationNumber) throws TicketNotFoundException {
        for(int i = 0; i< tarolo.size(); i++) {
            if(((Jegy)tarolo.get(i)).get_ConfirmationNumber() == confirmationNumber) {
                return tarolo.get(i);
            }
        }
        throw new TicketNotFoundException("A keresett jegy nem található!");
    }

    public void remove(int confirmationNumber) {
        for(int i = 0; i < tarolo.size(); i++) {
            if(((Jegy)tarolo.get(i)).get_ConfirmationNumber() == confirmationNumber) {
                tarolo.remove(i);
            }
        }
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
