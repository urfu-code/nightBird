package WoodEngine;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Создатель леса
 */
public interface IWoodLoader {
	/**
	 * Создает экземпляр леса по данным из потока.
	 * @param stream поток с информацией о лесе.
	 * @return Лес
	 * @throws UnsupportedEncodingException 
	 * @throws IOException 
	 */
	IWood Load(InputStream stream) throws UnsupportedEncodingException, IOException;
}
