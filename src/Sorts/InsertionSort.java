package Sorts;

import java.util.Comparator;

/**
 * Insertion Sort
 *
 * Time Complexity:
 * Best    :  O(n)
 * Average :  O(n^2)
 * Worst   :  O(n^2)
 *--------------------
 * Space Complexity:
 * Worst   :  O(1)
 *--------------------
 * Common implementations
 * Specific situation :
 * 1- Data added to a sorted data-set .
 * 2- Small problem Size .
 */
public class InsertionSort implements SortingAlgorithm{
    @Override
    public <T> void sort (T[] array, Comparator<? super T> c) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && c.compare(array[j] , key) > 0){
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        } // end of for loop
    }
}
