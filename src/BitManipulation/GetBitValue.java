package BitManipulation;

public class GetBitValue {
    public static int getIthBit(int n , int ith){
        if (ith <= 0 || ith > 32)
            throw new IllegalArgumentException("The position must be between 1 and 32");
        return 1 & (n >> ith - 1); // or n & (1 << i - 1);
    }

    public static void main (String[] args) {
        System.out.println(getIthBit(65,2));
    }
}
