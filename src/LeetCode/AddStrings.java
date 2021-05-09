package LeetCode;

public class AddStrings {
    public static void main (String[] args) {
        System.out.println(addStrings("99" , "2"));
    }
    public static String addStrings(String num1 , String num2){
        int i = num1.length() -1, j = num2.length() -1, sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0){
            int x  = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--)  - '0' : 0;
            sum += x +y;
            result.append(sum % 10);
            sum /= 10;
        } // end of while
        if (sum != 0) result.append(1);
        return result.reverse().toString();
    }
}
