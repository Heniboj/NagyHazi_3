package utazas;
import java.io.Serializable;

public class Jegy implements Serializable{
   protected String jaratazonosito;
   protected String nev;
   protected int confirmationNumber;
   
   public String get_jaratazonosito() {return jaratazonosito;}
   public int get_ConfirmationNumber() {return confirmationNumber;}
   public String get_nev() {return nev;}
}
