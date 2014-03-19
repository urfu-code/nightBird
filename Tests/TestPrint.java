package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

import wood01.Direction;
import wood01.Point;
import wood01.PrintableTheWood;
import wood01.TheWood;
import wood01.TheWoodLoader;

public class TestPrint {
	TheWoodLoader testLoader;
	PrintableTheWood testWood;
	ByteArrayInputStream testStream;
	ByteArrayOutputStream testOutputStream;
	String testString;
	String test2String;
	
	@Before
	public void setUp() throws Exception {
		testString =  "┌──┐\n│ ♥│\n│ѻ │\n└──┘";
		test2String = "┌──┐\n│K♥│\n│ѻ │\n└──┘\n------------\n♥ - live\nѻ - trap\n------------\nkolya (k) - 3 live(s)\n";
		testStream = new ByteArrayInputStream(testString.getBytes());
		testLoader = new TheWoodLoader();
		testWood  = (PrintableTheWood) testLoader.Load(testStream);
		testWood.createWoodman("kolya", new Point(1,1));
		testOutputStream = new ByteArrayOutputStream();
	}
	
	@Test
	public void testPrintWood() throws Exception {

		testWood.printWood(testOutputStream);
		//поглядеть как рисует(раскомментировать):
		//testWood.printWood(System.out);
		assertEquals(test2String, testOutputStream.toString());
	}
	
	@Test
	public void testPrintMove() throws Exception {
		String test3String = "┌──┐\n│ K│\n│ѻ │\n└──┘\n------------\n♥ - live\nѻ - trap\n------------\nkolya (k) - 4 live(s)\n";
		testWood.moveAndPrint("kolya", Direction.Right, testOutputStream);
		assertEquals(test3String, testOutputStream.toString());
		//поглядеть как бегает(раскомментировать):
		//testWood.moveAndPrint("kolya", Direction.Down, System.out);
	}
	
	@Test(expected = Exception.class)
	public void testUnrectWood() throws Exception {
		String testIncorrectString =  "┌──┐\n│ ♥│\n││\n└──┘";
		@SuppressWarnings("unused")
		TheWood testIncorrect = testLoader.Load(new ByteArrayInputStream(testIncorrectString.getBytes()));
	}
	
	@Test(expected = Exception.class)
	public void testIncorrectSquare() throws Exception {
		String testIncorrectWood = "┌──┐\n│ ♥│\n│I │\n└──┘";
		PrintableTheWood testIncorrect = testLoader.Load(new ByteArrayInputStream(testIncorrectWood.getBytes()));
		testIncorrect.createWoodman("kolya", new Point(1,1));
		testIncorrect.move("kolya", Direction.Down);
	}

}
