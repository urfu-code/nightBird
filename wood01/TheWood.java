package wood01;

import java.util.HashMap;
import java.util.Map;

import wood01Interfaces.Wood;

public class TheWood implements Wood {
	
	private char[][] wood;
	private Map<String,TheWoodman>woodmans;
	
	public TheWood(char[][] _wood) {
		wood = _wood;
		woodmans = new HashMap<String,TheWoodman>();
	}
	@Override
	public void createWoodman(String name, Point start) {
		woodmans.put(name,new TheWoodman(name, start));
	}

	@Override
	public Action move(String name, Direction direction) throws Exception {
		TheWoodman currentWoodman = woodmans.get(name);
		if (currentWoodman == null) {
			return Action.WoodmanNotFound;
		} 
		Point newPosition = currentWoodman.GetLocation();
		
		switch (direction)  {
		
		case Up:
			newPosition = newPosition.MoveUp();
			break;
		case Down:
			newPosition = newPosition.MoveDown();
			break;
		case Left:
			newPosition = newPosition.MoveLeft();
			break;
		case None:
			return Action.Ok;
		case Right:
			newPosition = newPosition.MoveRight();
			break;
		default:
			break;
		}
		Action currentAction;
		if ((newPosition.getX() < 0)||(newPosition.getX() > wood[0].length)||
		    (newPosition.getY() < 0)||(newPosition.getY() > wood.length)) {
			currentAction = Action.Fail;
		}
		//проверка на двух вудманов на одной клетке. уберем если че
		for (TheWoodman i: woodmans.values()) {
			if (i.GetLocation().equals(newPosition)) {
				// нужно будет отдельный экшн сделать для этого
				currentAction = Action.Fail;
			}
		}
		switch(wood[newPosition.getY()][newPosition.getX()]) {
		
		case '1':
			currentAction = Action.Fail;
			break;
		case '0':
			currentWoodman.SetLocation(newPosition);
			currentAction = Action.Ok;
			break;
		case 'K':
			if (currentWoodman.Kill()) {
				currentWoodman.SetLocation(newPosition);
				currentAction = Action.Dead;
			}
			else {
				woodmans.remove(name);
				currentAction = Action.WoodmanNotFound;
			}
			break;
		case 'L':
			currentWoodman.AddLife();
			currentWoodman.SetLocation(newPosition);
			currentAction = Action.Life;
			break;
		default:
			throw new Exception("неопознанная клетка");
		}
		if (currentAction == Action.Fail) {
			if (wood[currentWoodman.GetLocation().getY()][currentWoodman.GetLocation().getX()] == 'K') {
				if(currentWoodman.Kill()) {
					currentAction = Action.Dead;
				}
				else {
					currentAction = Action.WoodmanNotFound;
				}
			}
			else if (wood[currentWoodman.GetLocation().getY()][currentWoodman.GetLocation().getX()] == 'L') {
				currentWoodman.AddLife();
				currentAction = Action.Life;
			}
		}
		return currentAction;
	}
	
	public boolean equalsOfWoods(TheWood eqWood) {
		for (int i = 0; i < wood.length; i++) {
			for (int j = 0; j < wood[0].length; j++) {
				if (wood[i][j] != eqWood.wood[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
