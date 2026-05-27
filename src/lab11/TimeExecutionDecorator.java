package lab11;

import lab10.IStudentiExport;
import lab10.Student;

import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    public long executionTime() {
        Long execTime = super.executionTime(studenti);
        return execTime;
    }
}