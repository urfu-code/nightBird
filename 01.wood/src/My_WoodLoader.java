import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class My_WoodLoader implements WoodLoader{


	@Override
	public My_Wood Load(InputStream stream) {
		char[][]wood = read(stream);
		return new My_Wood(wood);
	}
	
	public PrintableWood Load(InputStream in_stream, OutputStream out_stream){
		char[][]wood = read(in_stream);
		return new PrintableWood(wood, out_stream);
	}
		
	public char[][] read(InputStream stream){
		int n = 0, m = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(stream);
		String My_wood = "";
		while(scanner.hasNextLine()){
			String my_wood1 = scanner.nextLine();
			My_wood += my_wood1;
			m = my_wood1.length();
			n++;
		}
		char [][] wood = new char [n][m];
		int a=0, b=m, k=0;
		while (k < n){
			String p = My_wood.substring(a, b);
			for(int i = 0; i < p.length(); i++){
				wood[k][i] = p.charAt(i);
			}
			k++;
			a=b;
			b += m;
		}
		return wood;
	}
}