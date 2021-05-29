package BitManipulation;

public class ClearBits{
    public static int clearIthBit(int n , int i){
        if (i <= 0 || i > 32){
            throw new IllegalArgumentException("The position must be between 1 and 32");
        }
        // ith bit of n is being cleared by this operation.
        return n & ~(1 << i - 1);
    }

    public static void main (String[] args) {
        System.out.println(clearIthBit(65,7));
    }
}
