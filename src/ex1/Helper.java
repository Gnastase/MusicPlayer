package ex1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Helper {

    static <T extends  Piesa> void showMeList(ArrayList<T> list){

        list
                .stream()
                .forEach(System.out::println);

    }

    static <T extends  Piesa> void sortMeTheList(ArrayList<T> list){

        Helper.showMeList(new ArrayList<>(list
                .stream()
                .sorted(Comparator.comparing(Piesa::getNume))
                .collect(Collectors.toList())));

    }

    static <T extends  Piesa> T getRandomElement(ArrayList<T> piese){

        Random rand = new Random();
        long length = piese.stream().count();

        return piese.get(rand.nextInt((int) length - 1));


    }

    static <T extends  Piesa> HashSet<T> generateHashSet(ArrayList<T> piese){

        Random rand = new Random();
        HashSet<T> set = new HashSet<>();


        for (int i=0; i<5; i++) {
            set.add(getRandomElement(piese));
        }

        return set;
    }

    static ArrayList<Piesa> getPlaylist(){

        ArrayList<Piesa> piese = new ArrayList<>();
        piese.add(new Piesa("Mad Quelia",100,false));
        piese.add(new Piesa("Mad Man",233,true));
        piese.add(new Piesa("Mad Soul",345,false));
        piese.add(new Piesa("Happy Quelia",142,false));
        piese.add(new Piesa("Happy Man",354,true));
        piese.add(new Piesa("Happy Soul",123,false));
        piese.add(new Movie("da", 12,true,"AA"));

        return piese;
    }

    static ArrayList<Movie> getMovieList(){

        ArrayList<Movie> filme = new ArrayList<>();

        filme.add(new Movie("Harry Potter 1", 200,true,"Gigi"));
        filme.add(new Movie("Black Man", 150,false,"Bigi"));
        filme.add(new Movie("Oile", 333,true,"Digi"));
        filme.add(new Movie("Motan", 12,true,"GR"));

        return filme;
    }

    static HashMap<Movie, HashSet<Piesa>> assignMusic(ArrayList<Piesa> piese, ArrayList<Movie> filme){

        HashMap<Movie, HashSet<Piesa>> contentMap = new HashMap<>();

        filme
                .stream()
                .forEach(p-> contentMap.put(p,generateHashSet(piese)));

        return  contentMap;
    }

    static void showMovieSong(Movie movie, HashMap<Movie, HashSet<Piesa>> map){

        System.out.println(movie);
        Optional<HashSet<Piesa>> playlist = Optional.ofNullable(map.get(movie));
        playlist.ifPresent(content -> content
                .forEach(System.out::println));
    }
}
