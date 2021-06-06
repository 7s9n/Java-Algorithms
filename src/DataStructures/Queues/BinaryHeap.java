package DataStructures.Queues;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class BinaryHeap<T> {
    // A dynamic list to track the elements inside the heap
    private final List<T> heap;
    // A dynamic list to track the elements inside the heap
    private final Comparator<? super T> comparator;

    public BinaryHeap(Comparator<? super T> comparator){
        this.comparator = comparator;
        this.heap = new ArrayList<>();
    }
    public int size(){
        return this.heap.size();
    }
    public void add(T data){
        this.heap.add(data);
        this.swim();
    }
    public T poll(){
        T toBeRemoved = this.heap.get(0);
        swap(0 , size() -1);
        heap.remove(size() - 1);
        this.sink();
        return toBeRemoved;
    }
    private void sink () {
        int index = 0;
        while (hasLeft(index)){
            int swapped = getLeftIdx(index);
            if (hasRight(index) && comparator.compare(right(index) , left(index)) < 0) swapped = getRightIdx(index);
            if (comparator.compare(heap.get(index) , heap.get(swapped)) > 0)
                swap(index , swapped);
            else break;
            index = swapped;
        }
    }

    private void swim(){
        int index = size() - 1;
        while (hasParent(index) && comparator.compare(parent(index) , heap.get(index))  > 0){
            swap(getParentIdx(index) , index);
            index = getParentIdx(index);
        }
    }
    private T left(int index){
        return heap.get( getLeftIdx(index) );
    }
    private T right(int index){
        return heap.get( getRightIdx(index) );
    }
    private T parent(int index){
        return heap.get( getParentIdx(index) );
    }

    private int getParentIdx(int child){
        return (child - 1) / 2;
    }
    private int getLeftIdx(int pi){
        return (2 * pi + 1);
    }
    private int getRightIdx(int pi){
        return (2 * pi + 2);
    }

    private boolean hasParent(int idx){
        return getParentIdx(idx) >= 0;
    }
    private boolean hasLeft(int index){
        return getLeftIdx(index) < size();
    }
    private boolean hasRight(int index){
        return getRightIdx(index) < size();
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
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>((x , y)-> y - x);

    }
}
