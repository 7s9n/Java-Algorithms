package Strings;

/**
 * Given a string, moving several characters in front of the string to the end of the string. For
 * example, move the two characters'a' and 'b' in front of the string "abcdef" to the end of the
 * string, so that the original string becomes the string "cdefab"
 */
public class Rotation {
    /**
     * Move {@code n} characters in front of given string to the end of string time complexity: O(n)
     * space complexity: O(n)
     *
     * @param s given string
     * @param k the total characters to be moved
     * @return string after rotation
     */
    public static String leftRotate(String s , int k){
        k %= s.length();
        return s.substring(k) + s.substring(0 , k);
    }
    /**
     * Move {@code n} characters in front of given character array to the end of array
     * @param values given character array
     * @param k the total characters to be moved
     * @return string after rotation
     */
    public static String leftRotateV2(char [] values , int k){
        reverse(values , 0 ,k-1);
        reverse(values , k ,values.length-1);
        reverse(values , 0 ,values.length-1);
        return new String(values);
    }
    /**
     * Reverse character array
     *
     * @param values character array
     * @param from begin index of given array
     * @param to end index of given array
     */
    public static void reverse(char[] values , int from , int to){
        while (from < to){
            char tmp = values[from];
            values[from++] = values[to];
            values[to--] = tmp;
        }
    }

    public static void main (String[] args) {
        System.out.println(leftRotate("abcdefg",1));
        System.out.println((leftRotateV2("abcdefg".toCharArray() , 1)));
    }
}
