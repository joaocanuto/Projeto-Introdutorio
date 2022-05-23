package src.com.projetos.todolist;

import java.io.IOException;
import java.util.ArrayList;

public interface IFilesUtils {
    void readFileData(ArrayList<Tasks> taf) throws IOException;
    void exportData(ArrayList<Tasks> t);
}
