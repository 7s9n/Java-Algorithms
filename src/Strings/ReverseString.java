package Strings;

public class ReverseString {
    public static void main (String[] args) {
        assert reverse("abcd").equals("dcba");
    }

    /**
     * Reverse string using two pointer approach.
     * @param str string to be reversed.
     * @return reversed str.
     */
    public static String reverse(String str){
        int startIdx = 0 , endIdx = str.length() -1;
        char [] chars = str.toCharArray();
        while (startIdx < endIdx){
            char tmp = chars[endIdx];
            chars[endIdx--] = chars[startIdx];
            chars[startIdx++] = tmp;
        }
        return new String(chars);
    }
}
