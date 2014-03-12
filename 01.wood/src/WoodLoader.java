import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class WoodLoader implements IWoodLoader {

	@Override
	public IWood Load(FileInputStream stream) {
		HashMap<Point, Character> lab = new HashMap<Point, Character>();
		int length = 0;
		int width = 0;
		try {
			try {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(stream, "utf8");
				String labLine = "";
				int numberOfLine = 0; // координата y, за x будет i
				int i = 0;
				
				while (sc.hasNext()) {
					labLine = sc.nextLine();
					for (i = 0; i < labLine.length(); i++) {
						Character tempChar = labLine.charAt(i);
						lab.put(new Point(i, numberOfLine), tempChar);
					}
					numberOfLine++; 					
				}
				length = labLine.length();
				width = numberOfLine; 
				
			}
			finally {
				stream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Wood ofOaks = new Wood(lab, length, width);
		return ofOaks;
	}

}
