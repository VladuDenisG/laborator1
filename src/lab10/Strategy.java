package lab10;

import java.util.Arrays;
import java.util.List;

public class Strategy
{
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISMI41/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 9.10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12)
        );

        Exporter exporter = new Exporter();

        // a
        System.out.println("Consola");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        // b
        System.out.println("\nFișier Text");
        String fileTxt = "studentiStrategyText.txt";
        IStudentiExport strategyFisierText = new StudentiInFisierText(fileTxt);
        exporter.startExport(strategyFisierText, studenti);

        // c
        System.out.println("\nExcel");
        String fileExcel = "studentiStrategyExcel.xlsx";
        IStudentiExport strategyExcel = new StudentiInFisierXlsx(fileExcel);
        exporter.startExport(strategyExcel, studenti);


        Importer importer = new Importer();

        // d
        System.out.println("\nStrategia Citire Text");
        IStudentiCitire citireText = new StudentiDinFisierText();
        List<Student> studentiCititiDinTxt = importer.startImport(citireText, "studentiStrategyText.txt");


        for (Student s : studentiCititiDinTxt) {
            System.out.println("Citit din TXT: " + s.getNume() + " - Nota: " + s.getNota());
        }

        // e
        System.out.println("\nStrategia Citire Excel ");
        IStudentiCitire citireExcel = new StudentiDinFisierXlsx();
        List<Student> studentiCititiDinExcel = importer.startImport(citireExcel, "studentiStrategyExcel.xlsx");

        for (Student s : studentiCititiDinExcel) {
            System.out.println("Citit din EXCEL: " + s.getNume() + " - Nota: " + s.getNota());
        }





    }
}
