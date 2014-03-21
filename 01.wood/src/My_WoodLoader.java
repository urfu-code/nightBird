import java.io.InputStream;
import java.util.Scanner;


public class My_WoodLoader implements WoodLoader {

	@Override
	//public My_Wood Load(InputStream stream) {
	public additionalWood Load(InputStream stream) {
		int n = 0, m = 0;
		Scanner in = new Scanner(stream);
		String s = "";
		while(in.hasNextLine()){
			String test = in.nextLine();
			s += test;
			m = test.length();
			n++;		
		}
		//stream.close();
		char [][] wood = new char [n][m];
		int a=0, b=m, k=0;
		while (k < n){
			String work = s.substring(a, b);
			for(int i = 0; i < work.length(); i++){
				wood[k][i] = work.charAt(i);
			}
			k++;
			a=b;
			b += m;
		}
		/*for(int i=0; i < n; i++){
			for(int j=0; j <m ; j++){
				System.out.print(wood[i][j]);
			}
			System.out.println();
		}*/
			//My_Wood my_wood = new My_Wood(wood);
		//return my_wood;
		return new additionalWood(wood);
	}

}
