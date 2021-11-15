package utazas.test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utazas.*;

public class RepuloJaratokTest extends RepuloJaratok {
    private Jaratok jaratok;
    private Datum d1;
    private Datum d2;
    private Repulo r;
    @Before
    public void setup() {
        d1 = new Datum("2021", "11", "30", "12", "00");
        d2 = new Datum("2021", "11", "30", "15", "00");
        r = new Repulo("BUD1", "Budapest", "London", d1, d2, 5);
        jaratok = new RepuloJaratok();
    }

    @Test
    public void testAdd() {
        jaratok.add(r);
        Assert.assertEquals(r, jaratok.get(0));
    }

    @Test
    public void testRemove() {
        jaratok.add(r);
        Repulo r2 = new Repulo("BUD2", "Budapest", "Berlin", d1, d2, 5);
        jaratok.add(r2);
        jaratok.remove("BUD1");
        Assert.assertEquals(r2, jaratok.get(0));
    }

    @Test
    public void testSave() {
        jaratok.add(r);
        jaratok.save();
        RepuloJaratok jaratok2 = new RepuloJaratok();
        jaratok2.load();
        // a két objektum nem lesz azonos a visszaolvasás után de attribútumaiknak értéke igen(ID alapján pedig egyértelműen azonosíthatóak)
        Assert.assertEquals(r.get_id(), jaratok2.get(0).get_id());
    }

    @Test
    public void testGetColumnName() {
        Assert.assertEquals("ID", jaratok.getColumnName(0));
        Assert.assertEquals("Indulási repülőtér", jaratok.getColumnName(1));
        Assert.assertEquals("Érkezési repülőtér", jaratok.getColumnName(2));
        Assert.assertEquals("Indulási dátum", jaratok.getColumnName(3));
        Assert.assertEquals("Érkezési dátum", jaratok.getColumnName(4));
        Assert.assertEquals("Férőhely", jaratok.getColumnName(5));
    }
}
