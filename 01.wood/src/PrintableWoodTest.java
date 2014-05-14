import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class PrintableWoodTest {
	private My_WoodLoader loader;
	private String st;
	private ByteArrayInputStream in;
	private ByteArrayOutputStream out;
	private PrintableWood wood;
	@Before
	public void start(){
		loader = new My_WoodLoader();
		st = "11111/n"
		   + "10L01/n"
		   + "1K001/n"
		   + "11111/n";
		in = new ByteArrayInputStream(st.getBytes());
		out = new ByteArrayOutputStream();
		wood = loader.Load(in, out);
	}
	
	@Test
	public void testprint() throws IOException {
		String str = "∆∆∆∆∆/n"
				+ "∆ ♥ ∆/n"
				+ "∆×  ∆/n"
				+ "∆∆∆∆∆/n";
		assertEquals(str, out.toString());
		wood.createWoodman("Kot", new Point(1,1), new Point(3, 3));
		String str1 = "∆∆∆∆∆/n"
				+ "∆K♥ ∆/n"
				+ "∆×  ∆/n"
				+ "∆∆∆∆∆/n"
				+ "K- Kot (3 life)/n"
				+ "♥ - life/n"
				+ "× - dead/n";
		assertEquals(str, out.toString());
		assertEquals(Action.Life, wood.move("Kot", Direction.Right));
		String str2 = "∆∆∆∆∆/n"
				+ "∆ K ∆/n"
				+ "∆×  ∆/n"
				+ "∆∆∆∆∆/n"
				+ "K- Kot (4 life)/n"
				+ "♥ - life/n"
				+ "× - dead/n";
		assertEquals(Action.Ok, wood.move("Kot", Direction.Right));
		String str3 =  "∆∆∆∆∆/n"
				+ "∆ ♥K∆/n"
				+ "∆×  ∆/n"
				+ "∆∆∆∆∆/n"
				+ "K- Kot (4 life)/n"
				+ "♥ - life/n"
				+ "× - dead/n";
		assertEquals(Action.Ok, wood.move("Kot", Direction.Down));
		wood.createWoodman("Lawliet", new Point(1,1), new Point(2, 2));
		String str4 = "∆∆∆∆∆/n"
				+ "∆L♥ ∆/n"
				+ "∆× K∆/n"
				+ "∆∆∆∆∆/n"
				+ "L - Lawliet (3 life)/n"
				+ "K- Kot (4 life)/n"
				+ "♥ - life/n"
				+ "× - dead/n";
		assertEquals(Action.Dead, wood.move("Lawliet", Direction.Down));
		String str5 =  "∆∆∆∆∆/n"
				+ "∆ ♥ ∆/n"
				+ "∆×LK∆/n"
				+ "∆∆∆∆∆/n"
				+ "L - Lawliet (2 life)/n"
				+ "K- Kot (4 life)/n"
				+ "♥ - life/n"
				+ "× - dead/n";
		assertEquals(Action.Ok, wood.move("Lawliet", Direction.Right));
		assertEquals(str + str1 + str2 + str3 + str4 + str5, out.toString());
	}
	

}
