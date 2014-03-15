import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Алексей on 11.03.14.
 */
public class WoodCreateTest extends TestCase {
    @Test
    public void testGetLifeCount() throws Exception {
        WoodCreate man = new WoodCreate("man", new Point(1, 1));
        assertEquals(3, man.GetLifeCount());
        man.Kill();
        assertEquals(2, man.GetLifeCount());
        man.Kill();
        man.Kill();
        man.AddLife();
        assertEquals(1, man.GetLifeCount());

    }

    @Test
    public void testGetName() throws Exception {
        WoodCreate test = new WoodCreate("test", new Point(1, 1));
        assertEquals("test", test.GetName());

    }

    @Test
    public void testKill() throws Exception {
        WoodCreate man = new WoodCreate("man", new Point(1, 1));
        assertEquals(3, man.GetLifeCount());
        man.Kill();
        man.Kill();
        assertEquals(true, man.Kill());
        assertEquals(false, man.Kill());

    }

    @Test
    public void testAddLife() throws Exception {
        WoodCreate man = new WoodCreate("man", new Point(1, 1));
        man.AddLife();
        assertEquals(4, man.GetLifeCount());

    }

    @Test
    public void testGetLocation() throws Exception {
        WoodCreate man = new WoodCreate("man", new Point(1, 1));
        assertEquals(new Point(1, 1), man.GetLocation());

    }

    @Test
    public void testSetLocation() throws Exception {
        WoodCreate man = new WoodCreate("man", new Point(1, 1));
        man.SetLocation(new Point(2, 1));
        assertEquals(new Point(2, 1), man.GetLocation());

    }

    @Test
    public void testMoveToStart() throws Exception {

    }
}
