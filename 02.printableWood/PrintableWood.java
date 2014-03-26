
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintableWood extends MyWood {

	List<StringBuilder> printList = new LinkedList<StringBuilder>(); 
	private OutputStreamWriter ostream;
	int wl = m_wood.length;  
	int ww = m_wood[0].length; 
	private Map <String,Character> m_woodmans=new HashMap<String,Character>();
	private Set <Character> m_woodmanListOfSymbols =  new HashSet<Character>();
	public PrintableWood(char[][] wood,OutputStream stream) throws IOException {
		super(wood);
		ostream = new OutputStreamWriter(stream);
		m_woodmanListOfSymbols.addAll(Arrays.asList('☃','★','☆','☺','☻','♔','♕','♘','♞','♟','♚','⛷','♈','♉','♊','♋','♌','♍','♎','♏','♐','♑','♒','♓','✈','♦'));	 	
		for(int i = 0; i < wl; i++) { 	
			StringBuilder s = new StringBuilder(); 
			for(int j = 0; j < ww; j++) { 	                    
				char woodChar = m_wood[i][j];	 
				switch (woodChar) {	
				case '0':s.append('○');	
				break;
				case '1':s.append('✿');	
				break;
				case 'L':s.append('♥');	
				break;
				case 'K':s.append('✖');	
				}
			}
			printList.add(s);
		}	
		printList.add(new StringBuilder());    
		printList.add(new StringBuilder('♥' + " - life")); 
		printList.add(new StringBuilder('✖' + " - death"));
	}

	@Override
	public void createWoodman(String name, Point start) throws CodeException, IOException{
		super.createWoodman(name, start);
		Iterator<Character> itr = m_woodmanListOfSymbols.iterator();	
		char symbolOfWoodman = itr.next();	
		m_woodmanListOfSymbols.remove(symbolOfWoodman);
		m_woodmans.put(name, symbolOfWoodman);
		m_wood[start.getX()][start.getY()] = symbolOfWoodman;
		PrintWood();
	}

	private char getSymbol(int x, int y) {
		char k;
		k = m_wood[x][y];
		switch (k) {	
		case '0':
			k='○';	
			break;
		case '1':
			k='✿';	
			break;
		case 'L':
			k='♥';	
			break;
		case 'K':
			k='✖';	
		}
	return k;
	}

	@Override
	public Action move(String name, Direction direction) throws IOException {
		Point startLocation;
		for (MyWoodman newWoodman : m_woodmanList.values()){
			startLocation = newWoodman.GetLocation();
			m_wood[startLocation.getX()][startLocation.getY()] = getSymbol(startLocation.getX(), startLocation.getY());		
		}			
		Action result=super.move(name, direction);
		for (MyWoodman newWoodman : m_woodmanList.values()){
			Point newLocation =  newWoodman.GetLocation();
			m_wood[newLocation.getX()][newLocation.getY()] = m_woodmans.get(name);							
		}
		PrintWood();
		return result;
	}



	public void PrintWood() throws IOException {

		try { 
			for (MyWoodman newWoodman : m_woodmanList.values()) {  
				printList.get(newWoodman.GetLocation().getX()).setCharAt(newWoodman.GetLocation().getY(), m_wood[newWoodman.GetLocation().getX()][newWoodman.GetLocation().getY()]);
				printList.add(new StringBuilder(m_wood[newWoodman.GetLocation().getX()][newWoodman.GetLocation().getY()] + " - " + newWoodman.GetName() + '(' + newWoodman.GetLifeCount() + " lives)"));	
			}	

			StringBuilder PrintOut = new StringBuilder(); 
			for(StringBuilder str : printList) {             
				PrintOut.append(str);                      
				PrintOut.append(System.lineSeparator());   
			}	
			System.out.print(PrintOut.toString());
			ostream.write(PrintOut.toString());  		
			ostream.flush();
		}
		catch(Exception e) {
			ostream.close();
			e.printStackTrace();
		}
	}
}
