import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;


public class MyWoodLoader implements WoodLoader {
	@SuppressWarnings("resource")
	public MyWood Load(InputStream stream) throws IOException {
		Scanner sc = new Scanner (stream);
		Vector <String> vec = new Vector <String>();
		while (sc.hasNextLine()) {
			vec.add(sc.nextLine());
		}
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).length() != vec.get(0).length()) {
				throw new IOException ("Labyrinth is not rectangular");
			}
		}
		char[][] wood = new char[vec.firstElement().length()][vec.size()];
		for (int j = 0; j < vec.size(); j++) {
			for (int i = 0; i < vec.firstElement().length(); i++) {
				wood[i][j] = vec.elementAt(j).charAt(i);
			}
		}
		sc.close();
		return new MyWood(wood, vec.firstElement().length(), vec.size());
	}

}
