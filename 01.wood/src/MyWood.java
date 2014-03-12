import java.util.HashMap;

public class MyWood implements Wood {
	private char[][] m_wood;
	private HashMap<String, MyWoodman>  m_woodmanList = new HashMap <String, MyWoodman>();
	
	public MyWood (char [][] wood) {
		m_wood = wood.clone();
	}

	public void createWoodman(String name, Point start) {
		MyWoodman man = new MyWoodman(name, start);
		m_woodmanList.put(name, man);
	}

	public Action move(String name, Direction direction) {
		Point loc = m_woodmanList.get(name).GetLocation();
		if (!m_woodmanList.containsKey(name)) {
			return Action.WoodmanNotFound;
		}
		switch (direction) {
		case Down: loc.MoveDown();
		break;
		case Right: loc.MoveRigth();
		break;
		case Left: loc.MoveLeft();
		break;
		case Up: loc.MoveUp();
		break;
		case None: return Action.Ok;
		}
		switch (m_wood[loc.getX()][loc.getY()]) {
		case '1': return Action.Fail;
		case '0': {
			m_woodmanList.get(name).SetLocation(loc);
			return Action.Ok;
		}
		case 'L': {
			m_woodmanList.get(name).SetLocation(loc);
			m_woodmanList.get(name).AddLife();
			return Action.Life;
		}
		case 'K': {
			if (m_woodmanList.get(name).Kill()) {
				m_woodmanList.get(name).SetLocation(loc);
				return Action.Dead;
			} else {
					m_woodmanList.remove(name);
					return Action.WoodmanNotFound;
			}
		}
		}
		return null;
	}
}
