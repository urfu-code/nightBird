import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class PrintableWood extends MyWood {

	private OutputStream out;

	public PrintableWood(char[][] wood, int width, int height, OutputStream stream) {
		super(wood, width, height);
		this.out = stream;
	}
	
	@Override
	public void createWoodman (String name, Point start) throws IOException {
		super.createWoodman(name, start);
		printWood();
	}
	
	@Override
	public Action move (String name, Direction direction) {
		Action action = super.move(name, direction);
		printWood();
		return action;
	}

	private void printWood() {
		try {
			OutputStreamWriter stream = new OutputStreamWriter(out, System.getProperty("file.encoding"));
			for (int i = 0; i < super.widthWood; i++) {
				for (int j = 0; j < super.heightWood; j++)
					for (MyWoodman elem : m_woodmanList.values()) {
						if (m_wood[i][j] == m_wood[elem.GetLocation().getX()][elem.GetLocation().getY()]) {
							stream.write(elem.GetName().charAt(0));
						} else {
							stream.write(toChangeSymbol(m_wood[i][j]));
						}
					}
				stream.write(System.lineSeparator());
			}
			stream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private char toChangeSymbol(char c) {
		if (c == '1') return '█';
		if (c == '0') return ' ';
		if (c == 'L') return '▒';
		if (c == 'K') return '♥';
		return c;
	}
}
