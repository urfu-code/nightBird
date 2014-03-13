 package wood01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import wood01Interfaces.WoodLoader;

public class TheWoodLoader implements WoodLoader {

	@Override	
	public TheWood Load(InputStream stream) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String s;
		LinkedList<char[]>woodArrList = new LinkedList<char[]>();
		char[] woodStr;
		int x = 0;
		int y = 0;
		try {
			s = reader.readLine();
			y = s.length();
			while (s != null) {
				if (s.length() != y) {
					throw new IOException("непрямоугольный лес!");
				}
				woodStr = new char[y];
				for (int i = 0; i < y; i++) {
					woodStr[i] = s.charAt(i);
				}
				woodArrList.add(woodStr);
				s = reader.readLine();
				x++;
			}
			char[][] wood = new char[x][y];
			for (int i = 0; i < x; i++) {
				woodStr = woodArrList.removeFirst();
				for (int j = 0; j < y; j++) {
					wood[i][j] = woodStr[j];
				}
			}
			return new TheWood(wood);
		} catch (IOException e) {
			System.out.println("Ошибка ввода!");
		}
		finally {
			reader.close();
		}
		throw new IOException("данные не получены");
	}

}
