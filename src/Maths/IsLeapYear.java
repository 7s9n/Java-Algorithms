package Maths;

public class IsLeapYear {
    public static boolean isLeap(int year){
        return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0);
    }

    public static void main (String[] args) {
        assert !isLeap(2021);
    }
}
