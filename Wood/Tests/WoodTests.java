package Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import Classes.Point;
import Classes.WoodLoader;
import Enums.Action;
import Enums.Direction;
import Exceptions.EmptyFileException;
import Exceptions.InvalidFileException;
import Exceptions.OccupiedLocationException;
import Exceptions.UnexceptableNameException;
import Interfaces.WoodInterface;

public class WoodTests {

	private WoodInterface myWood;
	
	@Before
	public void makeWood() {
		String[] masOfStr = new String [4];
		masOfStr[0] = "1111\n";
		masOfStr[1] = "1001\n";
		masOfStr[2] = "1LK1\n";
		masOfStr[3] = "1111\n";
		StringBuilder strBuild = new StringBuilder();
		for (int i=0; i<masOfStr.length; i++)
			strBuild.append(masOfStr[i]);
		String str = strBuild.toString();
		byte[] buf = str.getBytes();
		ByteArrayInputStream stream = new ByteArrayInputStream(buf);
		WoodLoader loader = new WoodLoader();
		try {
			myWood = loader.Load(stream);
		} catch (EmptyFileException e) {
			fail("EmptyFileException");
			e.printStackTrace();
		} catch (InvalidFileException e) {
			fail("InvalidFileException");
			e.printStackTrace();
		}
	}

	@Test(expected = UnexceptableNameException.class)
	public void testUnexceptableNameException() throws UnexceptableNameException, OccupiedLocationException {
		myWood.createWoodman("Player", new Point(1, 1));
		myWood.createWoodman("Player", new Point(2, 1));
	}
	
	@Test(expected = OccupiedLocationException.class)
	public void testOccupiedLocationException() throws UnexceptableNameException, OccupiedLocationException {
		myWood.createWoodman("Player1", new Point(1, 1));
		myWood.createWoodman("Player2", new Point(1, 1));
	}
	
	@Test
	public void testOK() throws UnexceptableNameException, OccupiedLocationException {
		myWood.createWoodman("Player1", new Point(1, 1));
		assertEquals(Action.Ok, myWood.move("Player1", Direction.Right));
	}

	@Test
	public void testFail() throws UnexceptableNameException, OccupiedLocationException {
		myWood.createWoodman("Player1", new Point(1, 1));
		assertEquals(Action.Fail, myWood.move("Player1", Direction.Up));
	}
	
	@Test
	public void testWoodmanNotFound() throws EmptyFileException, InvalidFileException {
		try {
			myWood.createWoodman("Player1", new Point(1, 1));
			assertEquals(myWood.move("Player1", Direction.Right), Action.Ok);
			assertEquals(Action.Dead, myWood.move("Player1", Direction.Down)); //2 жизни
			assertEquals(Action.Ok, myWood.move("Player1", Direction.Up));
			assertEquals(Action.Dead, myWood.move("Player1", Direction.Down)); //1 жизнь
			assertEquals(Action.Ok, myWood.move("Player1", Direction.Up));
			assertEquals(Action.Dead, myWood.move("Player1", Direction.Down)); //0 жизней
			assertEquals(Action.Ok, myWood.move("Player1", Direction.Up));
			assertEquals(Action.WoodmanNotFound, myWood.move("Player1", Direction.Down)); //Умер
			assertEquals(Action.Ok, myWood.move("Player1", Direction.Up));
		} catch (UnexceptableNameException e) {
			fail("UnexceptableNameException");
			e.printStackTrace();
		} catch (OccupiedLocationException e) {
			fail("OccupiedLocationException");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLife() {
		try {
			myWood.createWoodman("Player", new Point(1,1));
			assertEquals(Action.Life, myWood.move("Player", Direction.Down));
		} catch (UnexceptableNameException e) {
			fail("UnexceptableNameException");
			e.printStackTrace();
		} catch (OccupiedLocationException e) {
			fail("OccupiedLocationException");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOcupaidLocation() throws UnexceptableNameException, OccupiedLocationException {
		myWood.createWoodman("Player1", new Point(1, 1));
		myWood.createWoodman("Player2", new Point(2, 1));
		assertEquals(Action.OccupiedLocation, myWood.move("Player1", Direction.Right));
	}
}
