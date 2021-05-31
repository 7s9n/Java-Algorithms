package Searches;

public class LinearSearch implements SearchAlgorithm{
    /**
     * @param array is an array where the element should be found
     * @param key   is an element which should be found
     * @return first found index of the element
     */
    @Override
    public <T extends Comparable<T>> int find (T[] array, T key) {
        for (int i = 0 , len = array.length; i < len ; ++i){
            if (array[i].compareTo(key) == 0)
                return i;
        }
        return -1;
    }
}
