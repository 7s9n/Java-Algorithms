package Strings;

/**
 * Alphabetical order is a system whereby character strings are placed in order based on the
 * position of the characters in the conventional ordering of an alphabet. Wikipedia:
 * https://en.wikipedia.org/wiki/Alphabetical_order
 */
public class Alphabetical {

    public static void main (String[] args) {
        assert isAlphabetical("abcD");
        System.out.println(isAlphabetical("a1b"));
        System.out.println(isAlphabetical("ba"));
        System.out.println(isAlphabetical("ab1"));

    }
    /**
     * Check if a string is alphabetical order or not
     *
     * @param str a string
     * @return {@code true} if given string is alphabetical order, otherwise {@code false}
     */
    public static boolean isAlphabetical(String str){
        str = str.toLowerCase();
        int length = str.length() -1;
        for (int i = 0; i < length ; ++i) {
            if ( !(Character.isLetter( str.charAt(i) ) &&  str.charAt(i) <= str.charAt(i + 1) ) )
                return false;
        }
        return true;
    }
}
