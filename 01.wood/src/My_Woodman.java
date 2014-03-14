
public class My_Woodman implements Woodman {

	private int life; 
	private String name; 
	private final Point Start; 
	public Point currentPosition; //текущее местоположение
	
	public My_Woodman(String my_name, Point start){
		name = my_name;
		Start = start;
		life = 3;
		currentPosition = Start;
	}
	
	@Override
	public int GetLifeCount() {
		return life;
	}

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public boolean Kill() {
		life--;
		if (life > -1)
			return true;
		else
			return false;
	}

	@Override
	public void AddLife() {
		life++;
	}

	@Override
	public Point GetLocation() {
		return currentPosition;
	}

	@Override
	public void SetLocation(Point location) {
		currentPosition = location;
	}

	@Override
	public void MoveToStart() {
		currentPosition = Start;

	}

}
