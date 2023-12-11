package films.objects;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Url {
  private String base;
  private Map<String, String> params = new HashMap<>();

  public Url(String baseUrl) {
    this.base = cleanUrl(baseUrl);
  }

  private String cleanUrl(String url) {
    if (url == null || url.isEmpty()) {
      throw new IllegalArgumentException("baseUrl cannot be null or empty");
    }

    if (!url.endsWith("/")) {
      url += "/";
    }

    return url;
  }

  public Url addParam(String key, String value) {
    this.params.put(key, value);
    return this;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder(this.base);
    sb.append("?");

    for (Entry<String, String> entry : this.params.entrySet()) {
      sb.append(entry.getKey());
      sb.append("=");
      sb.append(entry.getValue());
      sb.append("&");
    }

    return sb.toString();
  }

  public URI toUri() {
    return URI.create(this.toString());
  }
}
