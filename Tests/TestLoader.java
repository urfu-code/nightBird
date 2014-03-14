package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import wood01.RealWood;
import wood01.TheWood;
import wood01.TheWoodLoader;

public class TestLoader {

	@Test
	public void testLoad() throws Exception {
		String testString = "111\n101\n111\n";
		String test2Wood =  "111101111";
		ByteArrayInputStream testStream = new ByteArrayInputStream(testString.getBytes());
		TheWoodLoader testLoader = new TheWoodLoader();
		TheWood testWood = testLoader.Load(testStream);
		int k = 0;
		char[][] wood = new char[3][3];
		for (int i = 0; i < wood.length; i++) {
			for (int j = 0; j < wood[0].length; j++) {
				wood[i][j] = test2Wood.charAt(k);
				k++;
			}		
		}
		TheWood myTestWood = (TheWood) new RealWood(wood);
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
