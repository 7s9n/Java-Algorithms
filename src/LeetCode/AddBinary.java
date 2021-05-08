package LeetCode;

public class AddBinary {
    public static void main (String[] args) {
        System.out.println(addBinary("00111" , "10111"));
        // 0 0 1 1 1
        // 1 0 1 1 1
        // ---------
        // 1 1 1 1 0
    }
    public static String addBinary(String a , String b){
        int i = a.length() - 1 , j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int sum = 0;
        while (i >= 0 || j >= 0){
            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;
            sum += x + y;
            result.append(sum % 2);
            sum /= 2;
        } // end of while
        if (sum != 0)result.append(sum);
        return result.reverse().toString();
    }
}
