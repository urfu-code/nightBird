
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

public class PrintableWood extends MyWood {

	List<StringBuilder> printList = new LinkedList<StringBuilder>(); 
	private OutputStreamWriter ostream;
	int wl = m_wood.length;  
	int ww = m_wood[0].length;   

	public PrintableWood(char[][] wood,OutputStream stream) throws UnsupportedEncodingException {
		super(wood);
		ostream = new OutputStreamWriter(stream);
	for(int i = 0; i < wl; i++) { 	
		StringBuilder s = new StringBuilder(); 
		for(int j = 0; j < ww; j++) { 	                    
				char woodChar = wood[i][j];	               
				if (woodChar == '0') 
					s.append('○');				
				if (woodChar == '1') 
					s.append('✿');				
				if (woodChar == 'K')
					s.append('✖');							
				if (woodChar == 'L')
					s.append('♥');	}
				printList.add(s);
			}	
		
		printList.add(new StringBuilder());    
		printList.add(new StringBuilder('♥' + " - life")); 
		printList.add(new StringBuilder('✖' + " - death"));   
	}

	@Override
	public void createWoodman(String name, Point start) throws CodeException, IOException{
		super.createWoodman(name, start);
	}

	@Override
	public Action move(String name, Direction direction) throws IOException {
		Action result=super.move(name, direction);
		PrintWood();
		return result;
	}
	
	public void PrintWood() throws IOException {
		try {
			for (MyWoodman newWoodman : m_woodmanList.values()) {         
				printList.get(newWoodman.GetLocation().getX()).setCharAt(newWoodman.GetLocation().getY(), newWoodman.GetName().charAt(0));
				printList.add(new StringBuilder(newWoodman.GetName().charAt(0) + " - " + newWoodman.GetName() + '(' + newWoodman.GetLifeCount() + " lives)"));
			}		
			StringBuilder PrintOut = new StringBuilder(); 
			for(StringBuilder str : printList) {             
				PrintOut.append(str);                      
				PrintOut.append(System.lineSeparator());   
			}	
			System.out.print(PrintOut.toString());
			ostream.write(PrintOut.toString());  		
		}
		finally {
			ostream.close();
		}
	}
}
