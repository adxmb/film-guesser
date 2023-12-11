package films.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

  private static final String CONFIG_LOCATION = ".env";

  public static void read() {
    System.out.println("Loading config file at " + CONFIG_LOCATION);
    InputStream inputStream = tryGetFile(CONFIG_LOCATION);
    tryLoadProperties(inputStream);
    tryCloseFile(inputStream);
  }

  private static InputStream tryGetFile(String location) {
    try {
      return Config.class.getResource(location).openStream();
    } catch (IOException e) {
      throw new RuntimeException("Failed to find config file at " + location);
    }
  }

  private static void tryLoadProperties(InputStream inputStream) {
    try {
      Properties properties = new Properties();
      properties.load(inputStream);
      System.getProperties().putAll(properties); // Add .env properties to environmental variables
    } catch (IOException e) {
      throw new RuntimeException("Failed to read config file at " + CONFIG_LOCATION, e);
    }
  }

  private static void tryCloseFile(InputStream inputStream) {
    try {
      inputStream.close();
    } catch (IOException e) {
      throw new RuntimeException("Failed to close config file at " + CONFIG_LOCATION, e);
    }
  }
}
