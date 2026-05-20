package lab10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiCitire {

    @Override
    public List<Student> doImport(String fileName) {
        List<Student> listaCitita = new ArrayList<>();
        System.out.println("Citire studenți din fișierul text: " + fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] date = linie.split(",");
                if (date.length >= 5) {
                    int nrMatricol = Integer.parseInt(date[0].trim());
                    String nume = date[1].trim();
                    String prenume = date[2].trim();
                    String grupa = date[3].trim();
                    double nota = Double.parseDouble(date[4].trim());

                    Student s = new Student(nrMatricol, prenume, nume, grupa, nota);
                    listaCitita.add(s);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Eroare la citirea din fișierul text: " + e.getMessage());
        }

        return listaCitita;
    }
}