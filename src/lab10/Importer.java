package lab10;

import java.util.List;

public class Importer {
    public List<Student> startImport(IStudentiCitire strategyInstance, String fileName) {
        return strategyInstance.doImport(fileName);
    }
}