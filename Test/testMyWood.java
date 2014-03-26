import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class testMyWood {
	
	@Test(expected = IOException.class)
	public void testPlayerIsNotCreated() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		wood.createWoodman("A", new Point (2,2));
	}
	
	@Test(expected = IOException.class)
	public void testWall() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (0, 0));
	}

	@Test
	public void testMoveWoodmanNotFound1() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("B", Direction.Up) == Action.WoodmanNotFound);
	}

	@Test
	public void testMoveWoodmanNotFound2() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (2, 2));
		wood.move("A", Direction.Down);
		wood.move("A", Direction.Down);
		wood.move("A", Direction.Down);
		assert (wood.move("A", Direction.Down) == Action.WoodmanNotFound);
	}
	
	@Test
	public void testMoveFail() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 2));
		assert (wood.move("A", Direction.Right) == Action.Fail);
	}
	
	@Test
	public void testMoveOk() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("A", Direction.Down) == Action.Ok);
	}
	
	@Test
	public void testMoveLife() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assert (wood.move("A", Direction.Right) == Action.Life);
	}
	
	@Test
	public void testMoveDead() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[2][1] = '0';
		m_wood[1][2] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		wood.move("A", Direction.Down);
		assert (wood.move("A", Direction.Right) == Action.Dead);
	}
}
