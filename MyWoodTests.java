import static org.junit.Assert.*;

import org.junit.Test;


public class MyWoodTest {

	@Test
	public void testMove1() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		assertEquals(W.move("B", Direction.Down) , Action.WoodmanNotFound);
	}

	@Test
	public void testMove2() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		assertEquals(W.move("A",Direction.Up) , Action.Fail);
	}

	@Test
	public void testMove3() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		assertEquals(W.move("A",Direction.Down) , Action.Ok);
	}

	@Test
	public void testMove4() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		assertEquals(W.move("A",Direction.Right) , Action.Life);
	}

	@Test
	public void testMove5() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(1,1);
		W.createWoodman("A", k);
		W.move("A",Direction.Down); //ok
		assertEquals(W.move("A",Direction.Right) , Action.Dead);
	}

	@Test
	public void testMove6() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k1=new Point(1,1);
		W.createWoodman("A", k1);
		W.move("A",Direction.Down); //ok
		W.move("A",Direction.Right); //dead
		W.move("A",Direction.Left);  //ok
		W.move("A",Direction.Right); //dead
		W.move("A",Direction.Left); //ok
		W.move("A",Direction.Right); //dead
		W.move("A",Direction.Left); //ok
		assertEquals(W.move("A",Direction.Right) , Action.WoodmanNotFound);
	}
	@Test
	public void testMove7() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(2,1);
		W.createWoodman("A", k);
		assertEquals(W.move("A",Direction.None) , Action.Life);
	}
	@Test
	public void testMove8() throws CodeException {
		char[][]wood = new char[4][4];
		for (int j=0;j<4;j++) {
			wood[0][j]='1';
			wood[3][j]='1';
		}
		for (int i=0;i<4;i++) {
			wood[i][0]='1';
			wood[i][3]='1';
		}
		wood[1][1]='0';
		wood[2][1]='L';
		wood[1][2]='0';
		wood[2][2]='K';
		MyWood W=new MyWood(wood);
		Point k=new Point(2,1);
		W.createWoodman("A", k);	
		assertEquals(W.move("A",Direction.Up) , Action.Life);
	}
}
