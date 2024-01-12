package films.objects.json;

import films.objects.MovieGenerator;
import films.services.GetFilmDetailsByNameService;

public class FilmInfo {
  private String title;
  private String year;
  private String rated;
  private String released;
  private String runtime;
  private String genre;
  private String directors;
  private String writers;
  private String cast;

  private String posterURL;

  /**
   * Creates a FilmInfo object from a JSON string. Extracts the relavent data from the JSON string
   * into the fields of the FilmInfo object. Formats the JSON by separating the fields by commas and
   * removing the quotation marks.
   *
   * @param json The JSON string to extract the data from.
   */
  public FilmInfo(String json) {
    // Note: This may need to be changed for film titles with weird syntaxs
    String[] information = json.split("\",\"");
    if (information.length < 14) {
      throw new IllegalArgumentException(
          "Missing field: " + information.length + "/14 fields were provided");
    }
    setFields(information);
  }

  /**
   * Sets the correctly formatted fields of the FilmInfo object from the information from the JSON.
   *
   * @param information The split information from the JSON string.
   */
  private void setFields(String[] information) {
    this.title = format(information[0]);
    this.year = format(information[1]);
    this.rated = format(information[2]);
    this.released = format(information[3]);
    this.runtime = format(information[4]);
    this.genre = format(information[5]);
    this.directors = format(information[6]);
    this.writers = format(information[7]);
    this.cast = format(information[8]);
    
    // Not information to be provided to the user during the game, but when they get a result
    this.posterURL = format(information[13]);
  }

  /**
   * Formats the field by removing the quotation marks and extracting the information instead of the
   * type of information. This is done because we already know what type of information it is from
   * the index of the information array it was fetched from.
   *
   * @param field The field to format.
   * @return The formatted field.
   */
  private String format(String field) {
    if (field.equals("N/A")) {
      throw new IllegalArgumentException("Missing field: field was N/A");
    }
    return field.replaceAll("\"", "").split(":")[1];
  }

  /**
   * @return The title of the film.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @return The year the film was released.
   */
  public String getYear() {
    return this.year;
  }

  /**
   * @return The rating of the film.
   */
  public String getRated() {
    return this.rated;
  }

  /**
   * @return The date the film was released.
   */
  public String getReleased() {
    return this.released;
  }

  /**
   * @return The runtime of the film.
   */
  public String getRuntime() {
    return this.runtime;
  }

  /**
   * @return The genre of the film.
   */
  public String getGenre() {
    return this.genre;
  }

  /**
   * @return The directors of the film.
   */
  public String getDirectors() {
    return this.directors;
  }

  /**
   * @return The writers of the film.
   */
  public String getWriters() {
    return this.writers;
  }

  /**
   * @return The lead actors/actresses of the film.
   */
  public String getCast() {
    return this.cast;
  }

  /**
   * @return The URL of the poster of the film.
   */
  public String getPosterURL() {
    return this.posterURL;
  }
}
