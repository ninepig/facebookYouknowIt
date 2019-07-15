package String;

/**
 * Created by yangw on 2019/7/11.
 */
public class oneDistance {
    public boolean isOneEditDistance(String s, String b) {
            if (s == null || s.length() == 0 || b== null ||b.length() == 0) return false;
            if (s.length() > b.length()) return isOneEditDistance(b,s);
            boolean ifDifference = false;
            for ( int i = 0, j = 0 ; i < s.length() ; i++, j++) {
                if (s.charAt(i) != b.charAt(j)) {
                    // Same length, compare change operation
                    if (ifDifference) {
                        return false;
                    }
                    ifDifference = true;
                    // different length , skip that
                    // compare insert , delete operation.
                    // i-- 相当于skip了 t的当前不同的这一位
                    // acd  abcd 相当于skip了b
                    if (s.length() < b.length()) i--;
                }
            }
            return true;
    }
}