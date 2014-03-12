package WoodEngine;


public class Woodman implements IWoodman{
	
	private int m_lifeCount;
	private final Point m_start;
	private Point m_location;
	private final String m_name;
	
	public Woodman(String name, Point start){
		m_lifeCount = 3;
		m_name = name;
		m_start = m_location = start;
	}

	@Override
	public int GetLifeCount() {
		return m_lifeCount;
	}

	@Override
	public String GetName() {
		return m_name;
	}

	@Override
	public boolean Kill() {
		m_lifeCount = m_lifeCount - 1;
		if (m_lifeCount < 0){
			return true;
		}
		else return false;
	}

	@Override
	public void AddLife() {
		m_lifeCount = m_lifeCount + 1;
	}

	@Override
	public Point GetLocation() {
		return m_location;
	}

	@Override
	public void SetLocation(Point location) {
		m_location = location;
	}

	@Override
	public void MoveToStart() {
		m_location = m_start;
	}

}
