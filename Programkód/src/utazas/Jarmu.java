package utazas;
import java.io.Serializable;

public class Jarmu implements Serializable{
    protected String jaratazonosito;
    protected String indul_allomas;
    protected String erkez_allomas;
    protected Datum indul_datum;
    protected Datum erkez_datum;

    public String get_id()  {return jaratazonosito;}
    public String get_ind_all()  {return indul_allomas;}
    public Datum get_ind_dt()  {return indul_datum;}
    public String get_erkez_all()  {return erkez_allomas;}
    public Datum get_erkez_dt()  {return erkez_datum;}
}
