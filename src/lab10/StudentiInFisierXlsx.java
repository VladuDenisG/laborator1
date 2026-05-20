package lab10;

import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("Export în Excel: " + fileName);


        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(fileName)) {


            Sheet sheet = workbook.createSheet("Studenți");


            Row headerRow = sheet.createRow(0);
            String[] numeleColoanelor = {"Nr. Matricol", "Nume", "Prenume", "Grupa", "Notă"};

            for (int i = 0; i < numeleColoanelor.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(numeleColoanelor[i]);

            }

            int rowNum = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(s.getNrmatricol());
                row.createCell(1).setCellValue(s.getNume());
                row.createCell(2).setCellValue(s.getPrenume());
                row.createCell(3).setCellValue(s.getGrupa());
                row.createCell(4).setCellValue(s.getNota());
            }
            for (int i = 0; i < numeleColoanelor.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(fileOut);
            System.out.println("fișierul excel a fost generat ");

        } catch (IOException e) {
            System.err.println("eroare la scrierea fișierului excel: " + e.getMessage());
        }
    }
}