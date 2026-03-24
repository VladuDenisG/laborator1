package lab3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    public static void main(String[] args)
    {
        try {
            Path pathIn = Paths.get("in.txt");
            Path pathOut = Paths.get("out.txt");
            List<String> linii = Files.readAllLines(pathIn);
            try (BufferedWriter writer = Files.newBufferedWriter(pathOut)) {
                //punctul a
                writer.write("a)  = ");
                for (String linie : linii) {
                    String[] cuvinte = linie.split(" ");
                    writer.write(linie + "\n\n");
                }
                writer.write("\n");
                //puctul b
                writer.write("b)  =  ");
                for (String linie : linii) {
                    String[] propozitii = linie.split("\\.");
                    for (String prop : propozitii) {
                        writer.write(prop + ".\n\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
