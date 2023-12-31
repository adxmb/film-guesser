package films.services;

import java.net.URI;

public class GetFilmDetailsByIdService extends Service {

  public GetFilmDetailsByIdService(String id) {
    URI uri = getBaseUrl().addParam("i", id).toUri();
    setRequest(getDefaultRequestBuilder().GET().uri(uri));
  }
}
