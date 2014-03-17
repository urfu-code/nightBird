import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class WoodTest {
	WoodLoader wl = new WoodLoader();
	Point testPoint = new Point(1, 1);

	@Test
	public void testCreateWoodman() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Zelda", testPoint);
				assertEquals(new Woodman("Zelda", new Point(1, 1)), hyrule.getWoodman("Zelda"));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = WoodmanExistsException.class)
	public void testCreateDuplicateWoodman() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Zelda", testPoint);
				hyrule.createWoodman("Zelda", new Point(4, 1));
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMoveOk() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Epona", testPoint);

				assertEquals(Action.Ok, hyrule.move("Epona", Direction.Right));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMoveFail() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Epona", testPoint);

				assertEquals(Action.Fail, hyrule.move("Epona", Direction.Left));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMoveDead() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Dodongo", new Point(7, 2));

				assertEquals(Action.Dead, hyrule.move("Dodongo", Direction.Up));

			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMoveLife() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Link", new Point(7, 5));

				assertEquals(Action.Life, hyrule.move("Link", Direction.Down));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = WoodmanOnTheWallException.class)
	public void testWrongStart() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Epona", new Point(0, 0));
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testWrongName() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Great Deku Tree", testPoint);
				assertEquals(Action.WoodmanNotFound, hyrule.move("Epona", Direction.Right));
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testFatality() throws IOException {
		File file = new File("src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				Wood hyrule = wl.Load(stream);
				hyrule.createWoodman("Dodongo", new Point(7, 2));
				for (int i = 0; i < 4; i++) {
					hyrule.move("Dodongo", Direction.Up);
					hyrule.move("Dodongo", Direction.Down);
				}
				assertEquals(Action.WoodmanNotFound, hyrule.move("Dodongo", Direction.Up));
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

}
