import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;


public class testMyWoodLoader {

	@Test
	public void testLoad() {
		try {
			InputStream stream = new FileInputStream (new File ("labyrinth.txt"));
			MyWoodLoader loader = new MyWoodLoader();
			MyWood wood = loader.Load(stream);
			wood.createWoodman("A", new Point (1, 1));
			assert (wood.move("A", Direction.Up) == Action.Fail);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
