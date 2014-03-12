package WoodEngine;



public interface IWood {
	/**
	 * Создает нового лесного жителя.
	 * 
	 * @param name имя лесного жителя
	 * @param start место появления
	 * @throws Exception 
	 */
	void createWoodman(String name, Point start) throws Exception;
	
	/**
	 * Перемещает лесного жителя.
	 * 
	 * @param name имя лесного жителя
	 * @param direction направление перемещения
	 * @return результат перемещения
	 */
	Action move(String name, Direction direction);
}
