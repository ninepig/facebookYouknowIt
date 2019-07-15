package Array;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/13.
 * 这道题是一个好题
 */
public class continusSubArray {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return  false;
        HashMap<Integer,Integer> map = new HashMap<>();
        // -1 means postion 0 means sum of array.
        map.put(0,-1);
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i];

            // (a + n*x)%x == a%x
            if (k!=0) sum %= k;
            Integer prev = map.get(sum);
            // find previous number is also could be the reminder of k
            if (prev!=null){
                if (i - prev >1) return  true;
            }else {
                map.put(sum,i);
            }
        }
        return false;
    }
}