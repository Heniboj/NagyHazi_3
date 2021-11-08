import java.io.Serializable;

public class Datum implements Serializable{
    private int ev;
    private int honap;
    private int nap;
    private int ora;
    private int perc;

    public Datum(int e, int h, int n, int o, int p) {
        this.ev = e;
        this.honap = h;
        this.nap = n;
        this.ora = o;
        this.perc = p;
    }

    public Datum(String datumString) {
        String[] splittedString = datumString.split("/");
        this.ev = Integer.parseInt(splittedString[0]);
        this.honap = Integer.parseInt(splittedString[1]);
        this.nap = Integer.parseInt(splittedString[2]);
        this.ora = Integer.parseInt(splittedString[3]);
        this.perc = Integer.parseInt(splittedString[4]);
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
