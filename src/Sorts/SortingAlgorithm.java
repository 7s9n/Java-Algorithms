package Sorts;

import java.util.Comparator;

public interface SortingAlgorithm {
    <T extends Comparable<T> > void sort(T[] array);
    <T > void sort(T[] array , Comparator<T> c);
}
