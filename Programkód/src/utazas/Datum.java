package utazas;
import java.io.Serializable;

public class Datum implements Serializable{
    private int ev;
    private int honap;
    private int nap;
    private int ora;
    private int perc;

    public Datum(String e, String h, String n, String o, String p) {
        this.ev = Integer.parseInt(e);
        this.honap = Integer.parseInt(h);
        this.nap = Integer.parseInt(n);
        this.ora = Integer.parseInt(o);
        this.perc = Integer.parseInt(p);
    }

    public int get_ev() {return ev;}
    public int get_honap() {return honap;}
    public int get_nap() {return nap;}
    public int get_ora() {return ora;}
    public int get_perc() {return perc;}

    public String toString() {
        String datum = ev+"/"+honap+"/"+nap+" "+ora+":";
        if(perc < 10) {
            datum += "0";
        }
        return datum + perc;  
    }
}
