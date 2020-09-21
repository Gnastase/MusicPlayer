package ex1.Movie;


import ex1.Author.Author;
import ex1.Piesa.Piesa;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Inject;

@NoArgsConstructor
@Data
public class Movie extends Piesa {

    private Author autor;

    @Inject
    public Movie(String nume, Float durata, Boolean flag, Author author) {
        super(nume, durata, flag);
        autor = author;


    }




}
