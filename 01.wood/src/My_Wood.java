import java.util.HashMap;
import java.util.Map;


public class My_Wood implements Wood {
	private char[][] m_wood;
	Map<String, My_Woodman> m_woodmanlist = new HashMap<String, My_Woodman>();
	
	public My_Wood(char[][] wood){
		m_wood = wood;
		//m_woodmanlist = null;
	}

	@Override
	public void createWoodman(String name, Point start) {
		m_woodmanlist.put(name, new My_Woodman(name, start));
	}

	@Override
	public Action move(String name, Direction direction) {
		if(!m_woodmanlist.containsKey(name)){
			return Action.WoodmanNotFound;
		}
		else{
			Point position= (m_woodmanlist.get(name)).GetLocation();
			switch (direction){
				case Up: position = position.MoveUp();
					break;
				case Down: position = position.MoveDown();
					break;
				case Left: position = position.MoveLeft();
					break;
				case Right: position = position.MoveRigth();
					break;
				case None:
					break;
				default:
					break;
			}
			char look = m_wood[position.getX()][position.getY()];
			if (look == '1') return Action.Fail;
			else {
				if (look == 'K'){
					if(!(m_woodmanlist.get(name)).Kill()){
						m_woodmanlist.remove(name);
						return Action.Dead;
					} else {
						(m_woodmanlist.get(name)).SetLocation(position);
						return Action.Ok;
					}
				}
				else{
					if (look == 'L'){
						(m_woodmanlist.get(name)).AddLife();
						(m_woodmanlist.get(name)).SetLocation(position);
						return Action.Life;
					}
					else{
						if(look == '0'){
							(m_woodmanlist.get(name)).SetLocation(position);
							return Action.Ok;
						}
					}
				}
			}
			
			/*switch(m_wood[position.getX()][position.getY()]){
				case '1': return Action.Fail;
					break;
				case 'K': {
					if((m_woodmanlist.get(name)).Kill()){
						(m_woodmanlist.get(name)).SetLocation(position);
						return Action.Ok;
					} else {
						m_woodmanlist.remove(name);
						return Action.Dead;
					}
				}
					break;
				case 'L':{
					(m_woodmanlist.get(name)).AddLife();
					(m_woodmanlist.get(name)).SetLocation(position);
					return Action.Life;
				}
					break;
				case '0':{
					(m_woodmanlist.get(name)).SetLocation(position);
					return Action.Ok;
				}
				break;
			}*/
		}
		return null;
	}

}
