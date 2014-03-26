import java.io.IOException;
import java.util.HashMap;

public class MyWood implements Wood {
	protected char[][] m_wood;
	protected int widthWood;
	protected int heightWood;
	protected HashMap<String, MyWoodman>  m_woodmanList = new HashMap <String, MyWoodman>();
	
	public MyWood (char [][] wood, int width, int height) {
		m_wood = wood.clone();
		widthWood = width;
		heightWood = height;
	}

	public void createWoodman(String name, Point start) throws IOException {
		if (m_woodmanList.containsKey(name)) {
			throw new IOException("The player with such name already exists.");
		}
		if (m_wood[start.getX()][start.getY()] == '1') {
			throw new IOException("Start point is a wall");
		}
		MyWoodman man = new MyWoodman(name, start);
		m_woodmanList.put(name, man);
	}

	public Action move(String name, Direction direction) {
		if (!m_woodmanList.containsKey(name)) {
			return Action.WoodmanNotFound;
		}
		Point loc = m_woodmanList.get(name).GetLocation();
		Point tempLoc = m_woodmanList.get(name).GetLocation();
		switch (direction) {
		case Down: tempLoc.MoveDown();
		break;
		case Right: tempLoc.MoveRigth();
		break;
		case Left: tempLoc.MoveLeft();
		break;
		case Up: tempLoc.MoveUp();
		break;
		case None: return Action.Ok;
		}
		switch (m_wood[tempLoc.getX()][tempLoc.getY()]) {
		case '1': {
			if (m_wood[loc.getX()][loc.getY()] == 'K') {
				if (m_woodmanList.get(name).Kill()) {
					return Action.Fail;
				} else {
					m_woodmanList.remove(name);
					return Action.WoodmanNotFound;
				}
			}
			if (m_wood[loc.getX()][loc.getY()] == 'L') {
				m_woodmanList.get(name).AddLife();
				return Action.Fail;
			}
			return Action.Fail;
		}
		case '0': {
			m_woodmanList.get(name).SetLocation(tempLoc);
			return Action.Ok;
		}
		case 'L': {
			m_woodmanList.get(name).SetLocation(tempLoc);
			m_woodmanList.get(name).AddLife();
			return Action.Life;
		}
		case 'K': {
			if (m_woodmanList.get(name).Kill()) {
				m_woodmanList.get(name).SetLocation(tempLoc);
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
