import javax.swing.table.AbstractTableModel;

public abstract class Jaratok extends AbstractTableModel {

    public abstract void add(Jarmu o);

    public abstract Jarmu get(int index);

    public abstract void remove(String id);

    public abstract int size();

    public abstract void save();

    public abstract void load();

    // returns true if id is in use
    public abstract boolean checkID(String id);

    public abstract int getRowCount();

    public abstract int getColumnCount();
}
