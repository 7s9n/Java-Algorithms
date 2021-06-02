package Maths;

import java.util.*;

/**
 * The number which appears most often in a set of numbers.
 *
 * Example: in {6, 3, 9, 6, 6, 5, 9, 3} the Mode is 6 (it occurs most often).
 */
public class Mode {
    public static void main (String[] args) {
        /* Test array of integers */
        assert (getMode(new int[] {})) == null;
        //assert Arrays.equals(getMode(new int[] {5}), new int[] {5});
        assert Arrays.equals(getMode(new int[] {6, 3, 9, 6, 6, 5, 9, 3}), new int[] {6});
        assert Arrays.equals(getMode(new int[] {7, 9, 9, 4, 5, 6, 7, 7, 8}), new int[] {7});
        assert Arrays.equals(getMode(new int[] {7, 9, 9, 4, 5, 6, 7, 7, 9}), new int[] {7, 9});
        for (int n : getMode(new int[]{1 , 2 })){
            System.out.print(n + " ");
        }
    }

    /**
     * Find the mode of an array of integers
     *
     * @param values array of integers
     * @return mode of the array
     */
    public static int[] getMode(int[] values){
        if (values.length == 0)return null;
        Map<Integer , Integer> freq = new HashMap<>();
        for(int value : values){
            //freq.put(value , freq.getOrDefault(value , 0) + 1);
            freq.compute(value , (k , v)-> v == null ? 1 : v++);
        }
        int max_freq = Collections.max(freq.values());
        if (max_freq <= 1)
            throw new NoSuchElementException("There's no mode.");
        List<Integer> result = new ArrayList<>();
        for(int key : freq.keySet()){
            if (freq.get(key) == max_freq)result.add(key);
        }
        return result.stream().mapToInt(v -> v).toArray();
    }
}
