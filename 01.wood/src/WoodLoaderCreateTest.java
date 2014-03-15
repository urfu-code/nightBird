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
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<ArrayList<String>> listArrayList = new ArrayList<ArrayList<String>>();
        list.add("110");
        list1.add("10L");
        list2.add("1K1");
        listArrayList.add(list);
        listArrayList.add(list1);
        listArrayList.add(list2);

        FileInputStream fileInputStream = new FileInputStream("input.txt");
        WoodLoaderCreate woodLoaderCreate = new WoodLoaderCreate();
        assertEquals(new MyWood(listArrayList), woodLoaderCreate.Load(fileInputStream));
    }
}
