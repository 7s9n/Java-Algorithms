package Sorts;
import static Sorts.SortingUtils.*;
import Utils.TestUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;


public class HeapSort implements SortingAlgorithm{
    @Override
    public <T> void sort (T[] array, Comparator<? super T> c) {
        buildHeap(array , c);
    }

    private <T>  void buildHeap(T[] array , Comparator<T> c){
        int n = array.length;
        // ( n / 2 ) -1 is the last non leaf node.
        for (int i = (n / 2) -1; i >= 0; --i)
            sink(array , n , i , c); //sink(array , n , i);
        extract(array , c);
    }
    private <T> void sink(T[] array , int heapSize , int k , Comparator<T> c){
        int l = 2 * k + 1; // left child.
        int r = 2 * k + 2; // right child.
        int largest = k; // set root node as the largest.
        //If the left child index is in the bound ,
        // and greater than its parent make left child index as the largest.
        if (l < heapSize && c.compare(array[l] , array[largest]) >= 1) largest = l;

        //If the right child index is in the bound ,
        // and greater than the largest make right child index as the largest.
        if (r < heapSize && c.compare(array[r] , array[largest]) >= 1 ) largest = r;
        if (largest != k){
            swap(array , largest , k);
            sink(array , heapSize , largest , c);
        }
    }
    private <T> void extract(T[] array , Comparator<T> c){
        for (int i = array.length - 1; i >= 0 ; --i) {
            swap(array , 0 , i);
            sink(array , i , 0 , c);
        }
    }

    public static void main (String[] args) {
        Integer[] array = IntStream
                .generate(() -> TestUtils.getRandomInt(1,30))
                .limit(30)
                .boxed()
                .toArray(Integer[]::new);
        Character[] characters = new Character[]{'z' , 'c' , 'd' , 'b' , 'f' , 'e' , 'g' , 'a'};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array , (x , y)-> y - x);
        heapSort.sort(characters , Comparator.reverseOrder());
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(characters));

        System.out.println("Length: " + array.length);
    }
}
