package films.services;

import films.TestUtils;
import films.util.Config;
import org.junit.jupiter.api.Test;

public class ServiceTests {

  @Test
  public void testGetFilmDetailsService() {
    Config.read();
    String expectedJson = TestUtils.readFile("services/expectedGetFilmDetailsService.json");
    String actualJson = new GetFilmDetailsService("tt0111161").send();
    TestUtils.assertEqualsIgnoreWhitespace(expectedJson, actualJson);
  }

  @Test
  public void testGetTop100MoviesService() {
    Config.read();
    String expectedJson = TestUtils.readFile("services/expectedGetTop100MoviesService.json");
    String actualJson = new GetTop100MoviesService().send();
    TestUtils.assertEqualsIgnoreWhitespace(expectedJson, actualJson);
  }

  @Test
  public void testGetTop1000MoviesService() {
    Config.read();
    String expectedCsv = TestUtils.readFile("services/expectedGetTop1000MoviesService.csv");
    String actualCsv = new GetTop1000MoviesService().send();
    TestUtils.assertEqualsIgnoreWhitespace(expectedCsv, actualCsv);
  }
}
