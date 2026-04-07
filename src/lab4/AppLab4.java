package lab4;

import lab2.Student;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppLab4 {
    public static void main(String[] args) {

        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor",
                "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai",
                "Cisnadie","Daniela", "Sibiu");
    /*
        System.out.println(varste);
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        System.out.println();
        System.out.println(varste);


     */
        HashMap<String, Tanar> tineri = new HashMap<>();

        for (String nume : varste.keySet()) {
            int varsta = varste.get(nume);
            String adresa = adrese.get(nume);

            Tanar t = new Tanar(nume, varsta, adresa);

            tineri.put(nume, t);
        }
        /*
        System.out.println(" Lista tineri ");
       for (String cheie : tineri.keySet())
        {
            System.out.println(cheie + " == " + tineri.get(cheie));

        }

        */


        //4.5.2

        HashMap<String, Student> mapStudenti = new HashMap<>();

        try {
            Scanner scStud = new Scanner(new File("studenti_in.txt"));
            while (scStud.hasNextLine())
            {
                String[] date = scStud.nextLine().split(",");
                Student st = new Student (date[0].trim(), date[1].trim() , date[2].trim() , date[3].trim() );
                mapStudenti.put(st.getNrMatricol(),st);
            }
            scStud.close();

            Scanner scNote = new Scanner(new File("note_anon.txt"));
            while(scNote.hasNextLine())
            {
                String[] dateNote = scNote.nextLine().split(",");
                String nrMatricol = dateNote[0].trim();
                float notaVal = Float.parseFloat(dateNote[1].trim());

                Student gasit = mapStudenti.get(nrMatricol);
                if(gasit!=null)
                {
                    gasit.setNota(notaVal);
                }

            }
            scNote.close();
            System.out.println("Studenti cu note:  ");
            for(Student s: mapStudenti.values())
            {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierelor");
            e.printStackTrace();


        }

        float nota1 = gasesteNota("Bianca", "Popescu", mapStudenti);
        float nota2 = gasesteNota("Ioan", "Popa", mapStudenti);
        System.out.println();
        System.out.println("Rezultate cautare note : ");
        System.out.println("nota Bianca Popescu: " + nota1);
        System.out.println("nota Ioan Popa: " + nota2);

    }
    //4.5.3
    public static float gasesteNota(String prenume, String nume, HashMap<String, Student > tineri)
    {
        HashMap<String, Float> mapNumeNota = new HashMap<>();
        for(Student s : tineri.values())
        {
            String cheieNume = s.getNume() + "-" + s.getPrenume();
            mapNumeNota.put(cheieNume, s.getNota());
        }
        String cheieCautata = nume + "-" + prenume;
        return mapNumeNota.getOrDefault(cheieCautata, 0.0f);

    }





}
