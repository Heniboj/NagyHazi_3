public class VonatJegy extends Jegy {
    private int kocsiszam;
    private int hely;

    public VonatJegy(String n, int k, int h) {
        this.nev = n;
        this.kocsiszam = k;
        this.hely = h;
    }

    public int get_kocsiszam() {return kocsiszam;}
    public int get_hely() {return hely;}
}
