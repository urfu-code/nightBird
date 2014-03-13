package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

import wood01.TheWood;
import wood01.TheWoodLoader;

public class TestLoader {

	@Test
	public void testLoad() throws IOException {
		String testString = "111111111\n1000001K1\n111110101\n100010101\n101000101\n101111101\n1000000L1\n111111111";
		String test2Wood =  "1111111111000001K11111101011000101011010001011011111011000000L1111111111";
		ByteArrayInputStream testStream = new ByteArrayInputStream(testString.getBytes());
		TheWoodLoader testLoader = new TheWoodLoader();
		TheWood testWood = testLoader.Load(testStream);
		int k = 0;
		char[][] wood = new char[8][9];
		for (int i = 0; i < wood.length; i++) {
			for (int j = 0; j < wood[0].length; j++) {
				wood[i][j] = test2Wood.charAt(k);
				k++;
			}		
		}
		TheWood myTestWood = new TheWood(wood);
		assertEquals(true, testWood.equalsOfWoods(myTestWood));
	}
	
	@Test(expected = Exception.class)
	public void testExcpLoad() throws Exception {
		String exceptionWood = "111\n0000\n111\n111";
		TheWoodLoader testLoader = new TheWoodLoader();
		ByteArrayInputStream testStream_2 = new ByteArrayInputStream(exceptionWood.getBytes());
		@SuppressWarnings("unused")
		TheWood testWood_2 = testLoader.Load(testStream_2);
	}
	
	
}
