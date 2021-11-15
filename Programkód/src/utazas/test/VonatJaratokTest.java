package utazas.test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utazas.*;

public class VonatJaratokTest extends VonatJaratok {
    private Jaratok jaratok;
    private Datum d1;
    private Datum d2;
    private Vonat v;
    @Before
    public void setup() {
        d1 = new Datum("2021", "11", "30", "12", "00");
        d2 = new Datum("2021", "11", "30", "14", "00");
        v = new Vonat("BUD1", "Budapest", "Szolnok", d1, d2, 5);
        jaratok = new VonatJaratok();
    }

    @Test
    public void testAdd() {
        jaratok.add(v);
        Assert.assertEquals(v, jaratok.get(0));
    }

    @Test
    public void testRemove() {
        jaratok.add(v);
        Vonat v2 = new Vonat("BUD2", "Budapest", "Szeged", d1, d2, 5);
        jaratok.add(v2);
        jaratok.remove("BUD1");
        Assert.assertEquals(v2, jaratok.get(0));
    }

    @Test
    public void testID() {
        jaratok.add(v);
        Assert.assertTrue(jaratok.checkID("BUD1"));
    }
}
