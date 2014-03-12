import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class WoodLoaderTest {
	WoodLoader wl = new WoodLoader();

	@Test
	public void testLoad() throws IOException {
		File file = new File("c://Users//пк//workspace//NightBird//src//input.txt");
		try {
			FileInputStream iStream = new FileInputStream(file);
			try {
				IWood ofChristmasTrees = wl.Load(iStream);
				for (int i = 0; i < 9; i++) {
					assertEquals((Character) '1', ofChristmasTrees.getChar(new Point(i, 0)));
					assertEquals((Character) '1', ofChristmasTrees.getChar(new Point(i, 7)));
				}
				for (int i = 0; i < 8; i++) {
					assertEquals((Character) '1', ofChristmasTrees.getChar(new Point(0, i)));
					assertEquals((Character) '1', ofChristmasTrees.getChar(new Point(8, i)));
				}
				assertEquals((Character) '1', ofChristmasTrees.getChar(new Point(4, 7)));
				assertEquals((Character) '0', ofChristmasTrees.getChar(new Point(2, 1)));
				assertEquals((Character) 'K', ofChristmasTrees.getChar(new Point(7, 1)));
				assertEquals((Character) 'L', ofChristmasTrees.getChar(new Point(7, 6)));
			}
			finally {
				iStream.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}

}
