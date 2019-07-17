package fbMianjing;

/**
 * Created by yangw on 2019/7/17.
 */
public class subArrayEqualK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
    public int equalToKPositive(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum > k) {
                sum -= nums[start];
                start++;
            }
            if(sum == k) {
                count++;
            }
        }
        return count;
    }
}
