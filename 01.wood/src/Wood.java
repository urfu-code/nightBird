
import java.util.HashMap;


public class Wood implements IWood {
	private HashMap<Point, Character> labyrinth; // инфа по стенам и тропинкам
	private int labLength = 0;
	private int labWidth = 0;
	private HashMap<String, Woodman> listOfWoodmen = new HashMap<String, Woodman>(); // список игроков
	
	Wood(HashMap<Point, Character> lab, int length, int width) {
		this.labyrinth = lab;
		this.labLength = length;
		this.labWidth = width;
	}
	
	public Character getChar(Point location) {
		return labyrinth.get(location);
	}
	
	public Woodman getWoodman(String name) {
		return listOfWoodmen.get(name);
	}

	@Override
	public void createWoodman(String name, Point start) {
		if (!listOfWoodmen.containsKey(name)) // имя уникально
			listOfWoodmen.put(name, new Woodman(name, start));
		else throw new RuntimeException("Такой вудмен уже есть в лесу!");
	}

	public Action result(Character symbol, String name) {
		switch (symbol) {  // символ лабиринта, на котором мы стоим
		case '0' : return Action.Ok;
		case '1' : return Action.Fail;
		case 'L' : getWoodman(name).AddLife(); return Action.Life;
		case 'K' : 
			if (getWoodman(name).Kill()) {
				getWoodman(name).MoveToStart();
			}
			else {
					listOfWoodmen.remove(name);
				}
			return Action.Dead;
		}
		return Action.Ok;
	}
	@Override
	public Action move(String name, Direction direction) throws RuntimeException, WoodmanNotFound {
		if (!listOfWoodmen.containsKey(name))
			throw new WoodmanNotFound("Нет такого вудмена в лесу!");
				
		switch (direction) {
		case Up :
			getWoodman(name).SetLocation(getWoodman(name).GetLocation().MoveUp());
			if (getWoodman(name).GetLocation().getY() < 0)
				throw new RuntimeException("Выход за границы лабиринта!");
			return result (getChar(getWoodman(name).GetLocation()), name);
		case Down :
			getWoodman(name).SetLocation(getWoodman(name).GetLocation().MoveDown());
			if (getWoodman(name).GetLocation().getY() > labWidth)
				throw new RuntimeException("Выход за границы лабиринта!");
			return result (getChar(getWoodman(name).GetLocation()), name);
		case Right :
			getWoodman(name).SetLocation(getWoodman(name).GetLocation().MoveRigth());
			if (getWoodman(name).GetLocation().getX() > labLength)
				throw new RuntimeException("Выход за границы лабиринта!");
			return result (getChar(getWoodman(name).GetLocation()), name);
		case Left :
			getWoodman(name).SetLocation(getWoodman(name).GetLocation().MoveLeft());
			if (getWoodman(name).GetLocation().getX() < 0)
				throw new RuntimeException("Выход за границы лабиринта!");
			return result (getChar(getWoodman(name).GetLocation()), name);
		case None : break;
		default: throw new RuntimeException("Введено неверное направление!");
		}
		return Action.Ok;
	}

}
