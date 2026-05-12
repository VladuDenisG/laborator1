package lab9;

import java.util.*;
import java.util.stream.Collectors;

public class Exercitiu933 {
    public static void main(String[] args) {
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1,",  10),
                new Student(1029,"Maria","Pana","TI131/2,",  4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2,",  7.33),
                new Student(1029,"Marius","Nasta","TI131/2,",  3.20),
                new Student(1029,"Marius","Nasta","TI131/1,",  5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2,",  2.22)
        );

        // a
        System.out.println("Studenti cu nota 10:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(s -> System.out.println(s.getNume() + " " + s.getPrenume()));

        // b
        System.out.println("\nStudenti cu nota sub 5:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(s -> System.out.println(s.getNume() + " " + s.getPrenume()));

        // c
        List<Student> noteModificate = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4) {
                        return new Student(s.getNrmatricol(), s.getPrenume(), s.getNume(), s.getGrupa(), 4.0);
                    }
                    return s;
                })
                .collect(Collectors.toList());

        // d
        double sumaNote = studentiCuNote.stream()
                .map(Student::getNota)
                .reduce(0.0, Double::sum);

        //e
        double media = sumaNote / studentiCuNote.size();

        System.out.println("\nSuma notelor: " + sumaNote);
        System.out.println("Media notelor: " + media);
    }
}

