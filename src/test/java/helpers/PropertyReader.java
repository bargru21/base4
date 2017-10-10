package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Bartek on 2017-10-10.
 */
public class PropertyReader {

    public Properties property() {
        Properties props = new Properties();
        try {
            FileReader reader = new FileReader("src/test/java/properties/creds.properties");
            props.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
