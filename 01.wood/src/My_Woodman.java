
public class My_Woodman implements Woodman{

		public String name;
		private final Point Start;
		private final Point Finish;
		private Point current;
		private int life;
		
		public My_Woodman(String name2, Point start, Point finish) {
		life = 3;
		name = name2;
		Start = start;
		current = start;
		Finish = finish;
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
		return current;
			}

	@Override
	public void SetLocation(Point location) {
		current = location;
	}

	@Override
	public void MoveToStart() {
		current = Start;
	}


	public void GetFinish() {
		current = Finish;
	}
}