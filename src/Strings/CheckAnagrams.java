package Strings;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {
    public static void main (String[] args) {
        System.out.println(isAnagram("funeral","real fun"));
        System.out.println(isAnagram("restful","fluster"));
        System.out.println(isAnagram("forty five","over fifty"));
    }
    public static boolean isAnagram(String firstString , String secondString){
        if (!(firstString != null && secondString != null))
            throw new IllegalArgumentException("null string");
        firstString = firstString.toLowerCase().replaceAll(" ","");
        secondString = secondString.toLowerCase().replaceAll(" ","");
        if ( firstString.length() != secondString.length() || firstString.length() == 0)
            return false;

        Map<Character , Integer> frequency = new HashMap<>();
        int length = firstString.length();

        for (int i = 0; i < length; i++) {
            char firstStrChar = firstString.charAt(i);
            char secondStrChar = secondString.charAt(i);
            frequency.put(firstStrChar, frequency.getOrDefault(firstStrChar,0) + 1);
            frequency.put(secondStrChar, frequency.getOrDefault(secondStrChar,0) - 1);
        }
        for (int value : frequency.values()){
            if (value != 0)
                return false;
        }
        return true;
    }
}
