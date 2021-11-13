package utazas;
public class VonatJegy extends Jegy {
    private int kocsiszam;
    private int hely;

    public VonatJegy(int cn, String n, int k, int h) {
        this.confirmationNumber = cn;
        this.nev = n;
        this.kocsiszam = k;
        this.hely = h;
    }

    public int get_kocsiszam() {return kocsiszam;}
    public int get_hely() {return hely;}
}
