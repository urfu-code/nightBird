package Exceptions;

import Classes.Point;
/**
 * Клетка занята или игроком, либо в этом месте стена
 * @author Kirill
 *
 */
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
