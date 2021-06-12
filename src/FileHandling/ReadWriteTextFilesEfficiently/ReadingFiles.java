package FileHandling.ReadWriteTextFilesEfficiently;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingFiles {
    public static String readFileV1(String fileName){
        Path path = Paths.get(fileName);
        if (!Files.exists(path))
            return null;
        StringBuilder sb = new StringBuilder();
        try{
            List<String> alLines = Files.readAllLines(path);
            //sb.append(alLines.stream().collect(Collectors.joining()));
            for (String line : alLines)
                sb.append(line).append('\n');
        }catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static String readFileV2(String fileName){
        Path path = Paths.get(fileName);
        if (!Files.exists(path))
            return null;
        String line;
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = Files.newBufferedReader(path)){
            while ((line = br.readLine()) != null)
                sb.append(line).append('\n');
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static void main (String[] args) throws IOException {
        Path arabicFile = Paths.get("E:/story.txt");
        System.out.println("File to read: " + arabicFile.toString());
        System.out.println("Default charset: " + Charset.defaultCharset() + "\n\n");

        System.out.println("Read text file via InputStream:");
        System.out.println("------------------------------------------------");
        try(InputStream is = new FileInputStream(arabicFile.toString())){
            int i;
            while ((i = is.read()) != -1){
                System.out.print((char) i);
            }
        }// end of Read text file via InputStream
        System.out.println("\n\nRead text file via InputStreamReader with charset:");
        System.out.println("-------------------------------------------------------");
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(arabicFile.toFile()),
                StandardCharsets.UTF_8)){
            int i;
            while ((i = isr.read()) != -1)
                System.out.print((char) i);
        } // end of Read text file via InputStreamReader with charset.

        System.out.println("\n\nRead text file via FileReader without charset:");
        System.out.println("------------------------------------------------");
        try(FileReader fr = new FileReader(arabicFile.toFile())){
            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
        } //end of ead text file via FileReader without charset

        System.out.println("\n\nRead text file via FileReader with charset:");
        System.out.println("------------------------------------------------");
        //Note : utf-8 is the default so for me i can delete it.
        try(FileReader frCh = new FileReader(arabicFile.toFile() , StandardCharsets.UTF_8)){
            int i;
            while ((i = frCh.read()) != -1)
                System.out.print((char) i);
        } // end of Read text file via FileReader with charset.

        System.out.println("\n\nRead text file via BufferedReader with charset:");
        System.out.println("----------------------------------------------------");
        try(BufferedReader brCh = new BufferedReader(new FileReader(arabicFile.toFile() , StandardCharsets.UTF_8))){
            String line;
            while ((line = brCh.readLine()) != null)
                System.out.println(line);
        }// end of Read text file via BufferedReader with charset
        System.out.println("\n\n----------------------------------------------------");
        try(BufferedReader brCh = Files.newBufferedReader(arabicFile , StandardCharsets.UTF_8)){
            String line;
            while ((line = brCh.readLine()) != null)
                System.out.println(line);
        }
        System.out.println("\n\n----------------------------------------------------");
        try(BufferedReader brCh = new BufferedReader(new InputStreamReader(new FileInputStream(arabicFile.toFile()) , StandardCharsets.UTF_8))){
            String line;
            while ((line = brCh.readLine()) != null)
                System.out.println(line);
        }
        System.out.println("\n\nRead text file in memory via Files.readAllLines() with charset:");
        System.out.println("-------------------------------------------------------------------");
        List<String> allLines = Files.readAllLines(arabicFile);
        allLines.forEach(System.out::println); // or see the readFileV1 function up

        System.out.println("\n\nRead text file in memory via Files.readString() with charset:");
        System.out.println("-------------------------------------------------------------------");
        String content = Files.readString(arabicFile, StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
