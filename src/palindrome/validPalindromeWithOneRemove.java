package palindrome;

/**
 * Created by yangw on 2019/7/11.
 */
public class validPalindromeWithOneRemove {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        int l = 0 , r = s.length() - 1 ;
        while (l <= r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else {
                return isPalindrome(s,1,r-1)||isPalindrome(s,l+1,r);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r ){
            if (s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
}