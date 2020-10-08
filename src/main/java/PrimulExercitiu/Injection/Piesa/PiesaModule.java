package PrimulExercitiu.Injection.Piesa;

import PrimulExercitiu.Common.Helper;
import PrimulExercitiu.domain.Connector.DataSourceIOConnector;
import dagger.Module;
import dagger.Provides;


@Module
public class PiesaModule {

    DataSourceIOConnector source = Helper.getSource();

    @Provides
    String provideNume(){
        return source.getAName();
    }
    @Provides
    Float provideDurata(){
        return source.getADuration();
    }

    @Provides
    Boolean provideFlag(){
        return source.getABoolean();
    }
}
