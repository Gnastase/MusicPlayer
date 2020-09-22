package PrimulExercitiu.Model;


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
