package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import wood01.Action;
import wood01.Direction;
import wood01.Point;
import wood01.TheWood;

public class TestWood {
	
	@Test
	public void testMove() throws Exception {
		char[][] wood =  {
			{'1','0','1'},
			{'L','0','1'},
			{'0','K','1'},
		};
		TheWood testWood = new TheWood(wood);
		testWood.createWoodman("kolya", new Point(1,1));
		assertEquals(Action.WoodmanNotFound, testWood.move("nekolya", Direction.Up));
		assertEquals(Action.Fail, testWood.move("kolya", Direction.Right));
		assertEquals(Action.Ok, testWood.move("kolya", Direction.Up));
		assertEquals(Action.Ok, testWood.move("kolya", Direction.Down));
		assertEquals(Action.Life, testWood.move("kolya", Direction.Left));
		assertEquals(Action.Ok, testWood.move("kolya", Direction.Down));
		assertEquals(Action.Dead, testWood.move("kolya", Direction.Right));
		testWood.move("kolya", Direction.Up);
		testWood.move("kolya", Direction.Down);
		testWood.move("kolya", Direction.Up);
		testWood.move("kolya", Direction.Down);
		testWood.move("kolya", Direction.Up);
		testWood.move("kolya", Direction.Down);
		testWood.move("kolya", Direction.Up);
		assertEquals(Action.WoodmanNotFound, testWood.move("kolya", Direction.Down));
		testWood.createWoodman("petya", new Point(1,1));
		testWood.move("petya", Direction.Left);
		testWood.move("petya", Direction.Up);
		testWood.move("petya", Direction.Down);
		assertEquals(Action.Dead, testWood.move("petya", Direction.Right));
		assertEquals(Action.Dead, testWood.move("petya", Direction.Right));
		assertEquals(Action.Dead, testWood.move("petya", Direction.Right));
		assertEquals(Action.Dead, testWood.move("petya", Direction.Right));
		assertEquals(Action.Dead, testWood.move("petya", Direction.Right));
		assertEquals(Action.WoodmanNotFound, testWood.move("petya", Direction.Right));
		
	}
	
	@Test(expected = Exception.class)
	public void testException() throws Exception {
		char[][] wood =  {
				{'1','0','1'},
				{'L','0','1'},
				{'0','K','1'},
			};
		TheWood testWood = new TheWood(wood);
		testWood.createWoodman("vasya", new Point(-1,-1));
	}
	
	@Test(expected = Exception.class)
	public void test2Exception() throws Exception {
		char[][] wood =  {
				{'1','0','1'},
				{'L','0','1'},
				{'0','K','1'},
			};
		TheWood testWood = new TheWood(wood);
		testWood.createWoodman("vasya", new Point(1,0));
		testWood.move("vasya", Direction.Up);
	}
	
	@Test(expected = Exception.class)
	public void test3Exception() throws Exception {
		char[][] wood =  {
				{'1','0','1'},
				{'L','0','1'},
				{'0','K','1'},
			};
		TheWood testWood = new TheWood(wood);
		testWood.createWoodman("vasya", new Point(0,0));
	}
}
