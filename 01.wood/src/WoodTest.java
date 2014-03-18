import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class WoodTest {
	
	char [][] miniWood = new char [4][4];
	
	@Before
	public void myWood(){
		/*
		 * 1111
		 * 10K1
		 * 1L01
		 * 1111
		 */
		for (int i = 0; i < 4; i++ )
		{	miniWood[i][0] = '1';
			miniWood[i][3] = '1';
		}
		miniWood[0][1] = '1';
		miniWood[0][2] = '1';
		miniWood[3][1] = '1';
		miniWood[3][2] = '1';
		miniWood[2][1] = 'L';
		miniWood[1][2] = 'K';
		miniWood[1][1] = '0';
		miniWood[2][2] = '0';
	}
	
	@Test
	public void testMove() {
		My_Wood one = new My_Wood(miniWood);
		Point my = new Point(1,1);
		one.createWoodman("A", my);
		assertEquals(Action.WoodmanNotFound, one.move("B", Direction.Down));
		assertEquals(Action.Fail, one.move("A", Direction.Up));
		assertEquals(Action.Life, one.move("A", Direction.Down));
		assertEquals(Action.Ok, one.move("A", Direction.Right));
	}
	@Test
	public void testMoveKill() {
		My_Wood one = new My_Wood(miniWood);
		Point my = new Point(1,1);
		one.createWoodman("A", my);
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
		Point my = new Point(1,1);
		one.createWoodman("A", my);
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
}
