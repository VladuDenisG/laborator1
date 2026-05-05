package lab7;

import lab7.util.PasswordMaker;
import lab7.forms.Circle;
import lab7.forms.Form;
import lab7.forms.Square;
import lab7.forms.Triangle;
import lab7.util.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: " + PasswordMaker.getCallingCounts());

        // 7.6.3
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student("121", "Popescu", "Ion", "TI 211_1"));
        studenti.add(new Student("235", "Ionescu", "Maria", "TI 211_2"));
        studenti.add(new Student("343", "Vasile", "Ana", "TI 211_2"));
        studenti.add(new Student("444", "Matei", "Dan", "TI 211_2"));
        studenti.add(new Student("571", "Vladu", "Darius", "TI 211_2"));

        Set<Student> listaImpartita = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        System.out.println("\n7.6.3 \nFormatia 1:");
        for (Student s : listaImpartita) {
            if (s.getFormatieDeStudiu().equals("TI 211_1")) {
                System.out.println(s.getNume() + " " + s.getPrenume() + " " + s.getFormatieDeStudiu());
            }
        }

        System.out.println("\nFormatia 2:");
        for (Student s : listaImpartita) {
            if (s.getFormatieDeStudiu().equals("TI 211_2")) {
                System.out.println(s.getNume() + " " + s.getPrenume() + " " + s.getFormatieDeStudiu());
            }
        }


    }

        static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
            Set<Student> listaNoua = new LinkedHashSet<>();
            List<Student> listaTemporara = new ArrayList<>(studenti);
            int n = listaTemporara.size();

            for (int i = 0; i < n; i++)
            {
                String formatieDestinatie = (i < n / 2) ? formatia1 : formatia2;
                listaNoua.add(listaTemporara.get(i).schimbaFormatia(formatieDestinatie));
            }
            return listaNoua;
        }



}
