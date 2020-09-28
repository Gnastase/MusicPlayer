package PrimulExercitiu.Injection.Movie;


import PrimulExercitiu.domain.Model.Movie;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = MovieModule.class)
public interface MovieComponent {

    Movie buildMovie();

}
