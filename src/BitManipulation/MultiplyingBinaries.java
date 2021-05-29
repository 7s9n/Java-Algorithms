package BitManipulation;

public class MultiplyingBinaries {
    public static int multiply(int q , int p){
        int ans = 0;
        // we compute the value of q only when the LSB of p is 1
        while (p != 0){
            if ((p & 1) != 0)
                ans += q;
            p >>>= 1; // p is logical right shifted with one position
            q <<= 1; // q is left shifted with one position
        }
        return ans;
    }

    public static void main (String[] args) {
        System.out.println(multiply(-2,4));
        System.out.println(multiply(-2,80));
    }
}
