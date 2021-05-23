package Strings;

public class CharactersSame {
    public static void main (String[] args) {
        assert !isAllCharacterSame("123");
        assert isAllCharacterSame("1111");
        assert isAllCharacterSame("1111",'2');
    }
    /**
     * check if all the characters of a string are same
     *
     * @param str the string to check
     * @return {@code true} if all characters of a string are same, otherwise {@code false}
     */
    public static boolean isAllCharacterSame(String str){
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            if (str.charAt(i) != str.charAt(0))
                return false;
        }
        return true;
    }
    /**
     * check if all the characters of a string are same as ch
     * @param str the string to check.
     * @param ch the character
     * @return {@code true} if all characters of a string are same as ch, otherwise {@code false}
     */
    public static boolean isAllCharacterSame(String str , char ch){
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            if (str.charAt(i) != ch)
                return false;
        }
        return true;
    }
}
