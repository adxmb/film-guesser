package films.services;

import films.objects.Url;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

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
