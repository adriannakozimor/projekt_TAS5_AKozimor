package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/testdata.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Nie udało się załadować pliku properties!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
