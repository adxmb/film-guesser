package films.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {

  public static void assertEqualsIgnoreWhitespace(String expected, String actual) {
    assertEquals(expected.replaceAll("\\s", ""), actual.replaceAll("\\s", ""));
  }

  public static String readFile(String filename) {
    try {
      URI uri = TestUtils.class.getResource(filename).toURI();
      return new String(Files.readAllBytes(Paths.get(uri)));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
