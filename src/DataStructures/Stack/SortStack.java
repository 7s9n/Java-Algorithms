package DataStructures.Stack;

import java.util.List;
import java.util.Stack;

public class SortStack {
    public static void main (String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(1,2,3,4,5,6));
        System.out.println("Stack before sorting: " + stack);
        stack = sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
    }

    private static <T extends Comparable<T> > Stack<T> sortStack (Stack<T> stack) {
        Stack<T> helper = new Stack<>();
        while (!stack.empty()){
            T x = stack.pop();
            while (!helper.empty() && helper.peek().compareTo(x) < 0){
                stack.push(helper.pop());
            }
            helper.push(x);
        }
        return helper;
    }
}
