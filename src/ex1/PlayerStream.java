package ex1;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerStream  {

    static ArrayList<Piesa> filter(ArrayList<Piesa> input){

        return (ArrayList<Piesa>) input
                .stream()
                .filter(song -> song.getFlag())
                .collect(Collectors.toList());
    }

    static void resetStreams(ArrayList<Piesa> input){
       input = (ArrayList<Piesa>) input
                .stream()
                .map(piesa -> piesa.setFlagStream(false))
                .collect(Collectors.toList());
    }

    static int totalDurationsStream(ArrayList<Piesa> input){

        return 0;
    }

    static int timeSpentStream(ArrayList<Piesa> input){
        return 0;
    }
}
