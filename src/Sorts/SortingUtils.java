package Sorts;

/**
 * This class contains helper method for sorting algorithms.
 */
public class SortingUtils {
    /**
     * Helper method for swapping places in array
     *
     * @param array The array which elements we want to swap
     * @param i index of the first element
     * @param j index of the second element
     */
    public static <T> void swap(T[] array , int i , int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * This method checks if first element is greater than the other element
     *
     * @param first first element
     * @param second second element
     * @return true if the first element is greater than the second element
     */
    public static <T extends Comparable<T> > boolean grater(T first , T second){
        return first.compareTo(second) >= 1;
    }
    /**
     * This method checks if first element is less than the other element
     *
     * @param first first element
     * @param second second element
     * @return true if the first element is less than the second element
     */
    public static <T extends Comparable<T> > boolean lesser(T first , T second){
        return first.compareTo(second) < 0;
    }
}
