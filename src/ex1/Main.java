package ex1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


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
        filme.add(new Movie("Black Man", 150,true,"Bigi"));
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
       playlist.ifPresent(content -> content.stream().forEach(System.out::println));
    }



    public static void main (String[] args) {

        ArrayList<Piesa> songs = getPlaylist();
        ArrayList<Movie> movies = getMovieList();
        System.out.println("test1");
        HashMap<Movie, HashSet<Piesa>> contentList = assignMusic(songs,movies);
        showMovieSong(getRandomElement(movies),contentList);

        System.out.println();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();

        Player.resetPlays(songs);
        Player.resetPlays(movies);


        Player.playSomething(25,songs,historyMap);
        Player.playSomething(2,movies,historyMap);

        for (Movie m: movies.stream().filter(m -> m.getFlag()).collect(Collectors.toList())) {
            System.out.println(m.toString());
        }
        System.out.println();

        HashSet<Piesa> ascultate = new HashSet<>(PlayerStream.filter(songs));

        Iterator<Piesa> itr = ascultate.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next().toString());
        }

        System.out.println();
        System.out.println("Counts");


        for (Map.Entry<Piesa, Integer> entry : historyMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        System.out.println();
        System.out.println("Total Time");

        System.out.println(Player.totalDurations(songs));
        System.out.println(PlayerStream.totalDurationsStream(songs));

        System.out.println();
        System.out.println("Total time spent");

        System.out.println(Player.timeSpent(songs,historyMap));
        System.out.println(PlayerStream.timeSpentStream(songs,historyMap));

        for(Piesa song: songs){
            System.out.println(song);
        }

        System.out.println();
        for(Piesa song: songs.stream().sorted(Comparator.comparing(Piesa::getNume)).collect(Collectors.toList())){
            System.out.println(song);
        }



    }
}


