package utazas.test;
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
        v1 = new VonatJegy(1, "Gipsz Jakab", 1, 2);
        v2 = new VonatJegy(3, "Kiss Janos", 1, 5);
        r1 = new RepuloJegy(2, "Kovacs Istvan", "Economy", "minta1");
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
        RepuloJegy r2 = new RepuloJegy(13, "Minta Bence", "Fitst", "minta2");
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
}
