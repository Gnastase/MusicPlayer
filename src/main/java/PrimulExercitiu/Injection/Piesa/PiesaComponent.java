package PrimulExercitiu.Injection.Piesa;

import PrimulExercitiu.domain.Model.Piesa;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = PiesaModule.class)
public interface PiesaComponent {


    Piesa buildPiesa();

}
