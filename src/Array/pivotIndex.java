package Array;

/**
 * Created by yangw on 2019/7/13.
 */
public class pivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        for (int i = 0 ; i <nums.length ;i++) sum+=nums[i];
        int sumLeft = 0;
        for (int i = 0 ; i < nums.length ;i++){
            if (sumLeft * 2 == sum - nums[i]){
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}