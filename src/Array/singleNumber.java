package Array;

/**
 * Created by yangw on 2019/7/7.
 */
public class singleNumber {
    public int singleNumberI(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }

}
