package wood01Interfaces;
import java.io.IOException;
import java.io.InputStream;

/**
 * Создатель леса
 */
public interface WoodLoader {
	/**
	 * Создает экземпляр леса по данным из потока.
	 * @param stream поток с информацией о лесе.
	 * @return Лес
	 * @throws IOException 
	 * @throws Exception 
	 */
	Wood Load(InputStream stream) throws IOException, Exception;
}
