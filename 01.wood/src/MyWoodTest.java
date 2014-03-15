import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileInputStream;

/**
 * Created by Алексей on 06.03.14.
 */
public class MyWoodTest extends TestCase {
    @Test
    public void testCreateWoodman() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        WoodLoaderCreate woodLoaderCreate = new WoodLoaderCreate();
        MyWood wood = (MyWood) woodLoaderCreate.Load(fileInputStream);
        wood.createWoodman("man", new Point(0, 2));
        wood.createWoodman("man1", new Point(0, 2));
        assertEquals(wood.woodmansCatalog.containsKey("man"), wood.woodmansCatalog.containsKey("man1"));


    }


    @Test
    public void testMove() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        WoodLoaderCreate woodLoaderCreate = new WoodLoaderCreate();
        MyWood wood = (MyWood) woodLoaderCreate.Load(fileInputStream);
        wood.createWoodman("man", new Point(0, 2));
        assertEquals(Action.Fail, wood.move("man", Direction.Up));
        assertEquals(Action.Life, wood.move("man", Direction.Down));
        assertEquals(Action.Ok, wood.move("man", Direction.Left));
        assertEquals(Action.Dead, wood.move("man", Direction.Down));
        assertEquals(Action.Dead, wood.move("man", Direction.None));
        assertEquals(Action.Dead, wood.move("man", Direction.None));
        assertEquals(Action.Dead, wood.move("man", Direction.None));
        assertEquals(Action.WoodmanNotFound, wood.move("man", Direction.None));

    }


}
