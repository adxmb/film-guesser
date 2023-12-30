package films.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import films.services.GetFilmDetailsService;
import films.services.GetTop100MoviesService;
import films.util.Config;

import org.junit.jupiter.api.Test;

public class ServiceTests {

  @Test
  public void testGetFilmDetailsService() {
    Config.read();
    String expectedJson = TestUtils.readFile("expectedGetFilmDetailsService.json");
    String actualJson = new GetFilmDetailsService("tt0111161").send();
    TestUtils.assertEqualsIgnoreWhitespace(expectedJson, actualJson);
  }

  @Test
  public void testGetTop100MoviesService() {
    Config.read();
    String expectedJson = TestUtils.readFile("expectedGetTop100MoviesService.json");
    String actualJson = new GetTop100MoviesService().send();
    TestUtils.assertEqualsIgnoreWhitespace(expectedJson, actualJson);
  }
}
