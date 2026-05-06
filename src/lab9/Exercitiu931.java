package lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Exercitiu931 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = random.ints(10, 5, 26).boxed().collect(Collectors.toList());
        System.out.println("lista cu numere: " + numbers);

        //a
        int suma = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("suma  " + suma);

        //b
        int max = numbers.stream().max(Comparator.naturalOrder()).get();
        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("nr max: " + max + ", nr min: " + min);

        //c
        List<Integer> filtered = numbers.stream().filter(n -> n >= 10 && n <= 20).collect(Collectors.toList());
        System.out.println("numerele din lista intre 10 si 20: " + filtered);

        //d
        List<Double> doubleList = numbers.stream().map(n -> n.doubleValue()).collect(Collectors.toList());
        System.out.println("lista double: " + doubleList);

        //e
        boolean exista12 = numbers.stream().anyMatch(n -> n == 12);
        System.out.println("exista 12 in lista ? : " + exista12);


    }


}
