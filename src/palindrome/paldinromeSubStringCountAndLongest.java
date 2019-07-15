package palindrome;

/**
 * Created by yangw on 2019/7/11.
 */
public class paldinromeSubStringCountAndLongest {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        for (int i = 0 ; i < s.length(); i++){
            // even
            countPalidome(s,i,i+1);
            // odd
            countPalidome(s,i,i);
        }
        return  count;
    }

    private void countPalidome(String s, int i, int j) {
        while (i >= 0 && j< 0 &&s.charAt(i) == s.charAt(j)){
            count++;
            i++;
            j--;
        }
    }

    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
