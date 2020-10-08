package PrimulExercitiu.Application;

import PrimulExercitiu.Common.Helper;
import PrimulExercitiu.Common.Source;
import PrimulExercitiu.domain.Model.Movie;
import PrimulExercitiu.domain.Model.Piesa;
import PrimulExercitiu.domain.Player.Player;
import PrimulExercitiu.domain.Player.PlayerStream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    private static void runSingleThread(){
        ArrayList<Piesa> songs = Helper.getPlaylist();
        ArrayList<Movie> movies = Helper.getMovieList();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();

        Helper.letTheShowStart(songs,movies,historyMap);

        // test squash

        Helper.showMeTheCounts(historyMap);
        Helper.showMeTheTimeSpent(movies,historyMap);
        Helper.showMeTheMoviesWhich(Movie::getFlag);
        Helper.showMeTheMusicAssigment(songs,movies);
        Helper.showMeThePlayed(songs);


        Helper.sortMeTheList(songs);
        Helper.showMeThePlayed(songs);


    }
    private static void runMultiThread(){
        ArrayList<Piesa> songs = Helper.getPlaylist();
        ArrayList<Movie> movies = Helper.getMovieList();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();

        Helper.letTheShowStart(songs,movies,historyMap);

        Helper.showMeTheCounts(historyMap);
        Helper.showMeTheTimeSpent(movies,historyMap);
        Helper.showMeTheMoviesWhich(Movie::getFlag);
        Helper.showMeTheMusicAssigment(songs,movies);
        Helper.showMeThePlayed(songs);


        Helper.sortMeTheList(songs);
        Helper. showMeThePlayed(songs);

    }
    public static void main (String[] args) {

        Helper.source = Source.FILES;
        runSingleThread();
       // runMultiThread();

    }
}


