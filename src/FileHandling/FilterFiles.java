package FileHandling;


import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class FilterFiles {
    public static void main (String[] args) throws IOException {
        Path path = Paths.get("C:/Users/Hussein Sarea/Desktop");
        //No filter applied
        System.out.println("\nNo Filter applied");
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(path)){
            for(Path file : ds){
                System.out.println(file.getFileName());
            }
        }
        System.out.println("\nFilter PNG , JPG files via glop pattern");
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(path , "*.{png,jpg}")){
            for (Path file : ds){
                System.out.println(file.getFileName());
            }
        }



        FilenameFilter filenameFilter = (f , n) -> n.endsWith(".txt");
        String[] files = path.toFile().list( filenameFilter );
        System.out.println(Arrays.asList(files));
    }
}
