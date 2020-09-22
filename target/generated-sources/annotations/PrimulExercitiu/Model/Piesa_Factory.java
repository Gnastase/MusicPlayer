package PrimulExercitiu.Model;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Piesa_Factory implements Factory<Piesa> {
  private final Provider<String> nameProvider;

  private final Provider<Float> iProvider;

  private final Provider<Boolean> bProvider;

  public Piesa_Factory(
      Provider<String> nameProvider, Provider<Float> iProvider, Provider<Boolean> bProvider) {
    this.nameProvider = nameProvider;
    this.iProvider = iProvider;
    this.bProvider = bProvider;
  }

  @Override
  public Piesa get() {
    return provideInstance(nameProvider, iProvider, bProvider);
  }

  public static Piesa provideInstance(
      Provider<String> nameProvider, Provider<Float> iProvider, Provider<Boolean> bProvider) {
    return new Piesa(nameProvider.get(), iProvider.get(), bProvider.get());
  }

  public static Piesa_Factory create(
      Provider<String> nameProvider, Provider<Float> iProvider, Provider<Boolean> bProvider) {
    return new Piesa_Factory(nameProvider, iProvider, bProvider);
  }

  public static Piesa newPiesa(String name, Float i, boolean b) {
    return new Piesa(name, i, b);
  }
}
