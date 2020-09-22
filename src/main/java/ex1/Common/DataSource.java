package ex1.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataSource {

   static private <T extends Object> T getRandomItem(List<T> list){
        Random rand = new Random();
        long length = list.stream().count();

        return list.get(rand.nextInt((int) length));
    }

    static public String GetAName(){
        List<String> list = List
                .of("Test1","Test2","Test3","Test4");

        return getRandomItem(list);

    }

    static public  Float getADuration(){
        List<Float> list = List
                .of(100f,200f,300f);

        return getRandomItem(list);
    }

    static public Boolean getABoolean(){
        List<Boolean> list = List
                .of(true,false);

        return getRandomItem(list);
    }
}
