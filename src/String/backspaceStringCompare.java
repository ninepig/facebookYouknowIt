package String;

/**
 * Created by yangw on 2019/7/10.
 */
public class backspaceStringCompare {
    private String getString(String str) {
        int n = str.length(), count = 0;
        String result = "";
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#')
                count++;
            else {
                if (count > 0)
                    count--;
                else {
                    result += ch;
                }
            }
        }
        return result;
    }

    // o(n) space  remove #
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    //o(1) space , two pointer to compare without #
    public boolean backspaceCompare2(String S, String T) {
        if (S == null && T == null) return true;
        if (S == null) return false;
        if (T == null) return false;
        int i = S.length() - 1;
        int j = T.length() - 1;
        int countS = 0, countT = 0;
        while (i >= 0 || j >= 0) {
            // Locate first no back char in S
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            // Locate first no back char in T , it could be nothing , so we used @ instead.
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right) return false;
            i--;
            j--;
        }
        return true;
    }
}


