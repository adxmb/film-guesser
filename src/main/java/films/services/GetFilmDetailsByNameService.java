package films.services;

import java.net.URI;

public class GetFilmDetailsByNameService extends Service {

  public GetFilmDetailsByNameService(String name) {
    URI uri = getBaseUrl().addParam("t", name.replaceAll("\\s", "%20")).toUri();
    setRequest(getDefaultRequestBuilder().GET().uri(uri));
  }
}
