package defpac;

import java.io.IOException;

import junit.framework.TestCase;

public class MyPrintableWoodTest extends TestCase {

	public void testCreateWoodman() throws IOException {
		char[][] wood = {{'1','1','1','1'},{'1','0','K','1'},{'1','0','L','1'},{'1','1','1','1'}};
		MyPrintableWood forest = new MyPrintableWood (wood, null);
		forest.createWoodman("aaa", new Point(1,1));
		assertEquals(forest.move("aaa",Direction.None),Action.Ok);
		forest.printWood();
	}

	public void testMove() throws IOException {
		char[][] forest = {{'1','1','1','1'},{'1','0','K','1'},{'1','0','L','1'},{'1','1','1','1'}};
		MyPrintableWood wood = new MyPrintableWood (forest, null);
		wood.createWoodman("aaa", new Point(1,1));
		assertEquals(wood.move("aaa",Direction.Down),Action.Ok);
		assertEquals(wood.move("aaa",Direction.Right),Action.Life);
		assertEquals(wood.move("aaa",Direction.Up),Action.Dead);
		assertEquals(wood.move("aaa",Direction.None),Action.Dead);
		assertEquals(wood.move("aaa",Direction.Left),Action.Ok);
		assertEquals(wood.move("lol",Direction.Left),Action.WoodmanNotFound);
	}

	/*public void testPrintWood() throws IOException {
		char[][] forest = {{'1','1','1','1'},{'1','0','K','1'},{'1','0','L','1'},{'1','1','1','1'}};
		MyPrintableWood wood = new MyPrintableWood (forest, null);
		wood.createWoodman("aaa", new Point(1,1));
		assertEquals(printWood();)
	}*/

}
