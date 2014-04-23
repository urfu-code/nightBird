
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;


public class testMyWoodLoader {

	@Test
	public void testLoad() throws IOException {
			InputStream stream = new FileInputStream (new File ("labyrinth.txt"));
			MyWoodLoader loader = new MyWoodLoader();
			MyWood wood = loader.Load(stream);
			wood.createWoodman("A", new Point (1, 1));
			assertEquals (wood.move("A", Direction.Down), Action.Ok);
			assertEquals (wood.move("A", Direction.Right), Action.Dead);
			assertEquals (wood.move("A", Direction.Up), Action.Life);
			assertEquals (wood.move("A", Direction.Left), Action.Ok);
			assertEquals (wood.move("A", Direction.Up), Action.Fail);
	}
	
	@Test(expected = IOException.class)
	public void testLoadException() throws IOException
	{
		InputStream stream = new FileInputStream (new File ("labyrinth.txt"));
		MyWoodLoader loader = new MyWoodLoader();
		MyWood wood = loader.Load(stream);
	}
}
