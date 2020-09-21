package ex1.Player;

import ex1.Piesa.Piesa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PlayerStream  {


    public static <T extends  Piesa> ArrayList<T> filter(ArrayList<T> input){

        return (ArrayList<T>) input
                .stream()
                .filter(Piesa::getFlag)
                .collect(Collectors.toList());
    }

    public static   <T extends  Piesa> void resetStreams(ArrayList<T> input){ // alta abordare ?

        input = (ArrayList<T>) input
                .stream()
                .map(piesa -> piesa.setFlagStream(false))
                .collect(Collectors.toList());
    }

    public static <T extends  Piesa> float totalDurationsStream(ArrayList<T> input){

        return input
                .stream()
                .reduce(0f,(subtotal, element) -> subtotal + element.getDurata(), Float::sum);
    }

    public static <T extends  Piesa> float timeSpentStream(ArrayList<T> input, HashMap<? extends Piesa, Integer> historyMap){

        return input
                .stream()
                .filter(historyMap::containsKey)
                .reduce(0f, (subtotal, element) -> subtotal + (element.getDurata() * historyMap.get(element)), (a,b) -> a+b);
    }
}
