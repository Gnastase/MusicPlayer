package PrimulExercitiu.Injection.Piesa;

import dagger.Module;
import dagger.Provides;
import PrimulExercitiu.Common.DataSource;


@Module
public class PiesaModule {

    @Provides
    String provideNume(){
        return DataSource.GetAName();
    }
    @Provides
    Float provideDurata(){
        return DataSource.getADuration();
    }

    @Provides
    Boolean provideFlag(){
        return DataSource.getABoolean();
    }
}
