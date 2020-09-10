package ex1;

public class Piesa {

    @Override
    public String toString() {
        return "Piesa{" +
                "nume='" + nume + '\'' +
                '}';
    }


    public String getNume() {
        return nume;
    }


    public float getDurata() {
        return durata;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Piesa setFlagStream(boolean flag){
        this.flag = flag;

        return this;
    }

    private final String   nume;
    private final float    durata;
    private boolean  flag;

    public Piesa(String nume, float durata, Boolean flag) {
        this.nume    = nume;
        this.durata  = durata;
        this.flag    = flag;
    }


}
