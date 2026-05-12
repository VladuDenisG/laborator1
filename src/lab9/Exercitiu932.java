package lab9;

import java.util.*;
import java.util.stream.Collectors;

public class Exercitiu932 {
    public static void main(String[] args) {
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        //a
        List<String> lungi = cuvinte.stream().filter(c -> c.length() >= 5).collect(Collectors.toList());
        System.out.println("cuvinte cu mai mult de 4 caractere" + lungi);
        System.out.println("numarul lor " + lungi.size());

        //b
        List<String> ordonate = lungi.stream().sorted().collect(Collectors.toList());
        System.out.println("lista ordonata: " + ordonate);

        //c
        cuvinte.stream().filter(c -> c.startsWith("p")).findFirst()
                .ifPresent(c -> System.out.println("Element care incepe cu 'p': " + c));
    }
}