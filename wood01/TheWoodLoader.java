 package wood01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import wood01Interfaces.WoodLoader;

public class TheWoodLoader implements WoodLoader {

	@Override	
	public RealWood Load(InputStream stream) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String s;
		LinkedList<String>woodArrList = new LinkedList<String>();
		int x = 0;
		int y = 0;
		try {
			s = reader.readLine();
			y = s.length();
			while (s != null) {
				if (s.length() != y) {
					throw new IOException("непрямоугольный лес!");
				}
				woodArrList.add(s);
				s = reader.readLine();
				x++;
			}
			char[][] wood = new char[x][y];
			for (int i = 0; i < x; i++) {
				s = woodArrList.removeFirst();
				for (int j = 0; j < y; j++) {
					wood[i][j] = s.charAt(j);
				}
			}
			return new RealWood(wood);
		} catch (IOException e) {
			System.out.println("с лесом беда...");
		}
		finally {
			reader.close();
		}
		throw new IOException("данные не получены");
	}

}
