package Exceptions;

import Classes.Point;

public class OccupiedLocationException extends Exception {
	private static final long serialVersionUID = 1L;
	private Point m_location;
	public OccupiedLocationException(Point location) {
		m_location = location;
	}
	@Override
	public String getMessage() {
		return "Ячейка"+m_location.toString() +" занята";	
	}
	
}
