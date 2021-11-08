public class Repulo extends Jarmu {
    private int ferohely;

    public Repulo(String id, String ind_all, String erk_all, Datum ind_dt, Datum erk_dt, int f) {
        this.jaratazonosito = id;
        this.indul_allomas = ind_all;
        this.erkez_allomas = erk_all;
        this.indul_datum = ind_dt;
        this.erkez_datum = erk_dt;
        this.ferohely = f;
    }

    public int get_ferohely() {return ferohely;}
}
