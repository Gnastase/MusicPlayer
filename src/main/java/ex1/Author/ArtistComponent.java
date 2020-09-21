package ex1.Author;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ArtistModule.class)
public interface  ArtistComponent {

    Author giveMeALegend();

}
