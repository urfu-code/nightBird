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
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				wood[i][j] = '1';
			}
		wood[1][1] = wood[2][1] = '0';
		wood[1][2] = 'L';
		wood[2][2] = 'K';
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintableWood new_wood = new PrintableWood(wood, 4, 4, stream);
		String name = "Alala";
		new_wood.createWoodman(name, new Point (1, 1));
		byte[] n_wood = stream.toByteArray();
		char wall = '█';
		char free = ' ';
		char player = name.charAt(0);
		char kill = '▒';
		char life = '♥';
		assert (n_wood[0] == (byte) wall);
		assert (n_wood[1] == (byte) wall);
		assert (n_wood[2] == (byte) wall);
		assert (n_wood[3] == (byte) wall);
		assert (n_wood[4] == (byte) wall);
		assert (n_wood[5] == (byte) player);
		assert (n_wood[6] == (byte) life);
		assert (n_wood[7] == (byte) wall);
		assert (n_wood[8] == (byte) wall);
		assert (n_wood[9] == (byte) free);
		assert (n_wood[10] == (byte) kill);
		assert (n_wood[11] == (byte) wall);
		assert (n_wood[12] == (byte) wall);
		assert (n_wood[13] == (byte) wall);
		assert (n_wood[14] == (byte) wall);
		assert (n_wood[15] == (byte) wall);
	}
	
	@Test
	public void testMove() throws IOException {
		char[][] wood = new char [4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				wood[i][j] = '1';
			}
		wood[1][1] = wood[2][1] = '0';
		wood[1][2] = 'L';
		wood[2][2] = 'K';
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintableWood new_wood = new PrintableWood(wood, 4, 4, stream);
		String name = "Alala";
		new_wood.createWoodman(name, new Point (1, 1));
		new_wood.move(name, Direction.Down);
		byte[] n_wood = stream.toByteArray();
		char wall = '█';
		char free = ' ';
		char player = name.charAt(0);
		char kill = '▒';
		char life = '♥';
		assert (n_wood[0] == (byte) wall);
		assert (n_wood[1] == (byte) wall);
		assert (n_wood[2] == (byte) wall);
		assert (n_wood[3] == (byte) wall);
		assert (n_wood[4] == (byte) wall);
		assert (n_wood[5] == (byte) free);
		assert (n_wood[6] == (byte) life);
		assert (n_wood[7] == (byte) wall);
		assert (n_wood[8] == (byte) wall);
		assert (n_wood[9] == (byte) player);
		assert (n_wood[10] == (byte) kill);
		assert (n_wood[11] == (byte) wall);
		assert (n_wood[12] == (byte) wall);
		assert (n_wood[13] == (byte) wall);
		assert (n_wood[14] == (byte) wall);
		assert (n_wood[15] == (byte) wall);
	}
}
