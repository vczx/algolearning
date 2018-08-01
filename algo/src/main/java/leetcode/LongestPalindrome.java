package leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("beautiful"));
    }

    public static String longestPalindrome(String s) {
        int stringLen = s.length();
        int maxLongestPalindromeLen = stringLen;
        while (maxLongestPalindromeLen > 0) {
            for (int i = 0; i + maxLongestPalindromeLen <= stringLen; i++) {
                if (isPalindrome(s.substring(i, i + maxLongestPalindromeLen))) {
                    return s.substring(i, i + maxLongestPalindromeLen);
                }
            }
            maxLongestPalindromeLen--;
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        int strLen = s.length() - 1;
        for (int i = 0; i < strLen / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(strLen - i)) {
                return false;
            }
        }
        return true;
    }
}
