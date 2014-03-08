import static org.junit.Assert.*;

import org.junit.Test;

public class WoodmanTest {

	@Test
	public void testGetLifeCount() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals(3, one.GetLifeCount());
	}

	@Test
	public void testGetName() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals("A", one.GetName());
	}

	@Test
	public void testKill() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals(3, one.GetLifeCount());
		assertEquals(true, one.Kill());
		assertEquals(2, one.GetLifeCount());
	}

	@Test
	public void testKill2() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals(true, one.Kill());
		assertEquals(true, one.Kill());
		assertEquals(true, one.Kill());
		assertEquals(false, one.Kill());
	}
	
	@Test
	public void testAddLife() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals(3, one.GetLifeCount());
		one.AddLife();
		assertEquals(4, one.GetLifeCount());
	}

	@Test
	public void testGetLocation() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals(my, one.GetLocation());
	}

	@Test
	public void testSetLocation() {
		Point my = new Point(0, 0);
		Point location = new Point(1, 1);
		My_Woodman one = new My_Woodman("A", my);
		assertEquals(my, one.GetLocation());
		one.SetLocation(location);
		assertEquals(location, one.GetLocation());
	}

	@Test
	public void testMoveToStart() {
		Point my = new Point(0, 0);
		My_Woodman one = new My_Woodman("A", my);
		one.SetLocation(new Point(1, 1));
		one.MoveToStart();
		assertEquals(my, one.GetLocation());
	}

}
