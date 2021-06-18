package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StrTokenizer {
    public static List<String> getTokens(String txt , String delimiter){
        StringTokenizer tokenizer = new StringTokenizer(txt , delimiter);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            tokens.add( tokenizer.nextToken().trim() );
        } // end of while
        return tokens;
    }
    public static List<List<String>> csvReader(String fileLocation , String delimiter){
        List<List<String>> tokens = new ArrayList<>();
        Path path = Paths.get(fileLocation);
        if ( !( Files.exists( path ) ) )
            return null;
        try( BufferedReader br = Files.newBufferedReader(path) ){
            String currLine;
            while ( ( currLine = br.readLine() ) != null )
                tokens.add( getTokens(currLine , delimiter) );
        } catch (IOException e){
            return null;
        }
        return tokens;
    }
    public static void main (String[] args) {
        String path = "C:/Users/Hussein Sarea/Desktop/data.csv";
        String delimiter = ",";
        var data = csvReader(path , delimiter);
        if ( data != null ){
            for (List<String> row : data)
                System.out.println(row.get(2));
        }
    }
}
