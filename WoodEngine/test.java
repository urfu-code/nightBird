package WoodEngine;

import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		Character[] a = {'1', '1', '1', '1', '1', '0', '0', '1', '1', '2', '3', '1', '1', '1', '1', '1'};
		PrintableWood prw = new PrintableWood(a, 4, 4);
		prw.createWoodman("spazm", new Point(1, 1));
		prw.createWoodman("boolya", new Point(1, 1));
		prw.move("spazm", Direction.Right);
		prw.move("spazm", Direction.Down);
		prw.move("spazm", Direction.Left);
	}

}
