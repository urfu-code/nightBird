import java.io.InputStream;
import java.util.Scanner;


public class My_WoodLoader implements WoodLoader {

	@Override
	public My_Wood Load(InputStream stream) {
		char [][] wood = new char [50][50];
		int n = 0, m = 0;
		Scanner in = new Scanner(stream);
		while(in.hasNextLine()){
			String s = in.nextLine();
			n = s.length();
			for(int i = 0; i < s.length(); i++){
				wood[i][m] = s.charAt(i);
			}
			m++;	
		}
		//stream.close();
			My_Wood my_wood = new My_Wood(wood);
		return my_wood;
	}

}
