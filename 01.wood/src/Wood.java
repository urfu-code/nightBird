
import java.util.HashMap;


public class Wood implements IWood {
	protected HashMap<Point, Character> labyrinth; // инфа по стенам и тропинкам
	protected int labLength = 0;
	protected int labWidth = 0;
	protected HashMap<String, Woodman> listOfWoodmen = new HashMap<String, Woodman>(); // список игроков
	
	Wood(HashMap<Point, Character> lab, int length, int width) {
		this.labyrinth = lab;
		this.labLength = length;
		this.labWidth = width;
	}
	
	Character getChar(Point location) {
		return labyrinth.get(location);
	}
	
	Woodman getWoodman(String name) {
		return listOfWoodmen.get(name);
	}

	@Override
	public void createWoodman(String name, Point start) {
		if (start.getX() > 0 && start.getY() > 0 && start.getX() < labLength - 1 && start.getY() < labWidth - 1)
			if (!listOfWoodmen.containsKey(name)) // имя уникально
				listOfWoodmen.put(name, new Woodman(name, start));
			else throw new WoodmanExistsException("Такой вудмен уже есть в лесу!");		
		else throw new WoodmanOnTheWallException("Нельзя создавать персонажа на стене!");
	}

	private Action result(Point currentLocation, String name, Point newLocation) { 
		switch (getChar(newLocation)) {  // символ лабиринта, на который мы встанем
		case '0' : 
			getWoodman(name).SetLocation(newLocation);
			return Action.Ok;
		case '1' : 
			if (getChar(currentLocation) == 'K')
				result(currentLocation, name, currentLocation);
			if (getChar(currentLocation) == 'L')
				result(currentLocation, name, currentLocation);
			return Action.Fail;
		case 'L' :
			getWoodman(name).SetLocation(newLocation);
			getWoodman(name).AddLife(); return Action.Life;
		case 'K' :
			getWoodman(name).SetLocation(newLocation);
			if (getWoodman(name).Kill()) {
				return Action.Dead;
			}
			else {
					listOfWoodmen.remove(name);
					return Action.WoodmanNotFound;
				}		
		}
		return Action.Ok;
	}
	@Override
	public Action move(String name, Direction direction) throws RuntimeException {
		if (!listOfWoodmen.containsKey(name))
			return Action.WoodmanNotFound;
		switch (direction) {
		case Up : // нет условия на выход за границы, т.к. нельзя создать вудмена на стене или вне её, следовательно, за границу никак не выйти
			return result (getWoodman(name).GetLocation(), name, getWoodman(name).GetLocation().MoveUp());
		case Down :
			return result (getWoodman(name).GetLocation(), name, getWoodman(name).GetLocation().MoveDown());
		case Right :
			return result (getWoodman(name).GetLocation(), name, getWoodman(name).GetLocation().MoveRigth());
		case Left :
			return result (getWoodman(name).GetLocation(), name, getWoodman(name).GetLocation().MoveLeft());
		case None : break;
		default: throw new RuntimeException("Введено неверное направление!");
		}
		return Action.Ok;
	}

}
