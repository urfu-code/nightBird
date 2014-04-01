package test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import wood.Action;
import wood.Direction;
import wood.My_WoodLoader;
import wood.Point;
import wood.PrintWood;

public class PrintWoodTest {

	private My_WoodLoader loader;
	private String string;
	private ByteArrayInputStream inStream;
	private PrintWood myWood;
	private ByteArrayOutputStream outStream;
	
	@Before
	public void myWood() throws FileNotFoundException{
		loader = new My_WoodLoader();
		string = "111111\n"
			   + "10L001\n"
			   + "1K10L1\n"
			   + "111111\n";
		outStream = new ByteArrayOutputStream();
		inStream = new ByteArrayInputStream(string.getBytes());
		myWood =  loader.Load(inStream, outStream);
	}
	@Test
	public void testPrintWood() throws IOException {
		myWood.createWoodman("Ann", new Point(1,1), new Point(3,2));	
		String outString =  "┌────┐\n"
						  + "│A♥  │\n"
						  + "│#│ ♥│\n"
						  + "└─┴──┘\n\n"
						  + "♥ - жизнь\n"
						  + "# - капкан\n"
						  + "A - Ann  (3 - жизни)\n";
		assertEquals(outString, outStream.toString());
		assertEquals(Action.Life, myWood.move("Ann", Direction.Right));
		String outString2 = "┌────┐\n"
						  + "│ A  │\n"
				          + "│#│ ♥│\n"
				          + "└─┴──┘\n\n"
				          + "♥ - жизнь\n"
				          + "# - капкан\n"
				          + "A - Ann  (4 - жизни)\n";
		assertEquals(Action.Ok, myWood.move("Ann", Direction.Right));
		String outString3 = "┌────┐\n"
						  + "│ ♥A │\n"
						  + "│#│ ♥│\n"
						  + "└─┴──┘\n\n"
						  + "♥ - жизнь\n"
						  + "# - капкан\n"
						  + "A - Ann  (4 - жизни)\n";
		assertEquals(outString + outString2 + outString3, outStream.toString());
		String outString4 = "┌────┐\n"
						  + "│ ♥A │\n"
						  + "│B│ ♥│\n"
						  + "└─┴──┘\n\n"
						  + "♥ - жизнь\n"
						  + "# - капкан\n"
						  + "B - Ben  (3 - жизни)\n"
						  + "A - Ann  (4 - жизни)\n";
		myWood.createWoodman("Ben", new Point(1,2), new Point(3,2));
		assertEquals(outString + outString2 + outString3 + outString4, outStream.toString());
	}

}
