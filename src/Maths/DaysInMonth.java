package Maths;

import java.util.ArrayList;
import java.util.List;
import static Maths.IsLeapYear.isLeap;
public class DaysInMonth {
    private static final List<Integer> monthDays;
    static {
        monthDays = new ArrayList<>(List.of(0 , 31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31));
    }
    public static int numberOfDays(int month , int year){
        if (! (1 <= month && month <= 12) )
            throw new IllegalArgumentException("Month must be between 1 and 12");
        if (month == 2 && isLeap(year))
            return 29;
        return monthDays.get(month);
    }

    public static void main (String[] args) {
        System.out.println(numberOfDays(12 , 2021));
    }
}
