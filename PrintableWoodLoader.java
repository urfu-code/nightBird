import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class PrintableWoodLoader extends MyWoodLoader {

	
	public PrintableWood PrintableWoodLoad(InputStream inStream, OutputStream outStream) throws CodeException, UnsupportedEncodingException   {
		return new PrintableWood(getWood(inStream), outStream);
	}
}
