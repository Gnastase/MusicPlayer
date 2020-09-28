package PrimulExercitiu.Injection.Artist;

import PrimulExercitiu.domain.Model.Author;
import dagger.Module;
import dagger.Provides;

@Module
public class ArtistModule {

    @Provides
    public Author provideAuthor(){
        return new Author("Rossi");
    }

}
