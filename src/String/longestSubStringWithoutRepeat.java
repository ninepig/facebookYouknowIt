package String;

import java.util.HashSet;

/**
 * Created by yangw on 2019/7/10.
 * hashset + two pointer
 */
public class longestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() ==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int right = 0 , left = 0;
        int res = Integer.MIN_VALUE;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                res = Math.max(res,set.size());
                right++;
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
}
