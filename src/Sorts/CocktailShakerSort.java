package Sorts;

import Utils.TestUtils;

import java.util.Comparator;
import java.util.stream.IntStream;

import static Sorts.SortingUtils.print;
import static Sorts.SortingUtils.swap;
public class CocktailShakerSort implements SortingAlgorithm{

    @Override
    public <T> void sort (T[] array, Comparator<? super T> c) {
        cocktailShakerSort(array , c);
    }
    private <T> void cocktailShakerSort(T[] array , Comparator<T> c){
        int n = array.length;
        boolean swapped;
        int i = -1;
        int traversingIdx = 0;
        do {
            swapped = false;
            ++i;
            for (; traversingIdx < n - 1 - i; traversingIdx++) {
                if (c.compare(array[traversingIdx] , array[traversingIdx + 1]) > 0){
                    swap(array , traversingIdx , traversingIdx +1);
                    swapped = true;
                } // end of if ;
            } // end of forward loop
            if (!swapped)break;
            swapped = false;
            for (; traversingIdx > i ; traversingIdx--) {
                if (c.compare(array[traversingIdx] , array[traversingIdx - 1]) < 0){
                    swap(array , traversingIdx , traversingIdx -1);
                    swapped = true;
                } // end of if ;
            } // end of backward loop
        } while (swapped); // end of do while.
    }

    public static void main (String[] args) {
        Integer[] array = IntStream
                .generate(() -> TestUtils.getRandomInt(1,30))
                .limit(9000)
                .boxed()
                .toArray(Integer[]::new);
        CocktailShakerSort cocktailShakerSort = new CocktailShakerSort();
        cocktailShakerSort.sort(array , Integer::compare);
        print(array);
    }
}
