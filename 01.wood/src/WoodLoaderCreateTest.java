import junit.framework.TestCase;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by Алексей on 03.03.14.
 */
public class WoodLoaderCreateTest extends TestCase {
    @Test
    public void testLoad() throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        String s = "110";
        String t = "10L";
        String r = "1K1";
        list.add(s);
        list.add(t);
        list.add(r);
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        WoodLoaderCreate woodLoaderCreate = new WoodLoaderCreate();
        assertEquals(new MyWood(list), woodLoaderCreate.Load(fileInputStream));
    }
}
