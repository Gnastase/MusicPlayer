package ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PlayerStream  {


    static <T extends  Piesa> ArrayList<T> filter(ArrayList<T> input){

        return (ArrayList<T>) input
                .stream()
                .filter(Piesa::getFlag)
                .collect(Collectors.toList());
    }

    static <T extends  Piesa> void resetStreams(ArrayList<T> input){ // alta abordare ?
        input = (ArrayList<T>) input
                .stream()
                .map(piesa -> piesa.setFlagStream(false))
                .collect(Collectors.toList());
    }

    static <T extends  Piesa> float totalDurationsStream(ArrayList<T> input){

        return input
                .stream()
                .reduce(0f,(subtotal, element) -> subtotal + element.getDurata(), Float::sum);
    }

    static <T extends  Piesa> float timeSpentStream(ArrayList<T> input, HashMap<Piesa, Integer> historyMap){

        return input
                .stream()
                .filter(historyMap::containsKey)
                .reduce(0f, (subtotal, element) -> subtotal + (element.getDurata() * historyMap.get(element)), (a,b) -> a+b); // de cee imi trebe composer ca sa permite tipuri de date diferite
    }
}
