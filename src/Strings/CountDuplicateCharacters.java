package Strings;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateCharacters {
    public static void main (String[] args) {
        String str = "Hussein Ahmed Sarea";
        var freq = countDuplicateCharacters(str);
        for (var pair : freq.entrySet())
            System.out.println(pair.getKey() + " : " + pair.getValue());
    }

    /**
     * count duplicate character in a string , ignoring case.
     * @param str
     * @return
     */
    public static Map<Character , Integer> countDuplicateCharacters(String str){
        str = str.toLowerCase(); // delete this line to make function case sensitive.
        Map<Character , Integer> frequency = new HashMap<>();
        for (char ch : str.toCharArray())
            frequency.compute(ch , (k , v) -> (v == null) ? 1 : ++v);
        return frequency;
    }
}
