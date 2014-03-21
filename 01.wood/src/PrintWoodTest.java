import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;


public class PrintWoodTest {

	String outString;
	String outString2;
	String outString3;
	String outString4;
	String outString5;
	My_WoodLoader loader;
	PrintWood wood;
	ByteArrayOutputStream outStream;
	
	@Before
	public void myWood() throws FileNotFoundException{
		File file = new File("wood1.txt");
		InputStream stream = new FileInputStream(file);
		outString = "┌──┬─┐\n│ ♥│ │\n│#│  │\n└─┴──┘\n\n♥ - жизнь\n# - капкан\n";
		outString2 = "┌──┬─┐\n│A♥│ │\n│#│  │\n└─┴──┘\n\n♥ - жизнь\n# - капкан\nA - Ann  (3 - жизни)\n";
		outString3 = "┌──┬─┐\n│ A│ │\n│#│  │\n└─┴──┘\n\n♥ - жизнь\n# - капкан\nA - Ann  (4 - жизни)\n";
		outString4 = "┌──┬─┐\n│ ♥│ │\n│A│  │\n└─┴──┘\n\n♥ - жизнь\n# - капкан\nA - Ann  (2 - жизни)\n";
		outString5 = "┌──┬─┐\n│B♥│ │\n│A│  │\n└─┴──┘\n\n♥ - жизнь\n# - капкан\nB - Ben  (3 - жизни)\nA - Ann  (2 - жизни)\n";
		loader = new My_WoodLoader();
		wood  = (PrintWood)loader.Load(stream);
		outStream = new ByteArrayOutputStream();
	}
	
	@Test
	public void testPrintWood() throws IOException {
		wood.printWood(System.out);	
	}
	
	@Test
	public void testPrintWood1() throws IOException {
		wood.printWood(outStream);
		assertEquals(outString, outStream.toString());
		
	}
	
	@Test
	public void testPrintWood2() throws IOException {
		wood.createWoodman("Ann", new Point(1,1));
		wood.printWood(outStream);
		wood.printWood(System.out);	
		assertEquals(outString2, outStream.toString());
		
	}
	
	@Test
	public void testPrintWood3() throws IOException {
		wood.createWoodman("Ann", new Point(1,1));
		assertEquals(Action.Life, wood.move("Ann", Direction.Right));
		wood.printWood(outStream);
		wood.printWood(System.out);	
		assertEquals(outString3, outStream.toString());
	}
	
	@Test
	public void testPrintWood4() throws IOException {
		wood.createWoodman("Ann", new Point(1,1));
		assertEquals(Action.Dead, wood.move("Ann", Direction.Down));
		wood.printWood(outStream);
		wood.printWood(System.out);	
		assertEquals(outString4, outStream.toString());
	}
	
	@Test
	public void testPrintWood5() throws IOException {
		wood.createWoodman("Ann", new Point(1,1));
		wood.createWoodman("Ben", new Point(1,1));
		assertEquals(Action.Dead, wood.move("Ann", Direction.Down));
		wood.printWood(outStream);
		wood.printWood(System.out);	
		assertEquals(outString5, outStream.toString());
	}
}
