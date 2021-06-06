package DataStructures.Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BinaryHeap<T> implements Queue<T>{
    // A dynamic list to track the elements inside the heap
    private List<T> heap;
    // A dynamic list to track the elements inside the heap
    private Comparator<? super T> comparator;

    public BinaryHeap(Comparator<? super T> comparator){
        this();
        this.comparator = comparator;
    }
    public BinaryHeap(){
        this.comparator = null;
        this.heap = new ArrayList<>();
    }

    @Override
    public void enqueue (T value) {
        if (value == null)
            throw new IllegalArgumentException();
        this.heap.add(value);
        bottomUp();
    }

    @Override
    public T dequeue () {
        if (isEmpty()) return null;
        int lastElementIdx = heap.size() -1;
        T removedElement = heap.get(0);
        swap(lastElementIdx , 0);
        heap.remove(lastElementIdx);
        sinkUsingComparator(0);
        return removedElement;
    }

    @Override
    public T peek () {
        return heap.get(0);
    }

    @Override
    public int size () {
        return heap.size();
    }

    @Override
    public boolean isEmpty () {
        return heap.isEmpty();
    }
    private void bottomUp(){
        int k = this.size() -1;
        if (comparator != null)
            swimUsingComparator(k);
        else
            swimUsingComparable(k , heap.get(k));
    }
    // heapifyUp
    private void swimUsingComparator(int k){
        int pi = (k - 1) / 2; // Parent index.
        while (pi > 0 && comparator.compare( heap.get(pi) , heap.get(k) ) <= 0){
            swap(pi , k); // swap pi with k.
            k = pi;
            pi = (k - 1) / 2; // the next parent index.
        }
    }
    // heapifyUp
    private void swimUsingComparable(int k , T child){
        int pi = (k - 1) / 2; // Parent index.
        Comparable<? super T> key = (Comparable<? super T>) heap.get(pi);
        while (k > 0 && key.compareTo(child) == 1){
            swap(pi , k); // swap pi with k.
            k = pi;
            pi = (k - 1) / 2;
        }
    }
    private void  sinkUsingComparator(int k){
        int heapSize = size();
        while (true){
            int l = 2 * k + 1;
            int r = 2 * k + 2;
            int swapped = l;

            if (r < heapSize && comparator.compare(heap.get(r) , heap.get(swapped)) >= 1) swapped = r;

            if (l >= heapSize ) break;

            swap(swapped , k);
            k = swapped;
        }
    }
    private void swap(int i , int j){
        T elementAtI = heap.get(i);
        T elementAtJ = heap.get(j);
        heap.set( i , elementAtJ );
        heap.set(j , elementAtI);
    }
    private void print(){
        System.out.println(heap);
    }

    public static void main (String[] args) {
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>();
        binaryHeap.enqueue(1);
        binaryHeap.enqueue(2);
        binaryHeap.enqueue(8);
        binaryHeap.enqueue(3);
        binaryHeap.enqueue(4);
        binaryHeap.enqueue(5);
        binaryHeap.enqueue(6);
        //binaryHeap.dequeue();
        binaryHeap.print();
    }
}
