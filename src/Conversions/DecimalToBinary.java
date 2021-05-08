package Conversions;

public class DecimalToBinary {
    public static void main (String[] args) {
        System.out.println(decimalToBinary(2));
    }
    public static int decimalToBinary(int decimal){
        int digit , b , c ;
        b = c = 0;
        while (decimal != 0){
            digit = decimal % 2 ;
            b = b + digit * (int) Math.pow(10 , c++);
            decimal /= 2;
        }
        return b;
    }
}
