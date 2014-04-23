
import static org.junit.Assert.*;

import org.junit.Test;


public class testMyWoodman {

	@Test
	public void testGetLifeCount() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		assertEquals(3, man.GetLifeCount(), 0.0);
	}

	@Test
	public void testGetName() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		assertEquals("Lolo", man.GetName());
	}

	@Test
	public void testKillTrue() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		man.Kill();
		assertEquals (2, man.GetLifeCount(), 0.0);
	}
	
	@Test
	public void testKillFalse() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		man.Kill();
		man.Kill();
		man.Kill();
		assertEquals(man.Kill(), false);
	}

	@Test
	public void testAddLife() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		man.AddLife();
		assertEquals (4, man.GetLifeCount(), 0.0);
	}

	@Test
	public void testGetLocation() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		assertEquals (0, (man.GetLocation()).getX(), 0.0);
		assertEquals (0, (man.GetLocation()).getY(), 0.0);
	}

	@Test
	public void testSetLocation() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		Point location = new Point (1, 2);
		man.SetLocation(location);
		assertEquals (1, (man.GetLocation()).getX(), 0.0);
		assertEquals (2, (man.GetLocation()).getY(), 0.0);
	}

	@Test
	public void testMoveToStart() {
		Point start = new Point (0, 0);
		MyWoodman man = new MyWoodman ("Lolo", start);
		Point location = new Point (1, 2);
		man.SetLocation(location);
		man.MoveToStart();
		assertEquals (0, (man.GetLocation()).getX(), 0.0);
		assertEquals (0, (man.GetLocation()).getY(), 0.0);
	}

}
