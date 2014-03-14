import java.io.InputStream;
import java.util.Scanner;


public class My_WoodLoader implements WoodLoader {

	@Override
	public My_Wood Load(InputStream stream) {
		int n = 0, m = 0;
		Scanner in = new Scanner(stream);
		String s = "";
		while(in.hasNextLine()){
			String test = in.nextLine();
			s += test;
			n = test.length();
			m++;		
		}
		//stream.close();
		char [][] wood = new char [n][m];
		int a=0, b=n, k=0;
		while (k < m){
			String work = s.substring(a, b);
			for(int i = 0; i < work.length(); i++){
				wood[i][k] = work.charAt(i);
			}
			k++;
			a=b;
			b += n;
		}
			My_Wood my_wood = new My_Wood(wood);
		return my_wood;
	}

}
