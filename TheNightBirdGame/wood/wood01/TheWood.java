package wood01;

import java.util.HashMap;
import java.util.Map;

import wood01Interfaces.Wood;

public class TheWood implements Wood {
	
	protected char[][] wood;
	protected Map<String,TheWoodman>woodmans;
	protected Map<Character,Character> elements;
	
	public TheWood(char[][] _wood) throws Exception {
		wood = _wood;
		woodmans = new HashMap<String,TheWoodman>();
		elements = new HashMap<Character,Character>();
		elements.put('┌', '1');
		elements.put('─', '1');
		elements.put('┬', '1');
		elements.put('┐', '1');
		elements.put('│', '1');
		elements.put('┼', '1');
		elements.put('┤', '1');
		elements.put('├', '1');
		elements.put('└', '1');
		elements.put('─', '1');
		elements.put('┴', '1');
		elements.put('┘', '1');
		elements.put('♥', 'L');
		elements.put(' ', '0');
		elements.put('□', '1');
		elements.put('ѻ', 'K');
		elements.put('1', '1');
		elements.put('0', '0');
		elements.put('K', 'K');
		elements.put('L', 'L');
	}
	@Override
	public void createWoodman(String name, Point start) throws Exception {
		if (woodmans.containsKey(name)) {
			throw new Exception("вудман с таким именем уже существует!");
		}
		else if ((start.getX() < 0)||(start.getY() < 0)||
			(start.getX() >= wood[0].length)||(start.getY() >= wood.length)) {
			throw new Exception("не могу создать вудмана за границами мира!");
		}
		else if (elements.get(wood[start.getY()][start.getX()]) == '1') {
			throw new Exception("не могу создать вудмана в стене!");
		}
		woodmans.put(name,new TheWoodman(name, start));
	}

	@Override
	public Action move(String name, Direction direction) throws Exception {
		TheWoodman currentWoodman = woodmans.get(name);
		if (currentWoodman == null) {
			return Action.WoodmanNotFound;
		} 
		Point newPosition = currentWoodman.GetLocation();
		Action currentAction;
		
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
			break;
		case Right:
			newPosition = newPosition.MoveRight();
			break;
		default:
			break;
		}
		if ((newPosition.getX() < 0)||(newPosition.getX() >= wood[0].length)||
		    (newPosition.getY() < 0)||(newPosition.getY() >= wood.length)) {
			throw new Exception("вышли за границы игрового мира!");
		}

		switch(elements.get(wood[newPosition.getY()][newPosition.getX()])) {
		
		case '1'	:
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
			throw new Exception("неопознанная клетка!");
		}
		if ((currentAction == Action.Fail)||(direction == Direction.None)) {
			if (elements.get(wood[currentWoodman.GetLocation().getY()][currentWoodman.GetLocation().getX()]) == 'K') {
				if(currentWoodman.Kill()) {
					currentAction = Action.Dead;
				}
				else {
					currentAction = Action.WoodmanNotFound;
				}
			}
			else if (elements.get(wood[currentWoodman.GetLocation().getY()][currentWoodman.GetLocation().getX()]) == 'L') {
				currentWoodman.AddLife();
				currentAction = Action.Life;
			}
		}
		return currentAction;
	}
	
	public boolean equalsOfWoods(TheWood eqWood) {
		for (int i = 0; i < wood.length; i++) {
			for (int j = 0; j < wood[0].length; j++) {
				if (elements.get(wood[i][j]) != elements.get(eqWood.wood[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
}
