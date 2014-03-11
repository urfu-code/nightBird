package Classes;

import java.util.HashMap;
import java.util.Map;

import Enums.Action;
import Enums.Direction;
import Exceptions.*;
import Interfaces.WoodInterface;
import Interfaces.WoodmanInterface;

public class Wood implements WoodInterface {
	private char[][] m_wood;
	private Map <String, WoodmanInterface> m_woodmans;
	
	public Wood (char [][] wood) {
		m_wood = new char[wood.length][];
		for (int i=0; i<wood.length; i++)
			m_wood[i]=wood[i].clone();
		m_woodmans = new HashMap<>();
	}
	@Override
	public void createWoodman(String name, Point start) throws UnexceptableNameException, OccupiedLocationException{
//		Проверка на уникальность имени
		if (m_woodmans.containsKey(name))
			throw new UnexceptableNameException(name);
//		Проверка, нет ли в точке старта другого игрока
		if (!freeCal(start))
			throw new OccupiedLocationException(start);
//		Проверка на то, нет ли в точке старта стены
		if (m_wood[start.getX()][start.getY()]=='1')
			throw new OccupiedLocationException(start);
		
		m_woodmans.put(name, new Woodman(start, name));
	}

	@Override
	public Action move(String name, Direction direction) {
		if (!m_woodmans.containsKey(name))
			return Action.WoodmanNotFound;
		WoodmanInterface carecter = m_woodmans.get(name);
		Point location = carecter.GetLocation();
		switch (direction) {
			case Up:
				location = location.MoveUp();
				break;
			case Down:
				location = location.MoveDown();
				break;
			case Right:
				location = location.MoveRigth();
				break;
			case Left:
				location = location.MoveLeft();
				break;
			case None:
				//Тк мы потом проверим, не занята ли клетка, на которую пытаемся перейти, надо выйти в этот момент,
				//Иначе получится, что мы пытаемся остаться на клетке, которая занята (Нами)
				return Action.Ok;
			
		}
		int x = location.getX();
		int y = location.getY();
		if ( (x<0) || (x>m_wood.length) )
			throw new RuntimeException("неправильная координата Х=" + x + ". А длина массива по X: " + m_wood.length);
		if ( (y<0) || (y>m_wood[0].length) )
			throw new RuntimeException("неправильная координата Y=" + y + ". А длина массива по Y: " + m_wood[0].length);
		if (!freeCal(location))
			return Action.OccupiedLocation;
		switch (m_wood[x][y]) {
			case '0':
				carecter.SetLocation(location);
				return Action.Ok;
			case '1':
				return Action.Fail;
			case 'K':
				carecter.SetLocation(location);
				if (carecter.Kill())
					return Action.Dead;
				else
//					умер((
					return Action.WoodmanNotFound;
			case 'L':
				carecter.SetLocation(location);
				carecter.AddLife();				
				return Action.Life;
		}
		//Никогда до этого момента не должен дойти
		return null;
	}
	/**
	 * Проверка на свободность ячейки
	 * @param point
	 * @return true - если в ячейке нет другого Вудмана
	 */
	private boolean freeCal(Point point) {
		for (WoodmanInterface i: m_woodmans.values())
			if (i.GetLocation().equals(point))
				return false;
		return true;
	}
}
