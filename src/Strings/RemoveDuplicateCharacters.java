package Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateCharacters {
    public static void main (String[] args) {
        String str = "Hussein Sarea";
        System.out.println(removeDuplicatesV1(str));
        System.out.println(removeDuplicatesV2(str));
        System.out.println(removeDuplicatesV3(str));
    }
    public static String removeDuplicatesV1(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuilder ans = new StringBuilder(); // answer
        for (var c : chars){
            if (ans.indexOf(String.valueOf(c)) == -1)
                ans.append(c);
        }
        return ans.toString();
    }
    public static String removeDuplicatesV2(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }
        char[] chars = str.toCharArray();
        Set<Character> uniqueValues = new HashSet<>();
        StringBuilder ans = new StringBuilder(); // answer
        for (var c : chars){
            if (uniqueValues.add(c))
                ans.append(c);
        }
        return ans.toString();
    }
    public static String removeDuplicatesV3(String str) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }
        return Arrays
                .stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}
