package Conversions;

public class DecimalToOctal {
    public static void main (String[] args) {
        System.out.println(decimalToOctal(8));
    }
    public static int decimalToOctal(int decimal){
        int octal = 0 , rem , c = 0;
        while (decimal != 0){
            rem = decimal % 8;
            octal += rem * (int)Math.pow(10 , c++);
            decimal /= 8;
        }
        return octal;
    }
}
