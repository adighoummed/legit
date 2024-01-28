import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties;

    private static void initConfig(){
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties(){
        if (properties == null)
            initConfig();
        return properties;
    }
}
