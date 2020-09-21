package ex1.Common;


import ex1.Movie.DaggerMovieComponent;
import ex1.Movie.Movie;
import ex1.Movie.MovieComponent;
import ex1.Piesa.DaggerPiesaComponent;
import ex1.Piesa.Piesa;
import ex1.Piesa.PiesaComponent;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Helper {

    public static <T extends  Piesa> void showMeList(ArrayList<T> list){

        list
                .stream()
                .forEach(System.out::println);

    }

    public static <T extends  Piesa> void sortMeTheList(ArrayList<T> list){

        Helper.showMeList(new ArrayList<>(list
                .stream()
                .sorted(Comparator.comparing(Piesa::getNume))
                .collect(Collectors.toList())));

    }

    public static <T extends  Piesa> T getRandomElement(ArrayList<T> piese){

        Random rand = new Random();
        long length = piese.stream().count();

        return piese.get(rand.nextInt((int) length - 1));


    }

    static <T extends Piesa> HashSet<T> generateHashSet(ArrayList<T> piese){

        Random rand = new Random();
        HashSet<T> set = new HashSet<>();


        for (int i=0; i<5; i++) {
            set.add(getRandomElement(piese));
        }

        return set;
    }

    public static ArrayList<Piesa> getPlaylist(){

        ArrayList<Piesa> piese = new ArrayList<>();

        PiesaComponent piesaComponent = DaggerPiesaComponent.create();

        for (int i=0; i<5; i++) {
           piese.add(piesaComponent.buildPiesa());
        }

        return piese;
    }

    public static ArrayList<Movie> getMovieList(){

        ArrayList<Movie> filme = new ArrayList<>();

        MovieComponent movieComponent = DaggerMovieComponent.create();

        for(int i=0;i<4;i++){
            filme.add(movieComponent.buildMovie());
        }


        return filme;
    }

    public static HashMap<Movie, HashSet<Piesa>> assignMusic(ArrayList<Piesa> piese, ArrayList<Movie> filme){

        HashMap<Movie, HashSet<Piesa>> contentMap = new HashMap<>();

        filme
                .stream()
                .forEach(p-> contentMap.put(p,generateHashSet(piese)));

        return  contentMap;
    }

    public static void showMovieSong(Movie movie, HashMap<Movie, HashSet<Piesa>> map){

        System.out.println(movie);
        Optional<HashSet<Piesa>> playlist = Optional.ofNullable(map.get(movie));
        playlist.ifPresent(content -> content
                .forEach(System.out::println));
    }
}
