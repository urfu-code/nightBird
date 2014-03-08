import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;


public class WoodLoaderTest {

	@Test
	public void testLoad() throws IOException {
		File file = new File("wood.txt");
		InputStream stream = new FileInputStream(file);
		My_WoodLoader my = new My_WoodLoader();
		My_Wood NewWood = my.Load(stream);
		Point start = new Point(1,1);
		NewWood.createWoodman("Ann", start);
		assertEquals(Action.Ok, NewWood.move("Ann", Direction.Down));
		assertEquals(Action.Life, NewWood.move("Ann", Direction.Right));
		assertEquals(Action.Ok, NewWood.move("Ann", Direction.Right));
		assertEquals(Action.Fail, NewWood.move("Ann", Direction.Right));
	}

}
