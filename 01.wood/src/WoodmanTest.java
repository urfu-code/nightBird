import static org.junit.Assert.*;

import org.junit.Test;


public class WoodmanTest {
	Woodman testman = new Woodman("Testman", new Point (0, 0));

	@Test
	public void testGetLifeCount() {
		assertEquals(3, testman.GetLifeCount());
	}

	@Test
	public void testGetName() {
		assertEquals("Testman", testman.GetName());
	}

	@Test
	public void testKill() {
		assertEquals(3, testman.GetLifeCount());
		if (testman.Kill())
			assertEquals(2, testman.GetLifeCount());
	}
	
	@Test
	public void testFatality() {
		assertEquals(3, testman.GetLifeCount());
		for (int i = 2; i > -1; i--) {
			if (testman.Kill())
				assertEquals(i, testman.GetLifeCount());
			else 
				assertEquals(-1, testman.GetLifeCount());
		}
	}

	@Test
	public void testAddLife() {
		assertEquals(3, testman.GetLifeCount());
		testman.AddLife();
		assertEquals(4, testman.GetLifeCount());
	}

	@Test
	public void testGetLocation() {
		assertEquals(new Point (0, 0), testman.GetLocation());
	}

	@Test
	public void testSetLocation() {
		assertEquals(new Point (0, 0), testman.GetLocation());
		testman.SetLocation(new Point(1, 6));
		assertEquals(new Point (1, 6), testman.GetLocation());
	}

	@Test
	public void testMoveToStart() {
		testman.SetLocation(new Point(1, 6));
		testman.MoveToStart();
		assertEquals(new Point (0, 0), testman.GetLocation());
	}

}
