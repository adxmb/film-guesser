package films.services;

import java.net.URI;

public class GetTop1000MoviesService extends Service {
  private static final URI LOCATION =
      URI.create(
          "https://raw.githubusercontent.com/Elliott-dev/Top-1000-IMDB-Rated-Movies-Analysis/main/imdb_top_1000.csv");

  public GetTop1000MoviesService() {
    setRequest(getDefaultRequestBuilder().GET().uri(LOCATION));
  }
}
