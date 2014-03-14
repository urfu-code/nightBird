import java.util.HashMap;
import java.util.Map;

public class MyWood implements Wood {
	Map <String,MyWoodman> m_woodmanList=new HashMap<String,MyWoodman>();
	private char [][] m_wood;

	public MyWood(char[][] wood) {
		m_wood=wood;
	}

	public void createWoodman(String name, Point start) {
		MyWoodman m_woodman=new MyWoodman(name,start);
		m_woodmanList.put(name,m_woodman);		
	}

	public Action move(String name, Direction direction) {
		Action result=null;
		if (!m_woodmanList.containsKey(name)) {
			result=Action.WoodmanNotFound;
		} else {
			Point n=m_woodmanList.get(name).GetLocation();
			Point newPoint = m_woodmanList.get(name).GetLocation();
			if(m_woodmanList.get(name).GetLifeCount()>-1) {

				switch (direction) {
				case Up: newPoint=n.MoveUp();
				break;
				case Down: newPoint=n.MoveDown();
				break;
				case Left: newPoint=n.MoveLeft();
				break;
				case Right: newPoint=n.MoveRigth();
				break;	
				case None: result=Action.Ok;
				}
				
				switch (m_wood[newPoint.getX()][newPoint.getY()]) {
				case '1': {
					if(m_wood[newPoint.getX()][newPoint.getX()]=='K') {
						m_woodmanList.get(name).Kill();
						result=Action.Dead;
					}
					if(m_wood[newPoint.getX()][newPoint.getX()]=='L') {
						m_woodmanList.get(name).AddLife();
						result=Action.Life;
					}
					else 
						result=Action.Fail;
				}
				break;
				case '0': {
					result= Action.Ok;
					m_woodmanList.get(name).SetLocation(newPoint);
				}
				break;
				case 'L': {
					m_woodmanList.get(name).AddLife();
					result=Action.Life; 
					m_woodmanList.get(name).SetLocation(newPoint); 
				}
				break;
				case 'K': {
					m_woodmanList.get(name).Kill();
					result=Action.Dead;
					m_woodmanList.get(name).SetLocation(newPoint); 
					if(m_woodmanList.get(name).GetLifeCount()<=-1) {
						m_woodmanList.remove(name);
						result=Action.WoodmanNotFound;
					} 
				}
				break;
				}
		}
	}
	return result;
}
}
