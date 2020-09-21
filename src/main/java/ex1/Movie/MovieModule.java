package ex1.Movie;


import dagger.Module;
import dagger.Provides;
import ex1.Author.ArtistComponent;
import ex1.Author.Author;
import ex1.Author.DaggerArtistComponent;
import ex1.Common.DataSource;

import javax.xml.crypto.Data;

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
