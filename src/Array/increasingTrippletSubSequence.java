package Array;

/**
 * Created by yangw on 2019/7/13.
 * 非常巧妙地方法，三连续增长，只要找是否有连续3个数（更小）即可
 */
public class increasingTrippletSubSequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int min = Integer.MAX_VALUE , secMin = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= min){
                min = num;
            }else if (num <= secMin){
                secMin = num;
            }else {
                return true;
            }
        }
        return false;
    }
}
