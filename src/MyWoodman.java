
public class MyWoodman implements Woodman {

	private int m_lifecount;
	private String m_name;
	private Point m_location;
	private Point m_start;
	
	public MyWoodman( String name, Point start) {
		m_name = name;
		m_location = start;
		m_start = start;
		m_lifecount = 3;
	}
	
	@Override
	public int GetLifeCount() {
		return m_lifecount;
	}

	@Override
	public String GetName() {
		return m_name;
	}

	@Override
	public boolean Kill() {
		m_lifecount = m_lifecount - 1;
		if (m_lifecount < 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public void AddLife() {
		m_lifecount = m_lifecount + 1;
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
