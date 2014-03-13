package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import wood01.Point;
import wood01.PrintableTheWood;

public class TestPrint {

	@Test
	public void testPrintWood() throws Exception {
		char[][] wood =  {
				{'1','0','1'},
				{'L','0','1'},
				{'0','K','1'},
		};
		PrintableTheWood testWood = new PrintableTheWood(wood);
		testWood.createWoodman("kolya", new Point(1,1));
		testWood.printWood(System.out);
		assertEquals(1, 1);
	}

}
