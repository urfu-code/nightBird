import static org.junit.Assert.*;

import org.junit.Test;


public class MyWoodmanTests {

	@Test
	public void testGetLifeCount() {
		MyWoodman A=new MyWoodman("A", new Point(0,0));
		assertTrue (A.GetLifeCount() == 3);
	}

	@Test
	public void testGetName() {
		MyWoodman A=new MyWoodman("A", new Point(0,0));
		assertTrue (A.GetName() == "B");
	}

	@Test
	public void testKill1() {
		MyWoodman A=new MyWoodman("A", new Point(0,0));
		assertTrue (A.GetLifeCount() == 3);
		assertTrue (A.Kill() == true);
		assertTrue (A.GetLifeCount() == 2);
	}

	@Test
	public void testKill2() {
		MyWoodman A=new MyWoodman("A", new Point(0,0));
		assertTrue (A.GetLifeCount() == 3);
		assertTrue (A.Kill() == true);
		assertTrue (A.GetLifeCount() == 2);
		assertTrue (A.Kill() == true);
		assertTrue (A.GetLifeCount() == 1);
		assertTrue (A.Kill() == true);
		assertTrue (A.GetLifeCount() == 0);
		assertTrue (A.Kill() == false);
	}

	@Test
	public void testAddLife() {
		MyWoodman A=new MyWoodman("A", new Point(0,0));
		assertTrue (A.GetLifeCount() == 3);
		A.AddLife();
		assertTrue (A.GetLifeCount() == 4);
	}

	@Test
	public void testGetLocation() {
		Point k=new Point(0,0);
		MyWoodman A=new MyWoodman("A", k);
		assertTrue (A.GetLocation() == k);

	}

	@Test
	public void testSetLocation() {
		Point k=new Point(0,0);
		MyWoodman A=new MyWoodman("A", k);
		assertTrue (A.GetLocation() == k);
		Point n=new Point(1,0);
		A.SetLocation(n);
		assertTrue (A.GetLocation() == n);
	}

	@Test
	public void testMoveToStart() {
		Point k=new Point(0,0);
		MyWoodman A=new MyWoodman("A", k);
		Point n=new Point(0,0);
		A.SetLocation(n);
		A.MoveToStart();
		assertTrue (A.GetLocation() == k);
	}

}
