package Maths;

public class LongMultiplication {
    public static void main (String[] args) {
        System.out.println(multiply("500000","5000000000"));
    }
    public static String multiply(String a , String b){
        if (a.equals("0") || b.equals("0"))
            return "0";
        int aLen = a.length();
        int bLen = b.length();
        int[] digits = new int[aLen + bLen];
        for (int i = aLen - 1; i >= 0; --i) {
            for (int j = bLen -1; j >= 0 ; --j) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int sum = digits[i + j + 1] + mul;
                digits[i + j] += sum / 10; // this is the cary digit
                digits[i + j + 1] = sum % 10; // the target digit in our column
            }
        }
        StringBuilder result = new StringBuilder();
        for (int digit : digits)
            result.append(digit);
        // remove leading zeros
        while (result.charAt(0) == '0')
            result.deleteCharAt(0);
        return result.toString();
    }
}
