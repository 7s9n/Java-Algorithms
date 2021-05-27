package LeetCode;

import java.util.Stack;

public class Base7 {
    public static void main (String[] args) {
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7A2(-7));
    }

    /**
     * Function that convert the number to base 7
     * Simple approach
     * @param num number to be converted
     * @return base 7 of a given number in form of string.
     */
    public static String convertToBase7(int num) {
        int ans = 0 , c = 0;
        while (Math.abs(num) > 0){
            ans += (num % 7) * Math.pow(10 , c++);
            num /= 7;
        }
        return String.valueOf(ans);
    }
    /**
     * Function that convert the number to base 7
     * second approach using stack
     * @param num number to be converted
     * @return base 7 of a given number in form of string.
     */
    public static String convertToBase7A2(int num){
        Stack<Integer> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        boolean isNegative = num < 0 ;
        num = Math.abs(num);
        do{
            stk.push(num % 7);
            num /= 7;
        }while (num != 0);
        if(isNegative)
            res.append('-');

        while(!stk.empty())
            res.append(stk.pop()) ;
        return res.toString();
    }
}
