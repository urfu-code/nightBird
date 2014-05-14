import static org.junit.Assert.*;

import org.junit.Test;


public class My_WoodTest {

	@Test
	public void testmove() {
		char [][] aoif = new char[4][4];
		aoif[0][0] = '1';
		aoif[0][1] = '1';
		aoif[0][2] = '1';
		aoif[0][3] = '1';
		aoif[1][0] = '1';
		aoif[1][1] = '0';
		aoif[1][2] = 'L';
		aoif[1][3] = '1';
		aoif[2][0] = '1';
		aoif[2][1] = 'K';
		aoif[2][2] = '0';
		aoif[2][3] = '1';
		aoif[3][0] = '1';
		aoif[3][1] = '1';
		aoif[3][2] = '1';
		aoif[3][3] = '1';
		My_Wood my_wood = new My_Wood (aoif);
		Point my = new Point (1,1);
		Point mu = new Point(2,2);
		my_wood.createWoodman("A", my, mu);
		assertEquals(Action.Dead, my_wood.move("A", Direction.Right));
		assertEquals(Action.Fail, my_wood.move("A", Direction.Up));
		assertEquals(Action.Fail, my_wood.move("A", Direction.Right));
		assertEquals(Action.Ok, my_wood.move("A", Direction.Down));
		assertEquals(Action.Life, my_wood.move("A", Direction.Left));
		assertEquals(Action.Ok, my_wood.move("A", Direction.Up));
		assertEquals(Action.Dead, my_wood.move("A", Direction.Right)); /*2 life */
		assertEquals(Action.Ok, my_wood.move("A", Direction.Left));
		assertEquals(Action.Dead, my_wood.move("A", Direction.Right)); /*1 life */
		assertEquals(Action.Ok, my_wood.move("A", Direction.Left));
		assertEquals(Action.Dead, my_wood.move("A", Direction.Right)); /*0 life */
		assertEquals(Action.Ok, my_wood.move("A", Direction.Left));
		assertEquals(Action.WoodmanNotFound, my_wood.move("A", Direction.Right)); /*-1 life */
		assertEquals(Action.WoodmanNotFound, my_wood.move("B", Direction.Right));
	}

}
