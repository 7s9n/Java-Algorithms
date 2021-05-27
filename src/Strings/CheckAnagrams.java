package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * For example, the word anagram itself can be rearranged into nag a ram,
 * also the word binary into brainy and the word adobe into abode.
 * https://en.wikipedia.org/wiki/Anagram
 */
public class CheckAnagrams {
    public static void main (String[] args) {
        assert isAnagram("funeral","real fun");
        assert isAnagram("restful","fluster");
        assert isAnagram("forty five","over fifty");
        assert isAnagram("Satan","Santa");
        assert isAnagram("New York Times" , "monkeys write");
        assert isAnagram("Church of Scientology","rich chosen goofy cult");
        assert isAnagram("eleven plus two" , "twelve plus one");
        assert isAnagram("elegant man" , "a gentleman");
        assert !isAnagram("is","are");
    }
    /**
     * Check if two strings are anagrams or not , ignoring the case and space character , only numbers and letters
     * @param firstString the first string
     * @param secondString the second string
     * @return {@code true} if two string are anagrams, otherwise {@code false}
     */
    public static boolean isAnagram(String firstString , String secondString){
        if (!(firstString != null && secondString != null))
            throw new IllegalArgumentException("Null string");
        firstString = firstString.toLowerCase().replaceAll("[^\\da-z]","");
        secondString = secondString.toLowerCase().replaceAll("[^\\da-z]","");
        if ( firstString.length() != secondString.length() || firstString.length() == 0)
            return false;

        Map<Character , Integer> frequency = new HashMap<>();

        for (int i = 0 , length = firstString.length(); i < length; i++) {
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
