package ex1;

import java.util.*;

public class Main {

    static ArrayList<Piesa> getPlaylist(){

        ArrayList<Piesa> piese = new ArrayList<>();
        piese.add(new Piesa("Mad Quelia",100,false));
        piese.add(new Piesa("Mad Man",233,true));
        piese.add(new Piesa("Mad Soul",345,false));
        piese.add(new Piesa("Happy Quelia",142,false));
        piese.add(new Piesa("Happy Man",354,true));
        piese.add(new Piesa("Happy Soul",123,false));

        return piese;
    }



    public static void main (String[] args) {

        ArrayList<Piesa> songs = getPlaylist();
        HashMap<Piesa, Integer> historyMap = new HashMap<>();

        Player.resetPlays(songs);
        Player.playSomething(25,songs,historyMap);

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
    }
}


