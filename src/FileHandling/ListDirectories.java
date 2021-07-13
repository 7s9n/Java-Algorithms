package FileHandling;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class ListDirectories {
    public static File[] listDirectories(String path){
        return new File(path).listFiles(File::isDirectory);
    }

    public static void main (String[] args) {
        String path = "C:/Users/Hussein Sarea/learning_python";
        var directories = listDirectories(Path.of(path).toString());
        System.out.println(Arrays.toString(directories));
    }
}
