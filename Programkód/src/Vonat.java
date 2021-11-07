public class Vonat extends Jarmu{
    private int kocsik_szama;

    public Vonat(String id, String ind_all, String erk_all, Datum ind_dt, Datum erk_dt, int ksz) {
        this.jaratazonosito = id;
        this.indul_allomas = ind_all;
        this.erkez_allomas = erk_all;
        this.indul_datum = ind_dt;
        this.erkez_datum = erk_dt;
        this.kocsik_szama = ksz;
    }

    public int get_kocsik_szama() {return kocsik_szama;}
}
