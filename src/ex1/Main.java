package ex1;

import java.lang.reflect.Array;
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
                                             <? super ex1.Movie> pred){
        System.out.println();
        System.out.println("showMeTheMoviesWhich");

        ArrayList<Movie> movies = Helper.getMovieList();


        Helper.showMeList(new ArrayList<Movie>(movies.stream()
                .filter(pred)
                .collect(Collectors.toList()))); // este ok asa ?

    }

    static <T extends Piesa> void showMeThePlayed(ArrayList<T> list){

        System.out.println();
        System.out.println("showMeThePlayed");

        HashSet<T> ascultate = new HashSet<>(PlayerStream.filter(list));


        for (T elem : ascultate) {
            System.out.println(elem.toString());
        }
    }
    static void letTheShowStart(ArrayList<Piesa> songs, ArrayList<Movie> movies,HashMap<Piesa, Integer> historyMap ){
        System.out.println();
        System.out.println("letTheShowStart");

        PlayerStream.resetStreams(songs);
        Player.resetPlays(movies);

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

    static <T extends  Piesa>  void showMeTheTimeSpent(ArrayList<T> list,HashMap<Piesa, Integer> historyMap){/// dece nu merge la HashMap tot nu T



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

    public static void main (String[] args) {

        ArrayList<Piesa> songs = Helper.getPlaylist();
        ArrayList<Movie> movies = Helper.getMovieList();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();


        letTheShowStart(songs,movies,historyMap);
        showMeTheCounts(historyMap);
        showMeTheTimeSpent(movies,historyMap); // dece nu merge sa ii dau lafel cu T la ambele, chiar daca sunt diferite, mostenesc aceeasi clasa
        showMeTheMoviesWhich(Movie::getFlag);

        showMeTheMusicAssigment(songs,movies);

        showMeThePlayed(songs);

        Helper.sortMeTheList(songs);

        showMeThePlayed(songs);




    }
}


