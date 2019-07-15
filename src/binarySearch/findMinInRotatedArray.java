package binarySearch;

/**
 * Created by yangw on 2019/7/9.
 */
public class findMinInRotatedArray {
    public int findMin(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0 , right = nums.length - 1;
        // Find the left and right of the pivot.
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            // mid < right means it is still ascending.
            if (nums[mid] < nums[right] ){
                right = mid;
            }else{
                left = mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }

    public int findMinWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge
            } else {
                start = mid;
                // or start = mid + 1
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}
