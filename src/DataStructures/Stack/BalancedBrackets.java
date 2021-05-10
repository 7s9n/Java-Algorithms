package DataStructures.Stack;

import java.util.Stack;

public class BalancedBrackets{
    public static void main (String[] args) {
        System.out.println(isBalanced("((1+1) * (2))"));
        System.out.println(isBalanced("<({[]})>[]"));
    }
    public static boolean isPaired(char leftBracket , char rightBracket){
        char[][] pairedBrackets = {
                {'(' , ')'},
                {'[' , ']'},
                {'{' , '}'},
                {'<' , '>'}
        };
        for (char[] pairedBracket  : pairedBrackets){
            if (pairedBracket[0] == leftBracket && pairedBracket[1] == rightBracket){
                return true;
            }
        }
        return false;
    }
    /**
     * Check if {@code brackets} is balanced
     *
     * @param brackets the brackets
     * @return {@code true} if {@code brackets} is balanced, otherwise {@code false}
     */
    public static boolean isBalanced(String brackets){
        if (brackets == null)throw new IllegalArgumentException("Null");
        Stack<Character> stk = new Stack<>();
        for (char c : brackets.toCharArray()){
            switch (c){
                case '(':
                case '[':
                case '{':
                case '<':
                    stk.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                case '>':
                    if (stk.empty() || !isPaired(stk.pop(),c)){
                        return false;
                    }
                    break;
                default:
                    continue;
            }
        } // end of for each.
        return stk.empty();
    }
}
