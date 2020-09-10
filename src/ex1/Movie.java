package ex1;

public class Movie extends Piesa{

    private final String  autor;

    public Movie(String nume, float durata, Boolean flag, String autor1) {
        super(nume, durata, flag);
        this.autor = autor1;

    }

    @Override
    public String toString() {
        return "Movie{" +
                "autor='" + autor + '\'' +
                '}';
    }


}
