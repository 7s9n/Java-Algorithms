package LeetCode;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 * Input: word = "USA"
 * Output: true
 *
 * Example 2:
 * Input: word = "FlaG"
 * Output: false
 *
 *
 * Constraints:
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
public class DetectCapital {
    public static void main (String[] args) {
        System.out.println(detectCapitalUse("Hussein"));
    }
    public static boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (var c : word.toCharArray()){
            if (Character.isUpperCase(c))
                ++cnt;
        }
        if (cnt == word.length() || cnt == 0)
            return true;
        return cnt == 1 && Character.isUpperCase(word.charAt(0));
    }
}
