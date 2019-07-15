package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/7/10.
 */
public class FindAllAngramInString {
    public List<Integer> findAnagrams(String s, String t) {
        if (s == null || s.length() ==0 ||t == null || t.length() == 0)return null;
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char  c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int left = 0 , right = 0;
        int count = map.size();

        while (right < s.length()){
            char cur = s.charAt(right);
            if (map.containsKey(cur)){
                map.put(cur,map.get(cur) - 1);
                if (map.get(cur) == 0){
                    count--;
                }
            }
            right++;
            while (count == 0){
                char leftCur = s.charAt(left);
                if (map.containsKey(leftCur)){
                    map.put(leftCur,map.get(leftCur)+1);
                    if (map.get(leftCur) > 0){
                        count++;
                    }
                }
                if (right - left == t.length()){
                    res.add(left);
                }
                left++;
            }
        }
        return res;
    }
}
