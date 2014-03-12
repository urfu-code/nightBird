import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyWoodLoader implements WoodLoader {

	private char[][] m_wood;
	

	public Wood Load(InputStream stream) throws IOException, CodeException {
		int n = 0;
		int m = 0;
		List<String> list = new LinkedList<String>();
		Scanner sc = new Scanner(stream);
		try {
			list.add(sc.nextLine());
			m = 1;
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
				m++;
			}
			n = list.get(0).length();
			m_wood = new char[m][n];
			for (int j = 0; j < m; j++) {
				if (list.get(j).length() != n)
					throw new CodeException("Input correct world");
			}
			for (int i = 0; i < m; i++) {
				m_wood[i] = list.get(i).toCharArray();
				
			}

		} finally {
			sc.close();
		}
		return new MyWood(m_wood);
	}
}
