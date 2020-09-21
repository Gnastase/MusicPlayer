package ex1.Piesa;

import dagger.Module;
import dagger.Provides;
import ex1.Common.DataSource;


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
