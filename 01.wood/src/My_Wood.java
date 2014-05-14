import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class My_Wood implements Wood{

	protected char[][] wood;
	Map<String, My_Woodman> WoodmanList;

	public My_Wood(char[][] m_wood){
	WoodmanList = new HashMap<String, My_Woodman>();
	wood = m_wood;
	}

	@Override
	public void createWoodman (String name, Point start, Point finish) {
		try{
			if (WoodmanList.containsKey(name))
				throw new IOException("Такое имя уже существует");
			WoodmanList.put(name, new My_Woodman(name, start, finish));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public Action move(String name, Direction direction) {
		if (!WoodmanList.containsKey(name)) 
			return Action.WoodmanNotFound;
		Point position = (WoodmanList.get(name)).GetLocation();
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
		char current = wood[position.getY()-1][position.getX()-1];
		switch (current) {
		case '1': {
			if (wood[(WoodmanList.get(name).GetLocation().getY())-1][(WoodmanList.get(name).GetLocation().getX())-1] == 'K') {
				if (WoodmanList.get(name).GetLifeCount() == 0){
					WoodmanList.remove(name);
					return Action.WoodmanNotFound;
				} else {
					WoodmanList.get(name).Kill();
				}
			} 
			if (wood[(WoodmanList.get(name).GetLocation().getY())-1][(WoodmanList.get(name).GetLocation().getX())-1] == 'L')
				WoodmanList.get(name).AddLife();
			return Action.Fail;
		}
		case 'L': {
			WoodmanList.get(name).AddLife();
			WoodmanList.get(name).SetLocation(position);
			return Action.Life;
			}
		case '0': {
			WoodmanList.get(name).SetLocation(position);
				return Action.Ok;
			}
		case 'K': {
			if(!(WoodmanList.get(name)).Kill()){
					WoodmanList.remove(name);
					return Action.WoodmanNotFound;
			} else {
				WoodmanList.get(name).SetLocation(position);
				return Action.Dead;	
			}
		}
	}
		return null;
	}
}