package String;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/10.
 * 这是一个经典的难题。HASHMAP 搞懂了才能懂
 * hashmap 检测附近的值。 这太巧妙了
 */
public class longestConsucutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums){
            if (!map.containsKey(n)){
                int left = (map.containsKey(n-1))? map.get(n-1):0;
                int right = (map.containsKey(n+1))?map.get(n+1):0;
                int sum = left + right + 1;
                map.put(n,sum);

                res = Math.max(res,sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left , sum);
                map.put(n + right , sum);
            }else {
                continue;
            }
        }
        return res;
    }
}