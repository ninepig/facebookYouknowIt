package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yangw on 2019/7/10.
 */
public class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if(strs == null || strs.length == 0){
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0 ; i < strs.length ;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String cur = new String(charArray);
            if (map.containsKey(cur)){
                map.get(cur).add(strs[i]);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(cur,newList);
            }
        }
        for (List<String > list : map.values()){
            res.add(list);
        }
        return  res;
    }
}
