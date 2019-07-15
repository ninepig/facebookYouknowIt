package dp;

/**
 * Created by yangw on 2019/7/6.
 *不难的dp，
 * 维护一个sum的数组，看sum是否可以被2个里面的子sum达到
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum  = 0;
        for (int num : nums){
            sum+= num;
        }

        if(sum%2 != 0) return false;
        sum = sum/2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1 ; i <= nums.length ; i++){
            for (int j = sum ; j >= nums[i - 1];j--){
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }

        return dp[sum];
    }
}
