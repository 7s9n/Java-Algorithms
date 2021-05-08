package Conversions;

public class DecimalToBinary {
    public static void main (String[] args) {
        System.out.println(decimalToBinary(2));
    }
    public static int decimalToBinary(int decimal){
        int bit , b , c ;
        b = c = 0;
        while (decimal != 0){
            bit = decimal % 2 ;
            b = b + bit * (int) Math.pow(10 , c++);
            decimal /= 2;
        }
        return b;
    }
}
