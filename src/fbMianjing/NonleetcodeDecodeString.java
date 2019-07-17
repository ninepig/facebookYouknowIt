package fbMianjing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/7/17.
 */
public class NonleetcodeDecodeString {
    public boolean canDecodeString(Map<String, Integer> map,
                                   String s) {
        if (s == null || s.length() == 0) return false;
        if (!s.isEmpty() && map.isEmpty()) return false;
        Map<String, Boolean> visitedMap = new HashMap<>();
        return dfs(map, s, visitedMap);
    }

    private boolean dfs(Map<String, Integer> map, String s, Map<String, Boolean> visitedMap) {
        if (s.isEmpty()) return false;
        if (visitedMap.containsKey(s)) return visitedMap.get(s);
        if (map.containsKey(s) && map.get(s) >= 1) {
            visitedMap.put(s, true);
            return true;
        }
        else {
            for (String key : map.keySet()) {
                if (s.startsWith(key) && map.get(key) >= 1) {
                    int len = key.length();
                    map.put(key, map.get(key) - 1);
                    if (dfs(map, s.substring(len), visitedMap)) {
                        visitedMap.put(s.substring(len), true);
                        return true;
                    }
                    map.put(key, map.get(key) + 1);
                }
            }
            visitedMap.put(s, false);
            return false;
        }
    }
}
