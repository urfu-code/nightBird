package test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import wood.Action;
import wood.Direction;
import wood.My_Wood;
import wood.My_WoodLoader;
import wood.Point;


public class WoodLoaderTest {
	/*
	 * 	11111111111
		1000L110001
		10LK1000101
		10000001101
		1K0000001L1
		11111111111
	 */
	@Test
	public void testLoad() throws IOException {
		File file = new File("wood.txt");
		InputStream stream = new FileInputStream(file);
		My_WoodLoader my = new My_WoodLoader();
		My_Wood NewWood = my.Load(stream);
		Point start = new Point(1,1);
		Point finish = new Point(7,4);
		NewWood.createWoodman("Ann", start, finish);
		assertEquals(Action.Ok, NewWood.move("Ann", Direction.Down));
		assertEquals(Action.Life, NewWood.move("Ann", Direction.Right));
		assertEquals(Action.Dead, NewWood.move("Ann", Direction.Right));
		assertEquals(Action.Fail, NewWood.move("Ann", Direction.Right));
	}

}
