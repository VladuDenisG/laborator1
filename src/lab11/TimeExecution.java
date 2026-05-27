package lab11;
import lab10.IStudentiExport;
import lab10.Student;

import java.util.List;

public class TimeExecution implements ITimeExecution {
    protected IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public Long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();

        exporter.doExport(studenti);

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}