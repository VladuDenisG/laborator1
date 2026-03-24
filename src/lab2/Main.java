package lab2;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*Student studentul1= new Student("447", "Darius", "Vladescu", "Grupa 22/1");
        System.out.println(studentul1);*/

//PUNCTUL 2.5.1

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++)
            x.add(random.nextInt(11));
        for (int i = 0; i < 7; i++)
            y.add(random.nextInt(11));

        System.out.println("Lista x: " + x);
        System.out.println("Lista y: " + y);
        //punctul a
        List<Integer> xPlusY = new ArrayList<>(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) =  " + xPlusY);

        //punctul b
        Set<Integer> zSet = new TreeSet<>(x);
        zSet.retainAll(y);
        System.out.println("b) =  " + zSet);

        //punctul c
        List<Integer> xMinusY = new ArrayList<>(x);
        xMinusY.removeAll(y);
        System.out.println("c) =  " + xMinusY);

        //punctul d
        int p = 4;
        Set<Integer> xPlusYLimitedByP = new TreeSet<>();
        for (Integer val : x) {
            if (val <= p)
                xPlusYLimitedByP.add(val);
        }
        for (Integer val : y) {
            if (val <= p)
                xPlusYLimitedByP.add(val);
        }
        System.out.println("d) =  " + xPlusYLimitedByP);

        //PUNCTUL 2.5.2
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("123", "Darius", "Vladescu", "TI22/1"));
        studenti.add(new Student("112", "Anca", "Denisa", "TI22/1"));
        studenti.add(new Student("112", "Maria", "Popa", "TI21/1"));

        System.out.println("\nLista de stundeti:  \n");
        for (Student s : studenti) {
            System.out.println(s);
        }

        Student alispopa = new Student("120", "Alis", "Popa", "TI21/2");
        Student mariapopa = new Student("112", "Maria", "Popa", "TI21/1");

        System.out.println("\nExista Alis Popa ? " + studenti.contains(alispopa));
        System.out.println("Exista Maria Popa? " + studenti.contains(mariapopa));

        //PUNCTUL 2.5.3
        Set<Student> setStudenti = new HashSet<>(studenti);
        System.out.println("\nCautare O(1) \n");

        boolean gasitAlis = setStudenti.contains(alispopa);
        boolean gasitMaria = setStudenti.contains(mariapopa);

        System.out.println("Alis a fost gasita ?  " + gasitAlis);
        System.out.println("Maria a fost gasita ? " + gasitMaria);
        System.out.println();

        //PUNCTUL 3.5.2 + 3.5.3
        Path pathIn = Paths.get("studenti_in.txt");
        Path pathOut = Paths.get("studenti_out.txt");
        Path pathOutSorted = Paths.get("studenti_out_sorted.txt");
        List<Student> listaStudenti = new ArrayList<>();

        try {
            List<String> linii = Files.readAllLines(pathIn);

            for (String linie : linii)
            {
                String[] date = linie.split(",");
                listaStudenti.add(new Student(date[0].trim(), date[1].trim(), date[2].trim(), date[3].trim()));
            }

            for(Student s:listaStudenti)
            {
                System.out.println(s);
            }
            listaStudenti.sort(Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume));

            try (BufferedWriter writer = Files.newBufferedWriter(pathOutSorted))
            {
                for(Student s:listaStudenti)
                {
                    writer.write(s.toString());
                    writer.newLine();
                }
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
