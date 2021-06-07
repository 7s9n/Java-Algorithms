package Sorts;
import java.util.Comparator;
import static Sorts.SortingUtils.swap;
/**
 * Bubble  Sort
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
 *
 */
public class BubbleSort implements SortingAlgorithm{
    @Override
    public <T> void sort (T[] array, Comparator<? super T> c) {
        int n = array.length;
        boolean swapped;
        int i = -1;
        do {
            swapped = false;
            ++i;
            for (int j = 0; j < n - 1 - i; j++) {
                if (c.compare(array[j] , array[j + 1]) > 0){
                    swap(array , j , j +1);
                    swapped = true;
                } // end of if ;
            } // end of inner loop
        } while (swapped); // end of do while.
    } // end of sort function
}
