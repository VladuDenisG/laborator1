package lab10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentiDinFisierXlsx implements IStudentiCitire {

    @Override
    public List<Student> doImport(String fileName) {
        List<Student> listaCitita = new ArrayList<>();
        System.out.println("Citire studenți din fișierul Excel: " + fileName);

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);


            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                    String nume = row.getCell(1).getStringCellValue();
                    String prenume = row.getCell(2).getStringCellValue();
                    String grupa = row.getCell(3).getStringCellValue();
                    double nota = row.getCell(4).getNumericCellValue();

                    Student s = new Student(nrMatricol, prenume, nume, grupa, nota);
                    listaCitita.add(s);
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea din Excel: " + e.getMessage());
        }

        return listaCitita;
    }
}