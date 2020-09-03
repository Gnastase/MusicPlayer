package ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Player {

    static ArrayList<Piesa> filter(ArrayList<Piesa> input){

        ArrayList<Piesa> pieseLocal = new ArrayList<>();

        for(Piesa var : input){
            if(var.getFlag()){
                pieseLocal.add(var);
            }
        }
        return pieseLocal;
    }



    static void playSong(ArrayList<Piesa> input,int songNumber,HashMap<Piesa, Integer> historyMap){
        input.get(songNumber).setFlag(true);

        if (null != historyMap.get(input.get(songNumber))){
            historyMap.replace(input.get(songNumber),historyMap.get(input.get(songNumber)) + 1);
        }else{
            historyMap.put(input.get(songNumber),1);
        }
    }

    static void resetPlays(ArrayList<Piesa> input){

        ArrayList<Piesa> piese = new ArrayList<>();
        for(Piesa var: input){
            var.setFlag(false);
            piese.add(var);
        }


    }




    static void playSomething(int howMany,ArrayList<Piesa> input, HashMap<Piesa, Integer> historyMap){

        Random rand = new Random();

        for (int i=0; i<howMany; i++) {
            playSong(input, rand.nextInt(input.size() - 1),historyMap );
        }

    }
   static int totalDurations(ArrayList<Piesa> input){
        int total = 0;

        for(Piesa song: input){
            total += song.getDurata();
        }
        return total;
   }

   static int timeSpent(ArrayList<Piesa> input, HashMap<Piesa, Integer> historyMap){
       int total = 0;

       for(Piesa song: input){

           if (null != historyMap.get(song)){
               total += historyMap.get(song) * song.getDurata();
           }

       }

       return total;
   }


}
