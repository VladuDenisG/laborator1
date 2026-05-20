package lab10;

import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;

public class StudentiInFisierText implements IStudentiExport {
    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Student s : studenti) {
                writer.println(s.getNrmatricol() + "," + s.getNume() + "," + s.getPrenume() + "," + s.getGrupa() + "," + s.getNota());
            }
            System.out.println("export finalizat in txt " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}