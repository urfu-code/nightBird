package test;
import static org.junit.Assert.*;

import org.junit.Test;

import wood.My_Woodman;
import wood.Point;

public class WoodmanTest {

	@Test
	public void testGetLifeCount() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		assertEquals(3, one.GetLifeCount());
	}

	@Test
	public void testGetName() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		assertEquals("A", one.GetName());
	}

	@Test
	public void testKill() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		assertEquals(3, one.GetLifeCount());
		assertEquals(true, one.Kill());
		assertEquals(2, one.GetLifeCount());
	}

	@Test
	public void testKill2() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		assertEquals(true, one.Kill());
		assertEquals(true, one.Kill());
		assertEquals(true, one.Kill());
		assertEquals(false, one.Kill());
	}
	
	@Test
	public void testAddLife() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		assertEquals(3, one.GetLifeCount());
		one.AddLife();
		assertEquals(4, one.GetLifeCount());
	}

	@Test
	public void testGetLocation() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		equals(new Point(0, 0) == one.GetLocation());
	}

	@Test
	public void testSetLocation() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 2);
		My_Woodman one = new My_Woodman("A", myS, myF);
		Point location = new Point(1, 1);
		assertEquals(myS, one.GetLocation());
		one.SetLocation(location);
		assertEquals(location, one.GetLocation());
	}

	@Test
	public void testMoveToStart() {
		Point myS = new Point(0, 0);
		Point myF = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", myS, myF);
		one.SetLocation(new Point(1, 2));
		one.MoveToStart();
		assertEquals(myS, one.GetLocation());
	}

}
