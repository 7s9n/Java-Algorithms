package Conversions;

public class DecimalToAnyBase {
    public static void main (String[] args) {
        System.out.println(convertToAnyBase(7006362,2));
        System.out.println(Integer.valueOf("11010101110100010011010",2));
    }
    /**
     *
     * @param n is a decimal number to be converted.
     * @param base base that we want to convert to
     * @return a string format of n in base.
     */
    public static String convertToAnyBase(int n , int base){
        StringBuilder ans = new StringBuilder();
        boolean isNegative = n < 0;
        n = Math.abs(n);
        while (n > 0){
            ans.append(getChar(n % base));
            n /= base;
        }
        if (isNegative)
            ans.append('-');
        return ans.reverse().toString();
    }
    /**
     * This method produces character value of the input integer and returns it
     *
     * @param num integer of which we need the character value of
     * @return character value of input integer
     */
    public static char getChar(int num){
        if (num >= 0 && num <= 9)
            return (char) (num + '0');
        return (char) (num - 10 + 'A');
    }
}
