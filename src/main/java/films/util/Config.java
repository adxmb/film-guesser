package films.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import films.Main;

public class Config {

  private static final Path CONFIG_LOCATION = Paths.get(".env").toAbsolutePath();

  public static void read() {
    try {
      Console.log("\nAttempting to load config file at '" + CONFIG_LOCATION + "'...");
      InputStream inputStream = tryGetFile(CONFIG_LOCATION);
      tryLoadProperties(inputStream);
      tryCloseFile(inputStream);
      Console.success("Successfully loaded config file at '" + CONFIG_LOCATION + "'!");
    } catch (RuntimeException e) {
      Console.error(e.getMessage() + ". Quitting...");
      Main.stopApp();
    }
  }

  private static InputStream tryGetFile(Path location) {
    try {
      return Files.newInputStream(location);
    } catch (IOException e) {
      throw new RuntimeException("Failed to find config file at '" + location + "'", e);
    }
  }

  private static void tryLoadProperties(InputStream inputStream) {
    try {
      Properties properties = new Properties();
      properties.load(inputStream);
      System.getProperties().putAll(properties); // Add .env properties to environmental variables
    } catch (IOException e) {
      throw new RuntimeException("Failed to read config file at '" + CONFIG_LOCATION + "'", e);
    }
  }

  private static void tryCloseFile(InputStream inputStream) {
    try {
      inputStream.close();
    } catch (IOException e) {
      throw new RuntimeException("Failed to close config file at '" + CONFIG_LOCATION + "'", e);
    }
  }
}
