package Searches;

public class IterativeBinarySearch implements SearchAlgorithm{
    /**
     * @param array is an array where the element should be found
     * @param key   is an element which should be found
     * @return first found index of the element
     */
    @Override
    public <T extends Comparable<T>> int find (T[] array, T key) {
        int lowerBound = 0 , upperBound = array.length -1 , comp;

        while (lowerBound <= upperBound){
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            comp = key.compareTo(array[mid]);
            if (comp == 0)
                return mid;
            else if (comp < 0)
                upperBound = mid - 1;
            else
                lowerBound = mid +1;
        }
        return -1;
    }
}
