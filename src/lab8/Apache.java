package lab8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import lab7.util.Student;
import java.io.*;
import java.util.*;

public class Apache {

    public static void main(String[] args) {
        String inputFile = "laborator8_input.xlsx";

        System.out.println("8.5.1: Citire date din laborator8_input");
        readFromExcel(inputFile);

        System.out.println("\n8.5.2: Generare Medie");
        writeMediaToExcel(inputFile, "laborator8_output2.xlsx", false);

        System.out.println("\n8.5.3: Generare Medie");
        writeMediaToExcel(inputFile, "laborator8_output3.xlsx", true);
    }

    // 8.5.1
    public static void readFromExcel(String fileName) {
        try (FileInputStream fis = new FileInputStream(new File(fileName));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + " | ");
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + " | ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Eroare la citire: " + e.getMessage());
        }
    }

    // 8.5.2 si 8.5.3
    public static void writeMediaToExcel(String inputPath, String outputPath, boolean useFormula) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook workbook = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row == null) continue;

                int lastCol = row.getLastCellNum();
                Cell newCell = row.createCell(lastCol);

                if (useFormula) {
                    // 8.5.3:
                    int excelRowNum = row.getRowNum() + 1;
                    newCell.setCellFormula("AVERAGE(D" + excelRowNum + ":F" + excelRowNum + ")");
                } else {
                    // 8.5.2:
                    double sum = 0;
                    int count = 0;

                    for (int i = 3; i <= 5; i++) {
                        Cell c = row.getCell(i);
                        if (c != null && c.getCellType() == CellType.NUMERIC) {
                            sum += c.getNumericCellValue();
                            count++;
                        }
                    }
                    if (count > 0) newCell.setCellValue(sum / count);
                }
            }
            workbook.write(fos);
            System.out.println("Fisierul " + outputPath + " a fost generat.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8.5.4
    public static void writeToXls(Collection<Student> studenti, String fileName) {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(fileName)) {

            Sheet sheet = workbook.createSheet("Studenti");
            int rowNum = 0;

            for (Student st : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(st.getNrMatricol());
                row.createCell(1).setCellValue(st.getNume());
                row.createCell(2).setCellValue(st.getPrenume());
                row.createCell(3).setCellValue(st.getFormatieDeStudiu());
                row.createCell(4).setCellValue(st.getNota());
            }

            workbook.write(fos);
            System.out.println("Fisierul " + fileName + " a fost generat cu succes.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8.5.4 b)
    public static List<Student> readFromXls(String fileName) {
        List<Student> listaCitita = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(fileName));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                String nrMatricol = row.getCell(0).getStringCellValue();
                String nume = row.getCell(1).getStringCellValue();
                String prenume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();

                Student s = new Student(nrMatricol, prenume, nume, formatie);
                listaCitita.add(s.cuNota(nota));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCitita;
    }

}