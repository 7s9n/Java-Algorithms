package Sorts;

import java.util.Comparator;

public interface SortingAlgorithm {
    <T> void sort(T[] array , Comparator<? super T> c);
}
