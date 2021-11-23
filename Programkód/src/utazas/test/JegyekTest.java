package utazas.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utazas.*;

public class JegyekTest extends Jegyek{
    private Jegyek jegyek;
    private VonatJegy v1;
    private VonatJegy v2;
    private RepuloJegy r1;

    // jegyek tárolója és két minta jegy példányosítása
    @Before
    public void setup() {
        jegyek = new Jegyek();
        v1 = new VonatJegy("BUD1", 1, "Gipsz Jakab", 1, 2);
        v2 = new VonatJegy("SZOL2", 3, "Kiss Janos", 1, 5);
        r1 = new RepuloJegy("DEB5", 2, "Kovacs Istvan", "Economy", "minta1");
        jegyek.add(v1);
        jegyek.add(v2);
        jegyek.add(r1);
    }

    // mintajegyek bekerültek a tárolóba
    @Test
    public void testSetup() throws TicketNotFoundException {
        Assert.assertEquals(v1, jegyek.get(1));
        Assert.assertEquals(v2, jegyek.get(3));
        Assert.assertEquals(r1, jegyek.get(2));
    }

    // jegy hozzáadásának tesztelése
    @Test
    public void testAdd() throws TicketNotFoundException {
        RepuloJegy r2 = new RepuloJegy("BUD2", 13, "Minta Bence", "Fitst", "minta2");
        jegyek.add(r2);
        Assert.assertEquals(r2, jegyek.get(13));
    }

    // jegy törlésének tesztelése
    @Test(expected = TicketNotFoundException.class)
    public void testRemove() throws TicketNotFoundException {
        jegyek.remove(3);
        jegyek.get(3);
    }

    // a törlés után a többi jegynek nem változik a confirmation number-je
    @Test
    public void testConfirmationNumber() throws TicketNotFoundException {
        jegyek.remove(3);
        Assert.assertEquals(v1, jegyek.get(1));
        Assert.assertEquals(r1, jegyek.get(2));
    }

    @Test
    public void testFerohely() {
        for(int i = 0; i < 3; i++) {
            jegyek.add(r1);
        }
        RepuloJaratok jaratok = new RepuloJaratok();
        Datum d1 = new Datum("2021", "11", "30", "12", "00");
        Datum d2 = new Datum("2021", "11", "30", "15", "00");
        jaratok.add(new Repulo("DEB5", "Budapest", "London", d1, d2, 5));
        Assert.assertTrue(jegyek.checkAvailableSeat("DEB5", jaratok));

        jegyek.add(r1);
        Assert.assertFalse(jegyek.checkAvailableSeat("DEB5", jaratok));
    }
}
