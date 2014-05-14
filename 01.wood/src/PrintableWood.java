import java.io.IOException;
import java.io.OutputStream;

public class PrintableWood extends My_Wood {
	OutputStream out;
	
	public PrintableWood(char[][] My_Wood, OutputStream stream) {
		super(My_Wood);
		out = stream;
	}

	@Override
	public void createWoodman (String name, Point start, Point finish) {
		super.createWoodman(name, start, finish);
			try {
				print();
			} catch (IOException e) {
				e.printStackTrace();
			}
	} 
	
	@Override
	public Action move(String name, Direction direction) {
		Action action = super.move(name, direction);
		try {
			print();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return action;
	}
	
	public void print() throws IOException{
		char[][] newWood = new char[wood.length][wood[0].length];
		for(int i = 0; i < wood.length; i++){
			for(int j = 0; j < wood[0].length; j++){
				switch(wood[i][j]){
				case '1': {
					newWood[i][j] = '∆';
					break;
				}
				case '0': {
					newWood[i][j] = ' ';
					break;
				}
				case 'K': {
					newWood[i][j] = '×';
					break;
				}
				case 'L': {
					newWood[i][j] = '♥';
					break;
				}
			}
			}
		}
		char[] string = new char[newWood[0].length];
			for (int i = 0; i < newWood.length; i++) {
				for (int j = 0; j < newWood[0].length; j++) {
					string[j] = newWood[i][j];
				  	Point currentPoint = new Point(j,i);
				  	for (My_Woodman k:(super.WoodmanList).values()) {
				  			if (k.GetLocation().equals(currentPoint)) {
				 				string[j] = k.GetName().charAt(0);
				  			}
				  		}
				}	
			}
			String str = new String(string);
			out.write((str + "\n").getBytes());
			out.write(("♥" + " - life\n").getBytes());
			out.write(("×" + " - dead\n").getBytes());
			for (My_Woodman i:(super.WoodmanList).values()) {
				out.write((i.GetName().charAt(0) + 
						" - " + i.GetName() + 
						"  (" + i.GetLifeCount() + 
						" - жизни)\n").getBytes());
		  	}
		}
}

