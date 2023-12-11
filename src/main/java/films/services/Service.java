package films.services;

import films.objects.Url;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.time.Duration;

public abstract class Service {
  private static final Duration REQUEST_TIMEOUT = Duration.ofMillis(10000);
  private static final String BASE_URL = "http://www.omdbapi.com/";

  protected Url getBaseUrl() {
    Url url = new Url(BASE_URL).addParam("apikey", System.getProperty("API_KEY"));
    return url;
  }

  protected Duration getTimeout() {
    return REQUEST_TIMEOUT;
  }

  protected Builder getDefaultRequestBuilder() {
    return HttpRequest.newBuilder().timeout(getTimeout());
  }
}
