package PrimulExercitiu.Injection.Movie;


import PrimulExercitiu.Injection.Artist.ArtistComponent;
import PrimulExercitiu.Injection.Artist.DaggerArtistComponent;
import dagger.Module;
import dagger.Provides;
import PrimulExercitiu.Model.Author;
import PrimulExercitiu.Common.DataSource;

@Module
public class MovieModule {

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

    @Provides
    Author provideAuthor(){

        ArtistComponent artistComponent = DaggerArtistComponent.create();
        return  artistComponent.giveMeALegend();

    }


}
