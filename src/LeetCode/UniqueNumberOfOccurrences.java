package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static void main (String[] args) {

    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer , Integer> frequencyOfNumber = new HashMap<>();
        HashSet<Integer> frequencyOfOccurrences = new HashSet<>();
        for (var num : arr)
            frequencyOfNumber.compute(num , (k , v)-> v == null ? 1 : ++v);
        for (var value : frequencyOfNumber.values())
            if (!frequencyOfOccurrences.add(value))
                return false;
        return true;
    }
}
