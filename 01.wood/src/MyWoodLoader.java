import java.io.InputStream;
import java.util.Scanner;


public class MyWoodLoader implements WoodLoader {
	public MyWood Load(InputStream stream) {
		Scanner sc = new Scanner (stream);
		String data = "";
		while (sc.hasNextLine()) {
			data += sc.nextLine();
			data += System.lineSeparator();
		}
		String[] d = data.split(System.lineSeparator());
		char[][] wood = new char[d.length][d[0].length()];
		for (int i = 0; i < d.length; i++)
			for (int j = 0; j < d[0].length(); j++) {
				wood[i][j] = d[i].charAt(j);
			}
		return new MyWood (wood);
	}

}
