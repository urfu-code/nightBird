import static org.junit.Assert.*;

import org.junit.Test;


public class My_WoodmanTest {

	@Test
	public void testGetLifeCount() {
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		assertEquals(3, my_man.GetLifeCount());
	}

	@Test
	public void testGetName() {
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		assertTrue(my_man.GetName()=="A");
	}
	
	@Test
	public void testKill(){
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		my_man.Kill();
		assertEquals(2, my_man.GetLifeCount());
	}
	
	@Test
	public void testKill1(){
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		my_man.Kill();
		my_man.Kill(); 
		my_man.Kill();
		assertEquals(false, my_man.Kill());
	}
	
	
	@Test
	public void testAddLife() {
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		my_man.AddLife();
		assertEquals(4, my_man.GetLifeCount());
	}
	
	@Test
	public void testGetLocation() {
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		assertEquals(my, my_man.GetLocation());
	}
	
	@Test
	public void testSetLocation() {
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		my_man.SetLocation(my);
		assertEquals(my, my_man.GetLocation());
	}
			
	@Test
	public void testMoveToStart() {
		Point my = new Point (0,0);
		Point mu = new Point (1,1);
		My_Woodman my_man = new My_Woodman("A", my, mu);
		my_man.SetLocation(new Point(1,1));
		my_man.MoveToStart();
		assertEquals(my, my_man.GetLocation());
	}
}
