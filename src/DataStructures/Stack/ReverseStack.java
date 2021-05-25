package DataStructures.Stack;

import java.util.List;
import java.util.Stack;

public class ReverseStack {
    public static void main (String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(1,2,3,4,5,6));
        System.out.println("Stack before reversing: " + stack);
        reverseStack(stack);
        System.out.println("Stack after reversing: " + stack);
    }

    /**
     * this a helper function for reverseStack.
     * @param x is the number that will be added at the end of the stack.
     * @param stack the actual stack
     */
    public static void insertAtBottom(int x , Stack<Integer> stack){
        if (stack.isEmpty()){
            stack.push(x);
        }else {
            int tmp = stack.pop();
            insertAtBottom(x , stack);
            stack.push(tmp);
        }
    }

    /**
     * function to reverse the stack with the help of insertAtBottom
     * @param stack to be reversed
     */
    public static void reverseStack(Stack<Integer> stack){
        if (!stack.isEmpty()){
            int x = stack.pop();
            reverseStack(stack);
            insertAtBottom(x , stack);
        }
    }
}
