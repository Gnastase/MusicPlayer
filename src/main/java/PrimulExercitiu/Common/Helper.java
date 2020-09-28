package PrimulExercitiu.Common;


import PrimulExercitiu.Infracstructure.io.File.DataSourceFilesAdapter;
import PrimulExercitiu.Infracstructure.io.Memory.DataSourceMemoryAdapter;
import PrimulExercitiu.Injection.Movie.DaggerMovieComponent;
import PrimulExercitiu.domain.Model.Movie;
import PrimulExercitiu.Injection.Movie.MovieComponent;
import PrimulExercitiu.Injection.Piesa.DaggerPiesaComponent;
import PrimulExercitiu.domain.Model.Piesa;
import PrimulExercitiu.Injection.Piesa.PiesaComponent;
import PrimulExercitiu.domain.Connector.DataSourceIOConnector;
import PrimulExercitiu.domain.Player.Player;
import PrimulExercitiu.domain.Player.PlayerStream;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static io.vavr.API.$;

@NoArgsConstructor
public class Helper {

    public static Source source = Source.MEMORY;

    public static DataSourceIOConnector getSource() {

        if (source == Source.MEMORY){
            return new DataSourceMemoryAdapter();
        } else{
            return  new DataSourceFilesAdapter();
        }

    }

    public static <T extends  Piesa> void showMeList(List<T> list){

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

        return piese.get(rand.nextInt((int) length));


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

    public static void showMeTheMusicAssigment(ArrayList<Piesa> songs, ArrayList<Movie> movies){

        System.out.println();
        System.out.println("showMeTheMusicAssigment");

        HashMap<Movie, HashSet<Piesa>> contentList = Helper.assignMusic(songs,movies);

        Helper.showMovieSong(Helper.getRandomElement(movies),contentList);
    }

    public static void showMeTheMoviesWhich(Predicate
                                                    <? super Movie> pred){
        System.out.println();
        System.out.println("showMeTheMoviesWhich");

        ArrayList<Movie> movies = Helper.getMovieList();

        Helper.showMeList(movies.stream()
                .filter(pred)
                .collect(Collectors.toList()));

    }

    public static <T extends Piesa> void showMeThePlayed(ArrayList<T> list){

        System.out.println();
        System.out.println("showMeThePlayed");

        HashSet<T> ascultate = new HashSet<>(PlayerStream.filter(list));


        for (T elem : ascultate) {
            System.out.println(elem.toString());
        }
    }
    public static void
    letTheShowStart(ArrayList<Piesa> songs, ArrayList<Movie> movies, HashMap<Piesa, Integer> historyMap){
        System.out.println();
        System.out.println("letTheShowStart");

        //astea 2 ruleaza in pararel
        PlayerStream.resetStreams(songs);
        Player.resetPlays(movies);
        //dupa ce ambele sunt complete incepe asta
        Player.playSomething(25,songs,historyMap);
        Player.playSomething(2,movies,historyMap);



    }

    public static void showMeTheCounts(HashMap<Piesa, Integer> historyMap){
        System.out.println();
        System.out.println("showMeTheCounts");


        for (Map.Entry<Piesa, Integer> entry : historyMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    public static < T extends Piesa>  void showMeTheTimeSpent(ArrayList<T> list, HashMap<? extends Piesa, Integer> historyMap){/// de ce nu merge la HashMap tot nu T



        System.out.println();
        System.out.println("showMeTheTimeSpent");

        System.out.println();
        System.out.println("Total Time of content");

        System.out.println(Player.totalDurations(list));
        System.out.println(PlayerStream.totalDurationsStream(list));

        System.out.println();
        System.out.println("Total time spent on content");

        System.out.println(Player.timeSpent(list,historyMap));
        System.out.println(PlayerStream.timeSpentStream(list,historyMap));

    }

}
