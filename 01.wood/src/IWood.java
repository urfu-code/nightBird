
public interface IWood {
	
	/**
	 * Создает нового лесного жителя.
	 * 
	 * @param name имя лесного жителя
	 * @param start место появления
	 */
	void createWoodman(String name, Point start);
	
	/**
	 * Перемещает лесного жителя.
	 * 
	 * @param name имя лесного жителя
	 * @param direction направление перемещения
	 * @return результат перемещения
	 */
	Action move(String name, Direction direction);

	/**
	 * 
	 * @param point
	 * @return символ лабиринта в данной точке
	 */
	Character getChar(Point point);

	/**
	 * 
	 * @param name имя вудмана
	 * @return вудмана из списка
	 */
	Woodman getWoodman(String name);

	/**
	 * 
	 * @param symbol символ, на котором стоит указанный вудмен
	 * @param name имя вудмана
	 * @return статус стояния в данной точке лабиринта
	 */
	Action result(Character symbol, String name);
}
