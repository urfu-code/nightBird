
public class Woodman implements IWoodman {
	protected final String name;
	private int lifeCount;
	private Point lctn;
	private Point start;
	
	Woodman(String name, Point start) {
		this.name = name;
		this.start = this.lctn = start;
		this.lifeCount = 3;
	}
	
	@Override
	public int GetLifeCount() {
		return lifeCount;
	}

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public boolean Kill() {
		lifeCount--;
		if (lifeCount >= 0)
			return true;
		return false;
	}

	@Override
	public void AddLife() {
		lifeCount++;
	}

	@Override
	public Point GetLocation() {
		return lctn;
	}

	@Override
	public void SetLocation(Point location) {
		this.lctn = location;
	}

	@Override
	public void MoveToStart() {
		this.lctn = this.start;

	}
	
	@Override
	public boolean equals(Object woodman) {

		if (woodman == null) {
			return false;
		}

		if (woodman.getClass() != Woodman.class) {
			return false;
		}
		
		Woodman wm = (Woodman) woodman;
		if (wm.GetName() != GetName()) {
			return false;
		}
		
		return true;
	}

}
