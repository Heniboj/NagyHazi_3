public class RepuloJegy extends Jegy {
    private String osztaly;
    private String menu;

    public RepuloJegy(String n, String o, String m) {
        this.nev = n;
        this.osztaly = o;
        this.menu = m;
    }

    public String get_osztaly() {return osztaly;}
    public String get_menu() {return menu;}
}
