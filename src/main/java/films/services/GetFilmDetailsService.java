package films.services;

import java.net.URI;

public class GetFilmDetailsService extends Service {

  public GetFilmDetailsService(String id) {
    URI uri = getBaseUrl().addParam("i", id).toUri();
    setRequest(getDefaultRequestBuilder().GET().uri(uri));
  }
}
