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
	public void testGetChar() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				assertEquals((Character) '0', hyrule.getChar(testPoint));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetWoodman() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Link", testPoint);
				assertEquals(new Woodman("Link", new Point(1, 1)),
						hyrule.getWoodman("Link"));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateWoodman() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Zelda", testPoint);
				assertEquals(new Woodman("Zelda", new Point(1, 1)),
						hyrule.getWoodman("Zelda")); // не знаю, как можно по-другому проверить
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = RuntimeException.class)
	public void testCreateDuplicateWoodman() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
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
	public void testResult() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Great Deku Tree", testPoint);
				hyrule.createWoodman("Dodongo", new Point(7, 1));
				hyrule.createWoodman("Link", new Point(7, 6));
				hyrule.createWoodman("Epona", new Point(0, 0));
				assertEquals(Action.Ok, hyrule.result(hyrule.getChar(hyrule.getWoodman("Great Deku Tree").GetLocation()), "Great Deku Tree"));
				
				assertEquals(Action.Dead, hyrule.result(hyrule.getChar(hyrule.getWoodman("Dodongo").GetLocation()), "Dodongo"));
				assertEquals(2, hyrule.getWoodman("Dodongo").GetLifeCount());
				
				assertEquals(Action.Life, hyrule.result(hyrule.getChar(hyrule.getWoodman("Link").GetLocation()), "Link"));
				assertEquals(4, hyrule.getWoodman("Link").GetLifeCount());
				
				assertEquals(Action.Fail, hyrule.result(hyrule.getChar(hyrule.getWoodman("Epona").GetLocation()), "Epona"));
			} 	finally {
				stream.close();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMove() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Epona", testPoint);
				hyrule.createWoodman("Dodongo", new Point(7, 5));
				hyrule.createWoodman("Link", new Point(7, 5));

				assertEquals(Action.Fail, hyrule.move("Epona", Direction.Left));
				assertEquals(Action.Ok, hyrule.move("Epona", Direction.Right));

				for (int i = 0; i < 3; i++) {
					assertEquals(Action.Ok, hyrule.move("Dodongo", Direction.Up));
				}
				assertEquals(Action.Dead, hyrule.move("Dodongo", Direction.Up));
				assertEquals(new Point(7, 5), hyrule.getWoodman("Dodongo").GetLocation());

				assertEquals(Action.Life, hyrule.move("Link", Direction.Down));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = RuntimeException.class)
	public void testWrongMove() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Epona", new Point(0, 0));
				assertEquals(Action.Fail, hyrule.move("Epona", Direction.Left));
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

	@Test(expected = WoodmanNotFound.class)
	public void testWrongName() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Great Deku Tree", testPoint);
				assertEquals(Action.Ok, hyrule.move("Epona", Direction.Right));
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	@Test(expected = WoodmanNotFound.class)
	public void testFatality() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				IWood hyrule = wl.Load(stream);
				hyrule.createWoodman("Dodongo", new Point(7, 2));
				for (int i = 0; i < 5; i++) {
					hyrule.move("Dodongo", Direction.Up);
				}
			} finally {
				stream.close();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

}
