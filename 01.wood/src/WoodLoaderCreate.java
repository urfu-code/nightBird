import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Алексей on 28.02.14.
 */
public class WoodLoaderCreate implements WoodLoader {
    @Override
    public Wood Load(InputStream stream) throws IOException {
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {

                strings.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        return new MyWood(strings);
    }

}


