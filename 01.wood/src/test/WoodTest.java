package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import wood.Action;
import wood.Direction;
import wood.My_Wood;
import wood.Point;


public class WoodTest {
	
	char [][] miniWood = new char [4][];
	
	@Before
	public void myWood(){
		miniWood[0] = new char [] {'1','1','1','1'};
		miniWood[1] = new char [] {'1','0','K','1'};
		miniWood[2] = new char [] {'1','L','0','1'};
		miniWood[3] = new char [] {'1','1','1','1'};
	}
	
	@Test
	public void testMove() {
		My_Wood one = new My_Wood(miniWood);
		Point myS = new Point(1,1);
		Point myF = new Point(2,1);
		one.createWoodman("A", myS, myF);
		assertEquals(Action.WoodmanNotFound, one.move("B", Direction.Down));
		assertEquals(Action.Fail, one.move("A", Direction.Up));
		assertEquals(Action.Life, one.move("A", Direction.Down));
		assertEquals(Action.Ok, one.move("A", Direction.Right));
	}
	@Test
	public void testMoveKill() {
		My_Wood one = new My_Wood(miniWood);
		Point myS = new Point(1,1);
		Point myF = new Point(2,2);
		one.createWoodman("A", myS, myF);
		assertEquals(Action.Dead, one.move("A", Direction.Right));//2 
		assertEquals(Action.Ok, one.move("A", Direction.Left));
		assertEquals(Action.Dead, one.move("A", Direction.Right));//1 
		assertEquals(Action.Ok, one.move("A", Direction.Left));
		assertEquals(Action.Dead, one.move("A", Direction.Right));//0
		assertEquals(Action.Ok, one.move("A", Direction.Left));
		assertEquals(Action.WoodmanNotFound, one.move("A", Direction.Right));
	}
	@Test
	public void testMove2() {
		My_Wood one = new My_Wood(miniWood);
		Point myS = new Point(1,1);
		Point myF = new Point(2,2);
		one.createWoodman("A", myS, myF);
		assertEquals(Action.Life, one.move("A", Direction.Down));//4
		assertEquals(Action.Fail, one.move("A", Direction.Down));//5
		assertEquals(Action.Ok, one.move("A", Direction.Up));
		assertEquals(Action.Dead, one.move("A", Direction.Right));//4
		assertEquals(Action.Fail, one.move("A", Direction.Right));//3
		assertEquals(Action.Fail, one.move("A", Direction.Right));//2
		assertEquals(Action.Fail, one.move("A", Direction.Right));//1
		assertEquals(Action.Fail, one.move("A", Direction.Right));//0
		assertEquals(Action.WoodmanNotFound, one.move("A", Direction.Right));//-1
		
	}
	@Test
	public void testMove3() {
		My_Wood one = new My_Wood(miniWood);
		Point myS = new Point(1,1);
		Point myF = new Point(2,2);
		one.createWoodman("A", myS, myF);
		assertEquals(Action.Life, one.move("A", Direction.Down));
		assertEquals(Action.Finish, one.move("A", Direction.Right));
		assertEquals(Action.WoodmanNotFound, one.move("A", Direction.Right));
	}
}
