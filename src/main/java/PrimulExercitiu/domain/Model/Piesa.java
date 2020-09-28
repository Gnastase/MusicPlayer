package PrimulExercitiu.domain.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;


@NoArgsConstructor
@Data
public class Piesa {

    private  String   nume;
    private  Float    durata;
    private boolean  flag;

    @Inject
    public Piesa(String name, Float i, boolean b) {
        nume = name;
        durata = i;
        flag = b;
    }

    public Piesa setFlagStream(boolean flag){
        this.flag = flag;
        return this;
    }

    public boolean getFlag() {
        return flag;
    }
}
