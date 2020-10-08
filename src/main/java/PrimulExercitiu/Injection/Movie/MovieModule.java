package PrimulExercitiu.Injection.Movie;


import PrimulExercitiu.Common.Helper;
import PrimulExercitiu.Injection.Artist.ArtistComponent;
import PrimulExercitiu.Injection.Artist.DaggerArtistComponent;
import PrimulExercitiu.domain.Connector.DataSourceIOConnector;
import dagger.Module;
import dagger.Provides;
import PrimulExercitiu.domain.Model.Author;

@Module
public class MovieModule {

    DataSourceIOConnector source = Helper.getSource();

    @Provides
    String provideNume(){ return source.getAName(); }

    @Provides
    Float provideDurata(){
        return source.getADuration();
    }

    @Provides
    Boolean provideFlag(){
        return source.getABoolean();
    }

    @Provides
    Author provideAuthor(){

        ArtistComponent artistComponent = DaggerArtistComponent.create();
        return  artistComponent.giveMeALegend();

    }


}
