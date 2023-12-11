package films.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javafx.scene.image.Image;

public class GetFilmDetailsService extends Service {

  private HttpRequest request;

  public GetFilmDetailsService(String id) {
    URI uri = getBaseUrl().addParam("i", id).toUri();
    request = getDefaultRequestBuilder().GET().uri(uri).build();
  }

  public String send() {
    HttpResponse<String> response;
    try {
      response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    if (response.statusCode() != 200) {
      throw new RuntimeException(
          String.format(
              "Request failed with status code %d: %s", response.statusCode(), response.body()));
    }

    return response.body();
  }
}
