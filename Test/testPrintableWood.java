import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;




public class testPrintableWood {

	@Test
	public void testCreateWoodman() throws IOException {
		char[][] wood = new char [4][4];
		for (int j = 0; j < 4; j++)
			for (int i = 0; i < 4; i++) {
				wood[i][j] = '1';
			}
		wood[1][1] = wood[1][2] = '0';
		wood[2][1] = 'L';
		wood[2][2] = 'K';
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintableWood new_wood = new PrintableWood(wood, 4, 4, stream);
		String name = "Alala";
		new_wood.createWoodman(name, new Point (1, 1));
		byte[] n_wood = stream.toByteArray();
		InputStream stream1 = new ByteArrayInputStream(n_wood);
		InputStreamReader stream2 = new InputStreamReader(stream1, System.getProperty("file.encoding"));
		String str = "";
		Scanner sc = new Scanner(stream2);
		while (sc.hasNextLine()) {
			str = str + sc.nextLine();
		}
		String a = "█████A♥██ ▒█████A - Alala (3 lives)♥ - life▒ - kill";
		assertEquals (str, a);
	}
	
	@Test
	public void testMove() throws IOException {
		char[][] wood = new char [4][4];
		for (int j = 0; j < 4; j++)
			for (int i = 0; i < 4; i++) {
				wood[i][j] = '1';
			}
		wood[1][1] = wood[1][2] = '0';
		wood[2][1] = 'L';
		wood[2][2] = 'K';
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintableWood new_wood = new PrintableWood(wood, 4, 4, stream);
		String name = "Alala";
		new_wood.createWoodman(name, new Point (1, 1));
		new_wood.move("Alala", Direction.Down);
		byte[] n_wood = stream.toByteArray();
		InputStream stream1 = new ByteArrayInputStream(n_wood);
		InputStreamReader stream2 = new InputStreamReader(stream1, System.getProperty("file.encoding"));
		String str = "";
		Scanner sc = new Scanner(stream2);
		while (sc.hasNextLine()) {
			str = str + sc.nextLine();
		}
		String a = "█████A♥██ ▒█████A - Alala (3 lives)♥ - life▒ - kill█████ ♥██A▒█████A - Alala (3 lives)♥ - life▒ - kill";
		assertEquals (str, a);
	}
}
