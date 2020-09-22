package PrimulExercitiu;

import PrimulExercitiu.Common.Helper;
import PrimulExercitiu.Model.Movie;
import PrimulExercitiu.Model.Piesa;
import PrimulExercitiu.Player.Player;
import PrimulExercitiu.Player.PlayerStream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    static void showMeTheMusicAssigment(ArrayList<Piesa> songs,ArrayList<Movie> movies){

        System.out.println();
        System.out.println("showMeTheMusicAssigment");

        HashMap<Movie, HashSet<Piesa>> contentList = Helper.assignMusic(songs,movies);

        Helper.showMovieSong(Helper.getRandomElement(movies),contentList);
    }

    static void showMeTheMoviesWhich(Predicate
                                             <? super Movie> pred){
        System.out.println();
        System.out.println("showMeTheMoviesWhich");

        ArrayList<Movie> movies = Helper.getMovieList();

        Helper.showMeList(movies.stream()
                .filter(pred)
                .collect(Collectors.toList()));

    }

    static <T extends Piesa> void showMeThePlayed(ArrayList<T> list){

        System.out.println();
        System.out.println("showMeThePlayed");

        HashSet<T> ascultate = new HashSet<>(PlayerStream.filter(list));


        for (T elem : ascultate) {
            System.out.println(elem.toString());
        }
    }
    static void
    letTheShowStart(ArrayList<Piesa> songs, ArrayList<Movie> movies,HashMap<Piesa, Integer> historyMap ){
        System.out.println();
        System.out.println("letTheShowStart");

        //astea 2 ruleaza in pararel
        PlayerStream.resetStreams(songs);
        Player.resetPlays(movies);
        //dupa ce ambele sunt complete incepe asta
        Player.playSomething(25,songs,historyMap);
        Player.playSomething(2,movies,historyMap);



    }

    static void showMeTheCounts(HashMap<Piesa, Integer> historyMap){
        System.out.println();
        System.out.println("showMeTheCounts");


        for (Map.Entry<Piesa, Integer> entry : historyMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    static < T extends Piesa>  void showMeTheTimeSpent(ArrayList<T> list,HashMap<? extends Piesa , Integer> historyMap){/// de ce nu merge la HashMap tot nu T



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

    public static void runSingleThread(){
        ArrayList<Piesa> songs = Helper.getPlaylist();
        ArrayList<Movie> movies = Helper.getMovieList();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();

        letTheShowStart(songs,movies,historyMap);

        showMeTheCounts(historyMap);
        showMeTheTimeSpent(movies,historyMap);
        showMeTheMoviesWhich(Movie::getFlag);
        showMeTheMusicAssigment(songs,movies);
        showMeThePlayed(songs);


        Helper.sortMeTheList(songs);
        showMeThePlayed(songs);


    }
    public static void runMultiThread(){
        ArrayList<Piesa> songs = Helper.getPlaylist();
        ArrayList<Movie> movies = Helper.getMovieList();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();

        letTheShowStart(songs,movies,historyMap);

        showMeTheCounts(historyMap);
        showMeTheTimeSpent(movies,historyMap);
        showMeTheMoviesWhich(Movie::getFlag);
        showMeTheMusicAssigment(songs,movies);
        showMeThePlayed(songs);


        Helper.sortMeTheList(songs);
        showMeThePlayed(songs);

    }
    public static void main (String[] args) {

        runSingleThread();
       // runMultiThread();

    }
}


