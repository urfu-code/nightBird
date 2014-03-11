import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class WoodTest {
	
	char [][] miniWood = new char [4][4];
	
	@Before
	public void myWood(){
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
		My_Wood one = new My_Wood(miniWood);
	}
	
	@Test
	public void testMove() {
		My_Wood one = new My_Wood(miniWood);
		Point my = new Point(1,1);
		one.createWoodman("A", my);
		assertEquals(Action.WoodmanNotFound, one.move("B", Direction.Down));
		assertEquals(Action.Fail, one.move("A", Direction.Up));
		assertEquals(Action.Life, one.move("A", Direction.Right));
		assertEquals(Action.Ok, one.move("A", Direction.Down));
	}
	@Test
	public void testMoveKill() {
		My_Wood one = new My_Wood(miniWood);
		Point my = new Point(1,1);
		one.createWoodman("A", my);
		assertEquals(Action.Dead, one.move("A", Direction.Down));//2 �����
		assertEquals(Action.Ok, one.move("A", Direction.Up));
		assertEquals(Action.Dead, one.move("A", Direction.Down));//1 �����
		assertEquals(Action.Ok, one.move("A", Direction.Up));
		assertEquals(Action.Dead, one.move("A", Direction.Down));//0
		assertEquals(Action.Ok, one.move("A", Direction.Up));
		assertEquals(Action.WoodmanNotFound, one.move("A", Direction.Down));
	}

}
