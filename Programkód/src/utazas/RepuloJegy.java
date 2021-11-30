package utazas;
public class RepuloJegy extends Jegy {
    private String osztaly;

    public RepuloJegy(String id, int cn, String n, String o) {
        this.jaratazonosito = id;
        this.confirmationNumber = cn;
        this.nev = n;
        this.osztaly = o;
    }

    public String get_osztaly() {return osztaly;}
}
