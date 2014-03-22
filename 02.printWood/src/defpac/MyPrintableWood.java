package defpac;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class MyPrintableWood extends MyWood {
	private OutputStream out;

	public MyPrintableWood(char[][] m_wood, OutputStream out) {
		super(m_wood);
		this.out = out;// сам поток
		// this.printWood();
	}

	/*
	 * private void printWood() { ByteArrayOutputStream stream = new...();
	 * stream.write(123); byte[] array = stream.toByteArray(); }
	 */

	public void printWood() {
		boolean life = false;
		boolean death = false;
		int IdxSymbols = 1;
		Map<String, String> code = new HashMap<String, String>();
		String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (MyWoodman man : m_woodmanList.values()) {
			code.put(man.GetName(), symbols.substring(IdxSymbols - 1,
					IdxSymbols++));
		}
		for (int j = 0; j < m_wood.length; j++) {
			for (int i = 0; i < m_wood[0].length; i++) {
				boolean player = false;
				for (MyWoodman man : m_woodmanList.values()) {
					Point point = new Point(j, i);
					if (man.GetLocation().equals(point)) {
						System.out.print(code.get(man.GetName()));
						player = true;
					}
				}
				if (player == false) {
					switch (m_wood[j][i]) {
					case '1':
						if (i == 0 && j == 0)
							System.out.print("┌");
						if (i == m_wood[0].length - 1 && j == 0)
							System.out.print("┐");
						if (i == 0 && j == m_wood.length - 1)
							System.out.print("└");
						if (i == m_wood[0].length - 1 && j == m_wood.length - 1)
							System.out.print("┘");
						if (i > 0 && i < m_wood[0].length - 1
								&& (j == 0 || j == m_wood.length - 1))
							System.out.print("─");
						if (j > 0 && j < m_wood.length - 1
								&& (i == 0 || i == m_wood[0].length - 1))
							System.out.print("│");
						// if (i > 0 && j > 0 && i < forest[0].length-1 && j <
						// forest.length-1) System.out.print("█");
						// если важно - могу запилить отдельно
						break;
					case '0':
						System.out.print(" ");
						break;
					case 'K':
						death = true;
						System.out.print("†");
						break;
					case 'L':
						life = true;
						System.out.print("♥");
						break;
					default:
						break;
					}
				}
			}
			System.out.print("\n");
		}
		if (life)
			System.out.print("\n♥ - life");
		if (death)
			System.out.print("\n† - death\n");
		// предполагаем, что игроков не более 26 :-)
		for (MyWoodman man : m_woodmanList.values()) {
			System.out.print(code.get(man.GetName()) + " - " + man.GetName()
					+ " , lifes: " + man.GetLifeCount() + "\n");
		}
	}

	@Override
	public void createWoodman(String name, Point start) throws IOException {
		super.createWoodman(name, start);
		printWood();
	}

	@Override
	public Action move(String name, Direction direction) throws IOException {
		Action action = super.move(name, direction);
		printWood();
		return action;
	}
}