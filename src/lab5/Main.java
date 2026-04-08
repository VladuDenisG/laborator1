package lab5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<StudentBursier> bursieri = new HashSet<>();
        bursieri.add(new StudentBursier("1025", "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursier("1024", "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursier("1026", "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursier("1029", "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        writeToFile("bursieri_out.txt", bursieri);


    }

    public static void writeToFile(String filename, Collection<? extends Student> studenti) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Student s : studenti) {
                pw.println(s.toString());
            }
            System.out.println("Datele au fost scrise in " + filename);
        } catch (IOException e) {
            System.err.println("Nu s-au putut scrie datele " + e.getMessage());
        }
    }
}
