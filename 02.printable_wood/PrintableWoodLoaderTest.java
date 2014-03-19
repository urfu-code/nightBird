import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class PrintableWoodLoaderTest {
	PrintableWoodLoader pwl = new PrintableWoodLoader();

	@Test
	public void testLoad() throws IOException {
		File file = new File("src/input4x4.txt");
		
		try {
			FileInputStream iStream = new FileInputStream(file);
			try {
				Wood ofChristmasTrees = pwl.Load(iStream);
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(0, 0)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(1, 0)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(2, 0)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(3, 0)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(0, 3)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(1, 3)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(2, 3)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(3, 3)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(0, 1)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(0, 2)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(0, 3)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(3, 0)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(3, 1)));
				assertEquals((Character) '◘', ofChristmasTrees.getChar(new Point(3, 2)));
				
				assertEquals((Character) ' ', ofChristmasTrees.getChar(new Point(1, 1)));
				assertEquals((Character) ' ', ofChristmasTrees.getChar(new Point(2, 2)));

				assertEquals((Character) '‡', ofChristmasTrees.getChar(new Point(2, 1)));
				assertEquals((Character) '♥', ofChristmasTrees.getChar(new Point(1, 2)));
			}
			finally {
				iStream.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
