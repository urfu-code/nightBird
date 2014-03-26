import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;


public class MyWoodLoader implements WoodLoader {
	public MyWood Load(InputStream stream) {
		Scanner sc = new Scanner (stream);
		Vector <String> vec = new Vector <String>();
		while (sc.hasNextLine()) {
			vec.add(sc.nextLine());
		}
		char[][] wood = new char[vec.size()][vec.firstElement().length()];
		for (int i = 0; i < vec.size(); i++)
			for (int j = 0; j < vec.firstElement().length(); j++) {
				wood[i][j] = vec.elementAt(i).charAt(j);
			}
		sc.close();
		return new MyWood(wood, vec.size(), vec.firstElement().length());
	}

}
