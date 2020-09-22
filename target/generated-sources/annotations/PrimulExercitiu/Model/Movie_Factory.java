package PrimulExercitiu.Model;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Movie_Factory implements Factory<Movie> {
  private final Provider<String> numeProvider;

  private final Provider<Float> durataProvider;

  private final Provider<Boolean> flagProvider;

  private final Provider<Author> authorProvider;

  public Movie_Factory(
      Provider<String> numeProvider,
      Provider<Float> durataProvider,
      Provider<Boolean> flagProvider,
      Provider<Author> authorProvider) {
    this.numeProvider = numeProvider;
    this.durataProvider = durataProvider;
    this.flagProvider = flagProvider;
    this.authorProvider = authorProvider;
  }

  @Override
  public Movie get() {
    return provideInstance(numeProvider, durataProvider, flagProvider, authorProvider);
  }

  public static Movie provideInstance(
      Provider<String> numeProvider,
      Provider<Float> durataProvider,
      Provider<Boolean> flagProvider,
      Provider<Author> authorProvider) {
    return new Movie(
        numeProvider.get(), durataProvider.get(), flagProvider.get(), authorProvider.get());
  }

  public static Movie_Factory create(
      Provider<String> numeProvider,
      Provider<Float> durataProvider,
      Provider<Boolean> flagProvider,
      Provider<Author> authorProvider) {
    return new Movie_Factory(numeProvider, durataProvider, flagProvider, authorProvider);
  }

  public static Movie newMovie(String nume, Float durata, Boolean flag, Author author) {
    return new Movie(nume, durata, flag, author);
  }
}
