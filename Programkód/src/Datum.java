public class Datum {
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

    public int get_ev() {return ev;}
    public int get_honap() {return honap;}
    public int get_nap() {return nap;}
    public int get_ora() {return ora;}
    public int get_perc() {return perc;}
}
