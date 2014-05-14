import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;


public class My_WoodLoaderTest {

	@Test
	public void testLoad() throws IOException {
		File file = new File("input.txt");
		InputStream stream = new FileInputStream(file);
		My_WoodLoader my = new My_WoodLoader();
		Wood Wood = my.Load(stream);
		Point start = new Point(1,1);
		Point finish = new Point(2,2);
		Wood.createWoodman("A", start, finish);
		assertEquals(Action.Fail, Wood.move("A", Direction.Up));
		assertEquals(Action.Fail, Wood.move("A", Direction.Left));
		assertEquals(Action.Dead, Wood.move("A", Direction.Right));
		assertEquals(Action.Life, Wood.move("A", Direction.Down));
	}

}
