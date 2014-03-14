package wood01;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;


public abstract class PrintableTheWood extends TheWood {
	//'┌','─','┬','┐','│','┼','┤','├','└','─','┴','┘','♥','Ⓣ',' ','□'
	private Map<String,Character>graphList;
	
	public PrintableTheWood(char[][] _wood) throws Exception {
		super(_wood);
		graphList = new HashMap<String,Character>();
		graphList.put("U", '│');
		graphList.put("D", '│');
		graphList.put("L", '─');
		graphList.put("R", '─');
		graphList.put("UD", '│');
		graphList.put("LR", '─');
		graphList.put("DR",'┌');
		graphList.put("LDR",'┬');
		graphList.put("LD",'┐');
		graphList.put("ULDR",'┼');
		graphList.put("ULD",'┤');
		graphList.put("UDR",'├');
		graphList.put("UR",'└');
		graphList.put("ULR",'┴');
		graphList.put("UL",'┘');
		graphList.put("Life",'♥');
		graphList.put("0",' ');
		graphList.put("A",'□');
		graphList.put("Trap",'ѻ');
	}	
	public void printWood(OutputStream stream) throws Exception
	{
		char[] line = new char[wood[0].length];
		for (int i = 0; i < super.wood.length; i++) {
			for (int j = 0; j < super.wood[0].length; j++) {
				line[j] = findElement(i,j);
			}
			String str = new String(line);
			stream.write((str + "\n").getBytes());
		}
		stream.write("------------\n".getBytes());
		stream.write(("♥" + " - live\n").getBytes());
		stream.write(("ѻ" + " - trap\n").getBytes());
		stream.write("------------\n".getBytes());
		for (TheWoodman i:(super.woodmans).values()) {
			stream.write((i.GetName() + " (" + i.GetName().charAt(0) + ")" + " - " + i.GetLifeCount() + " live(s)\n").getBytes());
		}
	}
	private char findElement(int line, int column) throws Exception
	{
		Point currentPoint = new Point(column,line);
		for (TheWoodman i:(super.woodmans).values()) {
			if (i.GetLocation().equals(currentPoint)) {
				return i.GetName().toUpperCase().charAt(0);
			}
		}
		switch ((super.elements).get((super.wood)[line][column])) {
		
		case 'L':
			//life
			return graphList.get("Life");
		case 'K':
			//trap
			return graphList.get("Trap");
		case '0':
			//free
			return graphList.get("0");
		default:
			break;
			
		}
		StringBuffer element = new StringBuffer();
		//up
		if ((line - 1 >= 0)&&((super.elements).get((super.wood)[line - 1][column]) == '1')) {
			element.append("U");
		}
		//left
		if ((column - 1 >= 0)&&((super.elements).get((super.wood)[line][column - 1]) == '1')) {
			element.append("L");
		}
		//down
		if ((line + 1 < (super.wood).length)&&((super.elements).get((super.wood)[line + 1][column]) == '1')) {
			element.append("D");
		}
		//right
		if ((column + 1 < (super.wood)[0].length)&&((super.elements).get((super.wood)[line][column + 1]) == '1')) {
			element.append("R");
		}
		if (element.length() > 0) {
			return graphList.get(element.toString());
		}
		else {
			return graphList.get("A");
		}
	}
	
	public Action moveAndPrint(String name, Direction direction,OutputStream stream) throws Exception {
		Action currentAction;
		currentAction = super.move(name, direction);
		this.printWood(stream);
		return currentAction;
	}
}
