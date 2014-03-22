package defpac;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyWood implements Wood {
	protected char[][] m_wood;
	protected Map<String, MyWoodman>m_woodmanList;
	
	MyWood (char[][] wood){
		m_wood = wood;
		m_woodmanList = new HashMap<String, MyWoodman>();
	}
	
	public void createWoodman(String name, Point start) throws IOException {
		if (m_woodmanList.containsKey(name)) {
			throw new IOException("������ � ����� ������ ��� ����������");
		}
		m_woodmanList.put(name, new MyWoodman(name,start));
	}
	
	public Action move (String name, Direction direction) throws IOException {
		if (!m_woodmanList.containsKey(name)) {
			return Action.WoodmanNotFound;
		}		
		Point newLocation = (m_woodmanList.get(name)).GetLocation();
		if ((newLocation.getX() >= m_wood[0].length)||(newLocation.getX() < 0)||
		   (newLocation.getY() >= m_wood.length)||(newLocation.getY() < 0))
		{
			throw new IOException("����� �� ������� ����");
		}
		switch (direction) {
			case Up: 
				newLocation = newLocation.MoveUp();
				break;
			
			case Down: 
				newLocation = newLocation.MoveDown();
				break;
			
			case Left:
				newLocation = newLocation.MoveLeft();
				break;
			
			case Right: 
				newLocation = newLocation.MoveRigth();
				break;
			
			case None: 
				newLocation = (m_woodmanList.get(name)).GetLocation();
		}
		Action current;
		MyWoodman currentW = m_woodmanList.get(name);
		char movedPoint = m_wood[newLocation.getY()][newLocation.getX()];
		switch(movedPoint) {
			
			case '1':
				current = Action.Fail;
				break;
			case '0':
				currentW.SetLocation(newLocation);
				current = Action.Ok;
				break;
			case 'K':
				if (currentW.Kill()) {
					currentW.SetLocation(newLocation);
					current = Action.Dead;
				}
				m_woodmanList.remove(name);
				current = Action.WoodmanNotFound;
				break;
			case 'L':
				currentW.AddLife();
				currentW.SetLocation(newLocation);
				current = Action.Life;
				break;
			default:
				return null;
		}
		if ((current == Action.Fail) || (direction == Direction.None)) {
			if (m_wood[currentW.GetLocation().getY()][currentW.GetLocation().getX()] == 'K') {
				if (!currentW.Kill()) {
					m_woodmanList.remove(name);
					current = Action.WoodmanNotFound;
				} else {
					current = Action.Dead;
				}
			}
			if (m_wood[currentW.GetLocation().getY()][currentW.GetLocation().getX()] == 'L') {
				currentW.AddLife();
				current = Action.Life;
			}
		}
		return current;
	}
	public boolean equals(Object wood) {
		if (wood == null) return false;
		if (wood.getClass() != MyWood.class) return false;
		MyWood forests = (MyWood) wood;
		char[][] forest = forests.m_wood;
		boolean eq = true;
		for (int j = 0; j < forest[0].length; j++) {
			for (int i = 0; i < forest.length; i++) {
				if (forest[j][i] != m_wood[j][i]) { 
					eq = false;
					break;
				}
			}
		}
		return eq;
	}
}