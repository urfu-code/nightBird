import static org.junit.Assert.*;

//import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class PrintableWoodTest {
	PrintableWoodLoader wl = new PrintableWoodLoader();
	Point testPoint = new Point(2, 2);

	@Test
	public void testCreateWoodman() throws IOException {
		File file = new File("src/input4x4.txt");	
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				PrintableWood underground = wl.Load(stream);
				underground.createWoodman("Jareth", testPoint);
				assertEquals((Character) '☺', underground.labyrinthOfSymbols.get(testPoint));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMove() throws IOException {
		File file = new File("src/input6x5.txt");	
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				PrintableWood underground = wl.Load(stream);
				underground.createWoodman("Bowie", new Point(1, 1));
				underground.move("Bowie", Direction.Right);
				underground.createWoodman("Sarah", new Point(1, 1));
				underground.move("Sarah", Direction.Right);
				underground.move("Sarah", Direction.Right); // убеждаемся, что изображение другого вудмена не потеряно 
				assertEquals((Character) '☻', underground.labyrinthOfSymbols.get(new Point(3, 1)));
				assertEquals((Character) '☺', underground.labyrinthOfSymbols.get(new Point(2, 1)));
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMoveLife() throws IOException {
		File file = new File("src/input4x4.txt");	
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				PrintableWood underground = wl.Load(stream);
				underground.createWoodman("Bowie", testPoint);
				underground.move("Bowie", Direction.Left);
				assertEquals(4, underground.getWoodman("Bowie").GetLifeCount());
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = NotEnoughSymbolsException.class)
	public void testTooMuchWoodmen() throws IOException {
		File file = new File("src/input6x5.txt");	
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				PrintableWood underground = wl.Load(stream);
				String name = "Fairy";
				for (int i = 1; i < 5; i++) {
					name = name + "I";
					underground.createWoodman(name, new Point(i, 1));
					name = name + "I";
					underground.createWoodman(name, new Point(i, 3));
				}
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTooMuchWoodmenGottaKillThem() throws IOException { // проверка, что если убить одного из вудменов, когда заняты все картинки, картинка убитого освободится
		File file = new File("src/input6x5.txt");	
		try {
			FileInputStream stream = new FileInputStream(file);
			try {
				PrintableWood underground = wl.Load(stream);
				String name = "Chicken";
				for (int i = 1; i < 5; i++) {
					name = name + "I";
					underground.createWoodman(name, new Point(i, 1));
				}
				for (int j = 2; j < 5; j++) {
					name = name + "I";
					underground.createWoodman(name, new Point(j, 3));
				}
				underground.move("ChickenIII", Direction.Down);
				underground.move("ChickenIII", Direction.None);
				underground.move("ChickenIII", Direction.None);
				underground.move("ChickenIII", Direction.None);
				
				underground.createWoodman("Chicken", testPoint);
			} finally {
				stream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
