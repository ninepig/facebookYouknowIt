package dp;

/**
 * Created by yangw on 2019/7/5.
 */
public class regularExpression {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }

            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;

            for (int i = 1; i < dp[0].length; i++) {
                if (p.charAt(i - 1) == '*') {
                    if (dp[0][i - 1] || (i > 1 && dp[0][i - 2])) {
                        dp[0][i] = true;
                    }
                }
            }
        /*
        1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
        2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
        3, If p.charAt(j) == '*':
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
         */
            for (int i = 1; i < dp.length; i++) {

                for (int j = 1; j < dp[0].length; j++) {
                    //if p[i-1]== s[i-1] or p[i-1] = "."
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                            //i-1 != j-2 and j-2 is not .
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        }
                    }
                }

            }
            return dp[s.length()][p.length()];
        }
    }
}
