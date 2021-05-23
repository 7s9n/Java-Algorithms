package LeetCode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */
public class ReverseString {
    public static void main (String[] args) {
        char[] s = new char[]{'h','e','l','l', 'o'};
        char[] s2 = new char[]{'3','2', '1'};
        reverseString(s);
        reverseString(s2);
        System.out.println(s);
        System.out.println(s2);
    }
    public static void reverseString(char[] s){
        int start_idx = 0;
        int end_idx = s.length - 1;
        while (start_idx < end_idx){
            char temp = s[start_idx];
            s[start_idx++] = s[end_idx];
            s[end_idx--] = temp;
        }
    }
}
