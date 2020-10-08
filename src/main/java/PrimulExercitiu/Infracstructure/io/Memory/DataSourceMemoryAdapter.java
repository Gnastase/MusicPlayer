package PrimulExercitiu.Infracstructure.io.Memory;

import PrimulExercitiu.domain.Connector.DataSourceIOConnector;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class DataSourceMemoryAdapter implements DataSourceIOConnector {



   static private <T extends Object> T getRandomItem(List<T> list){
        Random rand = new Random();
        long length = list.stream().count();

        return list.get(rand.nextInt((int) length));
    }
    @Override
     public String getAName(){
        List<String> list = Arrays
                .asList("Test1","Test2","Test3","Test4");

        return getRandomItem(list);

    }
    @Override
    public  Float getADuration(){
        List<Float> list = Arrays
                .asList(100f,200f,300f);

        return getRandomItem(list);
    }
    @Override
     public Boolean getABoolean(){
        List<Boolean> list = Arrays
                .asList(true,false);

        return getRandomItem(list);
    }
}
