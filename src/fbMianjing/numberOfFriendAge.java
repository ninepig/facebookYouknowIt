package fbMianjing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/7/6.
 * 基本题， hashmap 字面做就行了
 */
public class numberOfFriendAge {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages) count.put(age, count.getOrDefault(age, 0) + 1);
        int res = 0;
        for (Integer a : count.keySet()) for (Integer b : count.keySet())
            if (request(a, b)) res += count.get(a) * (count.get(b) - (a == b ? 1 : 0));
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }

}
