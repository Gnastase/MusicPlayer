package ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

 public  class Player {


    static ArrayList<Piesa> filter(ArrayList<Piesa> input){

        ArrayList<Piesa> pieseLocal = new ArrayList<>();

        for(Piesa var : input){
            if(var.getFlag()){
                pieseLocal.add(var);
            }
        }
        return pieseLocal;
    }

    static <T extends Piesa> void playSomething(ArrayList<T> input, int songNumber, HashMap<Piesa, Integer> historyMap){
        input.get(songNumber).setFlag(true);

        if (null != historyMap.get(input.get(songNumber))){
            historyMap.replace(input.get(songNumber),historyMap.get(input.get(songNumber)) + 1);
        }else{
            historyMap.put(input.get(songNumber),1);
        }
    }

    static <T extends Piesa> void resetPlays(ArrayList<T> input){

        ArrayList<T> piese = new ArrayList<>();
        for(Piesa var: input){
            var.setFlag(false);
            piese.add((T) var);
        }


    }

    static <T extends  Piesa> void playSomething(int howMany,ArrayList<T> input, HashMap<Piesa, Integer> historyMap){

        Random rand = new Random();

        for (int i=0; i<howMany; i++) {
            playSomething(input, rand.nextInt(input.size() - 1),historyMap );
        }

    }
   static <T extends Piesa> int totalDurations(ArrayList<T> input){
        int total = 0;

        for(T elem: input){
            total += elem.getDurata();
        }
        return total;
   }

   static <T extends  Piesa> int timeSpent(ArrayList<T> input, HashMap<Piesa, Integer> historyMap){
       int total = 0;

       for(T elem: input){

           if (null != historyMap.get(elem)){
               total += historyMap.get(elem) * elem.getDurata();
           }

       }

       return total;
   }


}
