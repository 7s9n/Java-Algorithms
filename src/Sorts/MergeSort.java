package Sorts;


import java.lang.reflect.Array;
import java.util.Comparator;
import static Utils.TestUtils.*;
import static Sorts.SortingUtils.*;
public class MergeSort implements SortingAlgorithm{
    @Override
    public <T> void sort (T[] array, Comparator<? super T> c) {
        if (array == null || c == null)
            throw new IllegalArgumentException();
        // Base case is when a single element (which is already sorted)
        if (array.length > 1){
            T[] left = leftHalf(array);
            T[] right = rightHalf(array);
            sort(left , c);
            sort(right , c);
            // Combine the two arrays into one larger array
            merge(array , left , right , c);
        }// end of if statement
    }
    private <T> void merge(T[] array , T[] left , T[] right , Comparator<? super T> c){
        int leftPtr = 0 , rightPtr = 0;
        int rightSize = right.length , leftSize = left.length;
        for (int i = 0 , n = array.length; i < n; i++) {
            if (rightPtr >=  rightSize ||
                    (leftPtr < leftSize && c.compare(right[rightPtr] , left[leftPtr]) >= 0 )){
                array[i] = left[leftPtr++];
            } // end if
            else
                array[i] = right[rightPtr++];
        } // end for loop
    }
    @SuppressWarnings("unchecked")
    private <T>  T[] leftHalf(T[] array){
        int size = array.length / 2;
        T[] left = (T[]) Array.newInstance(Object[].class.getComponentType() , size);
        System.arraycopy(array , 0 , left ,0 , size);
        return left;
    }
    @SuppressWarnings("unchecked")
    private <T>  T[] rightHalf(T[] array){
        int mid = array.length / 2;
        int size = array.length - mid;
        T[] right = (T[]) Array.newInstance(Object[].class.getComponentType() , size);
        for (int i = 0; i < size; i++)
            right[i] = array[i + mid];

        return right;
    }
}
