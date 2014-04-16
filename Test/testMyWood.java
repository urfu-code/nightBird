
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
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
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
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (0, 0));
	}
	
	@Test
	public void testCreateWoodman() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assertEquals (wood.m_woodmanList.get("A").GetLifeCount(), 3, 0.0);
	}

	@Test
	public void testWoodmanNotFound_PlayerNotExist() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assertEquals(wood.move("B", Direction.None), Action.WoodmanNotFound);
	}
	
	@Test
	public void testOk() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assertEquals (wood.move("A", Direction.Down), Action.Ok);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getX(), 1, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getY(), 2, 0.0);
	}
	
	@Test
	public void testLife() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assertEquals(wood.move("A", Direction.Right), Action.Life);
		assertEquals(wood.m_woodmanList.get("A").GetLifeCount(), 4, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getX(), 2, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getY(), 1, 0.0);
	}
	
	@Test
	public void testKill_Dead() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 2));
		assertEquals(wood.move("A", Direction.Right), Action.Dead);
		assertEquals(wood.m_woodmanList.get("A").GetLifeCount(), 2, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getX(), 2, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getY(), 2, 0.0);
	}
	
	@Test
	public void testKill_WoodmanNotFound() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 2));
		wood.move("A", Direction.Right);
		wood.move("A", Direction.Right);
		wood.move("A", Direction.Right);
		assertEquals(wood.move("A", Direction.Right), Action.WoodmanNotFound);
	}
	
	@Test
	public void testFail() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (1, 1));
		assertEquals(wood.move("A", Direction.Up), Action.Fail);
		assertEquals(wood.m_woodmanList.get("A").GetLifeCount(), 3, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getX(), 1, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getY(), 1, 0.0);
	}
	
	@Test
	public void testFail_AddLife() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (2, 1));
		assertEquals(wood.move("A", Direction.Up), Action.Fail);
		assertEquals(wood.m_woodmanList.get("A").GetLifeCount(), 4, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getX(), 2, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getY(), 1, 0.0);
	}
	
	@Test
	public void testFail_Kill() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (2, 2));
		assertEquals(wood.move("A", Direction.Down), Action.Fail);
		assertEquals(wood.m_woodmanList.get("A").GetLifeCount(), 2, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getX(), 2, 0.0);
		assertEquals(wood.m_woodmanList.get("A").GetLocation().getY(), 2, 0.0);
	}
	
	@Test
	public void testFail_WoodmanNotFound() throws IOException {
		char[][] m_wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				m_wood[i][j] = '1';
			}
		m_wood[1][1] = m_wood[1][2] = '0';
		m_wood[2][1] = 'L';
		m_wood[2][2] = 'K';
		MyWood wood = new MyWood (m_wood, 4, 4);
		wood.createWoodman("A", new Point (2, 2));
		wood.move("A", Direction.Down);
		wood.move("A", Direction.Down);
		wood.move("A", Direction.Down);
		assertEquals(wood.move("A", Direction.Down), Action.WoodmanNotFound);
	}
}
