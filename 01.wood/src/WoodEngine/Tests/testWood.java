package WoodEngine.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import WoodEngine.Action;
import WoodEngine.Direction;
import WoodEngine.Point;
import WoodEngine.Wood;

public class testWood {
	
	Character[] a = {'1', '1', '1', '1', '1', '0', '0', '1', '1', '2', '3', '1', '1', '1', '1', '1'};

	@Test
	public final void testCreateWoodman() throws Exception {
		Wood w = new Wood(a, 4, 4);
		w.createWoodman("nurofen", new Point(1, 1));
		assertTrue(w.move("nurofen", Direction.Right) == Action.Ok);
	}

	@Test
	public final void testMove() throws Exception {
		Wood w = new Wood(a, 4, 4);
		w.createWoodman("nurofen", new Point(1, 1));
		assertTrue(w.move("nurofen", Direction.Down) == Action.Dead);
		assertTrue(w.move("nurofen", Direction.Right) == Action.Life);
		assertTrue(w.move("nurofen", Direction.Up) == Action.Ok);
		assertTrue(w.move("nurofen", Direction.Down) == Action.Life);
		assertTrue(w.move("nurofen", Direction.Left) == Action.Dead);
		assertTrue(w.move("nurofen", Direction.None) == Action.Dead);
		assertTrue(w.move("nurofen", Direction.None) == Action.Dead);
		assertTrue(w.move("nurofen", Direction.None) == Action.Dead);
		assertTrue(w.move("nurofen", Direction.None) == Action.WoodmanNotFound);
	}

}
