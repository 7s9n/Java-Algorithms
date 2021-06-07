package Sorts;

import java.util.Comparator;
import static Sorts.SortingUtils.swap;

/**
 * Selection Sort
 *
 * Time Complexity:
 * Best    :  O(n^2)
 * Average :  O(n^2)
 * Worst   :  O(n^2)
 *--------------------
 * Space Complexity:
 * Worst   :  O(1)
 *--------------------
 * Common implementations
 *
 */
public class SelectionSort implements SortingAlgorithm{
    @Override
    public <T> void sort (T[] array, Comparator<? super T> c) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int idx = i; // might be the min or max element index depends on the Comparator
            for (int j = i +1; j < n; j++) {
                //Comparator 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
                if (c.compare(array[idx] , array[j] ) > 0) idx = j;
            } // end inner loop
            if (idx != i)
                swap(array , i , idx);
        } // end outer loop
    }
}
