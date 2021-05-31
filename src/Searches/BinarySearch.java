package Searches;


public class BinarySearch implements SearchAlgorithm{
    /**
     * @param array is an array where the element should be found
     * @param key   is an element which should be found
     * @return first found index of the element
     */
    @Override
    public <T extends Comparable<T>> int find (T[] array, T key) {
        return search(array,key , 0 , array.length - 1);
    }
    /**
     * This method implements the Generic Binary Search
     *
     * @param array The array to make the binary search
     * @param key The number you are looking for
     * @param left The lower bound
     * @param right The upper bound
     * @return the location of the key
     */
    private <T extends Comparable<T> > int search(T[] array , T key , int left , int right){
        if (left > right) return -1; // this means that the key not found
        int mid = left + (right - left) / 2;
        int comp = key.compareTo(array[mid]); // 0 if the key is equal to the array[mid].
        if (comp == 0)
            return mid;
        else if (comp < 0) // if key < array[mid]
            return search(array , key , left , mid -1);
        else  // key > array[mid]
            return search(array , key , mid + 1 , right);
    }
}
