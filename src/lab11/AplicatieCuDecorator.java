package lab11;

import lab10.*;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuDecorator {
    public static void main(String[] args) {

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISMI41/2", 8.70), // [cite: 485]
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 9.10), // [cite: 485]
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90), // [cite: 485]
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0), // [cite: 485]
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10), // [cite: 485]
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12) // [cite: 485]
        );

        List<IStudentiExport> strategies = Arrays.asList(
                new StudentiInConsola(),
                new StudentiInFisierText("studentiStrategyText.txt"),
                new StudentiInFisierXlsx("studentiStrategyExcel.xlsx")
        );

        for (IStudentiExport strategy : strategies) {
            TimeExecutionDecorator decorator = new TimeExecutionDecorator(strategy, studentiCuNote);
            Long time = decorator.executionTime();


            System.out.println("timp de executie: " + time + " ms " + strategy.getClass().getSimpleName());

        }
    }
}