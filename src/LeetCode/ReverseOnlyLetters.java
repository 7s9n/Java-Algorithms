package LeetCode;

import java.util.Stack;

/**
 * Given a string s,
 * return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 *
 * Example 1:
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 * Input: s = "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 * Input: s = "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters {
    public static void main (String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters2("Test1ng-Leet=code-Q!"));
    }

    /**
     * Approach 1: Stack of Letters
     * Intuition and Algorithm
     * Collect the letters of S separately into a stack,
     * so that popping the stack reverses the letters.
     * (Alternatively, we could have collected the letters into an array and reversed the array.)
     * Then, when writing the characters of S, any time we need a letter, we use the one we have prepared instead.
     * @param s
     * @return reversed string.
     */
    public static String reverseOnlyLetters(String s){
        Stack<Character> letters = new Stack<>();
        for (char c : s.toCharArray()){
            if (Character.isLetter(c))
                letters.push(c);
        }
        StringBuilder reversedString = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isLetter(c))
                reversedString.append(letters.pop());
            else
                reversedString.append(c);
        }
        return reversedString.toString();
    }
    /**
     * Approach 2: Reverse Pointer
     * Intuition
     *
     * Write the characters of S one by one.
     * When we encounter a letter,
     * we want to write the next letter that occurs if we iterated through the string backwards.
     * So we do just that: keep track of a pointer j that iterates through the string backwards.
     * When we need to write a letter, we use it.
     * @param s
     * @return reversed string.
     */
    public static String reverseOnlyLetters2(String s){
        StringBuilder reversedString = new StringBuilder();
        int endPtr = s.length() - 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(s.charAt(i))){
                while (!Character.isLetter(s.charAt(endPtr) ) )
                    --endPtr;
                reversedString.append(s.charAt(endPtr--));
            }else {
                reversedString.append(s.charAt(i));
            }
        }
        return reversedString.toString();
    }
}
