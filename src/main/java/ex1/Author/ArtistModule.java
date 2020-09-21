package ex1.Author;

import dagger.Module;
import dagger.Provides;

@Module
public class ArtistModule {

    @Provides
    public Author provideAuthor(){
        return new Author("Rossi");
    }

}
