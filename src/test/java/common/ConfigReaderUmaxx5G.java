package common;

import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.Test;

public class ConfigReaderUmaxx5G {

    private static final Properties properties = new Properties();
    
    static {
        // Load properties when class is initialized
        try (InputStream input = ConfigReaderUmaxx5G.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            
            if (input == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String getKeyValue(String key) {
        return properties.getProperty(key);
    }

    @Test
    public void testConfigReader() {
        // TestNG test method to verify configuration
        String browser = getKeyValue("BROWSERNAME");
        System.out.println("Browser from config: " + browser);
        // Add assertions as needed, e.g.:
        // Assert.assertEquals(browser, "chrome");
    }

    public static void main(String[] args) {
        // Standalone test
        System.out.println("Browser: " + getKeyValue("BROWSERNAME"));
    }
}