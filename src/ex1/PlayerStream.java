package ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PlayerStream  {


    static ArrayList<Piesa> filter(ArrayList<Piesa> input){

        return (ArrayList<Piesa>) input
                .stream()
                .filter(Piesa::getFlag)
                .collect(Collectors.toList());
    }

    static void resetStreams(ArrayList<Piesa> input){
        input = (ArrayList<Piesa>) input
                .stream()
                .map(piesa -> piesa.setFlagStream(false))
                .collect(Collectors.toList());
    }

    static float totalDurationsStream(ArrayList<Piesa> input){

        return input
                .stream()
                .reduce(0f,(subtotal, element) -> subtotal + element.getDurata(), Float::sum);
    }

    static float timeSpentStream(ArrayList<Piesa> input, HashMap<Piesa, Integer> historyMap){

        return input
                .stream()
                .filter(historyMap::containsKey)
                .reduce(0f, (subtotal, element) -> subtotal + (element.getDurata() * historyMap.get(element)), (a,b) -> a*b); // de cee
    }
}
