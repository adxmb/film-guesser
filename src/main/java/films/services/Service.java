package films.services;

import films.objects.Url;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Service {
  private static final Duration REQUEST_TIMEOUT = Duration.ofMillis(10000);
  private static final String BASE_URL = "http://www.omdbapi.com/";
  private HttpRequest request;

  protected Url getBaseUrl() {
    Url url = new Url(BASE_URL).addParam("apikey", System.getProperty("API_KEY"));
    return url;
  }

  protected Builder getDefaultRequestBuilder() {
    return HttpRequest.newBuilder().timeout(REQUEST_TIMEOUT);
  }

  protected void setRequest(Builder builder) {
    this.request = builder.build();
  }

  public String send() {
    List<Exception> exceptions = new ArrayList<>();

    // Try three times
    for (int i = 0; i < 3; i++) {
      try {
        return sendAndReturnBody();
      } catch (Exception e) {
        exceptions.add(e);
      }
    }

    throw new RuntimeException(exceptions.get(0));
  }

  private String sendAndReturnBody() throws IOException, InterruptedException {
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());

    if (response.statusCode() == 200) {
      return response.body();
    } else {
      throw new RuntimeException(
          String.format(
              "Request failed with status code %d: %s", response.statusCode(), response.body()));
    }
  }
}
