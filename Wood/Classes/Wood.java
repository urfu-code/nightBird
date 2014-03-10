package Classes;

import java.util.HashMap;
import java.util.Map;

import Enums.Action;
import Enums.Direction;
import Exceptions.*;
import Interfaces.WoodInterface;
import Interfaces.WoodmanInterface;

public class Wood implements WoodInterface {
	private int sizeX;
	private int sizeY;
	private Map <Point, Boolean> m_woodmansMap;
	private char[][] m_wood;
	private Map <String, WoodmanInterface> m_woodmans;
	
	public Wood (char [][] wood) {
		m_wood = wood;
		sizeX=m_wood.length;
		sizeY=m_wood[0].length;
		m_woodmans = new HashMap<>();
		m_woodmansMap=new HashMap<>();
	}
	@Override
	public void createWoodman(String name, Point start) throws UnexceptableNameException, OccupiedLocationException{
		if (m_woodmans.containsKey(name))
			throw new UnexceptableNameException(name);
		if (m_woodmansMap.containsKey(start))
			throw new OccupiedLocationException(start);
		//НАЧИНАТЬ ОТ СЮДА
		m_woodmans.put(name, new Woodman(start, name));
	}

	@Override
	public Action move(String name, Direction direction) throws UnexceptableNameException {
		if (!m_woodmans.containsKey(name))
			throw new UnexceptableNameException(name);
		WoodmanInterface carecter = m_woodmans.get(name);
		Point location = carecter.GetLocation();
		switch (direction) {
			case Up:
				location.MoveUp();
				break;
			case Down:
				location.MoveDown();
				break;
			case Right:
				location.MoveRigth();
				break;
			case Left:
				location.MoveLeft();
				break;
			case None:
				break;
		}
		int x = location.getX();
		int y = location.getY();
		if ( (x<0) || (x>m_wood.length) )
			throw new RuntimeException("неправильная координата Х=" + x);
		if ( (y<0) || (y>m_wood[0].length) )
			throw new RuntimeException("неправильная координата Y=" + y);
		//Координаты пишутся наоборот! первая - номер строки (Y), вторая - номер символа в строке (Х)
		switch (m_wood[x][y]) {
			case '0':
				return Action.Ok;
			case '1':
				return Action.Fail;
			case 'K':
				carecter.SetLocation(location);
				if (carecter.Kill())
					return Action.Ok;
				else 
					return Action.Dead;
			case 'L':
				carecter.SetLocation(location);;
				carecter.AddLife();				
		}
		return null;
	}
}
