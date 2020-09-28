package PrimulExercitiu.Infracstructure.io.File;

import PrimulExercitiu.domain.Connector.DataSourceIOConnector;
import lombok.NoArgsConstructor;


import java.io.InputStream;
import java.util.*;

import java.io.*;
import java.util.stream.Collectors;


@NoArgsConstructor
public class DataSourceFilesAdapter implements DataSourceIOConnector {


    static List<String> getResourceFileAsString(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            if (is == null) return null;
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.toList());
            }
        }
    }

    static private <T extends Object> T getRandomItem(List<T> list){
        Random rand = new Random();
        long length = list.stream().count();

        return list.get(rand.nextInt((int) length));
    }


    @Override
    public String GetAName() {
        try {
            return  getRandomItem(getResourceFileAsString("Nume"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "None";
    }
    @Override
    public  Float getADuration() {
        try {
            return  Float.parseFloat(getRandomItem(getResourceFileAsString("Durata")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0f;
    }
    @Override
    public Boolean getABoolean() {
        try {
            return  Boolean.parseBoolean(getRandomItem(getResourceFileAsString("Durata")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
