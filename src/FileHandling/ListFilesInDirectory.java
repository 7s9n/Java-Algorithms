package FileHandling;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class ListFilesInDirectory {
    public static File[] listFilesInDirectory(File folder){
        return folder.listFiles(File::isFile);
    }

    public static void main (String[] args) {
        String path = "C:/Users/Hussein Sarea/learning_python/intro";
        var files = listFilesInDirectory(new File(Path.of(path).toString()));
        System.out.println(Arrays.toString(files));
    }
}
