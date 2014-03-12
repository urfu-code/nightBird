import static org.junit.Assert.*;

import org.junit.Test;


public class testMyWood {

	@Test
	public void testMoveWoodmanNotFound1() {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("B", Direction.Up) == Action.WoodmanNotFound);
	}

	@Test
	public void testMoveWoodmanNotFound2() {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood);
		wood.createWoodman("A", new Point (2, 1));
		wood.move("A", Direction.Right);
		wood.move("A", Direction.Left);
		wood.move("A", Direction.Right);
		wood.move("A", Direction.Left);
		wood.move("A", Direction.Right);
		wood.move("A", Direction.Left);
		assert (wood.move("A", Direction.Right) == Action.WoodmanNotFound);
	}
	
	@Test
	public void testMoveFail() {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("A", Direction.Up) == Action.Fail);
	}
	
	@Test
	public void testMoveOk() {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("A", Direction.Down) == Action.Ok);
	}
	
	@Test
	public void testMoveLife() {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("A", Direction.Right) == Action.Life);
	}
	
	@Test
	public void testMoveDead() {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood);
		wood.createWoodman("A", new Point (1, 1));
		wood.move("A", Direction.Down);
		assert (wood.move("A", Direction.Right) == Action.Dead);
	}
}
