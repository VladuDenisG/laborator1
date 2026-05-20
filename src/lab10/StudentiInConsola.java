package lab10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {

    @Override
    public void doExport(List<Student> studenti) {

        for (Student s : studenti) {
            System.out.println(s.getNume() + " " + s.getPrenume() + " - Medie: " + s.getNota());
        }
    }
}