package films.services;

import java.net.URI;

public class GetTop100MoviesService extends Service {
  private static final URI LOCATION =
      URI.create(
          "https://raw.githubusercontent.com/hjorturlarsen/IMDB-top-100/master/data/movies.json");

  public GetTop100MoviesService() {
    setRequest(getDefaultRequestBuilder().GET().uri(LOCATION));
  }
}
