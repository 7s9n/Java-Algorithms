package BitManipulation;

public class CheckEquality {
    public static boolean checkEquality(int a , int b){
        return ((a ^ b) == 0);
    }

    public static void main (String[] args) {
        System.out.println(checkEquality(1,1));
        System.out.println(checkEquality(1,2));
    }
}
