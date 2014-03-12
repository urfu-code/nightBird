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
			if(m_woodmanList.get(name).GetLifeCount()>-1) {
				int x=0; int y=0;
				int i=m_woodmanList.get(name).GetLocation().getX();
				int j=m_woodmanList.get(name).GetLocation().getY();
				if (direction==Direction.Up) { 
					n=new Point(i-1,j);
					x=i-1; y=j;
				}
				if (direction==Direction.Down) { 
					n=new Point(i+1,j);
					x=i+1; y=j;
				}
				if (direction==Direction.Left) {
					n=new Point(i,j-1);
					x=i; y=j-1;
				}
				if (direction==Direction.Right) {
					n=new Point(i,j+1);
					x=i; y=j+1;
				}
				if (direction==Direction.None) {
					x=i; y=j;
				}				
				if (m_wood[x][y]=='K') {
					m_woodmanList.get(name).Kill();
					result=Action.Dead;
				}
				if (m_wood[x][y]=='1') {
					result=Action.Fail;
				}
				if (m_wood[x][y]=='0') {
					result=Action.Ok;
					m_woodmanList.get(name).SetLocation(n); 
				}
				if (m_wood[x][y]=='L') {
					m_woodmanList.get(name).AddLife();
					result=Action.Life; 
				}
			} else {
				m_woodmanList.clear();
				result=Action.WoodmanNotFound;
			}
		}
		return result;
	}
}
