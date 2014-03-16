import java.io.FileInputStream;


/**
 * Создатель леса
 */
public interface IWoodLoader {
	/**
	 * Создает экземпляр леса по данным из потока.
	 * @param stream поток с информацией о лесе.
	 * @return Лес
	 */
	Wood Load(FileInputStream stream);
}
