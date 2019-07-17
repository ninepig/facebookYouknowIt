package fbMianjing;

/**
 * Created by yangw on 2019/7/15.
 */
public class sortColorModified {
//    isHigh(), isMid(), isLow()
    //http://www.1point3acres.com/bbs/thread-209155-1-1.html
    public class Solution {
//        如果是给的string，化成char[] 再做
        //given three functions: isHigh(), isMid(), isLow()
        //sort 3 categories in d你 escending order
        public void sortColors(int[] nums, int left, int right) {//we assume input left is 0 and right is nums.length - 1
            if (nums == null || nums.length <= 1) {
                return;
            }
            int i = left;
            while (i <= right) {//should be i <= right, not i < nums.length !!!eg.[2, 2]; not i < right !!!eg.[1,0];
                if (isLow(nums[i])) {
                    swap(nums, i, left);
                    left++;//left side of left pointer are all 0, between left & i are all 1
                    i++;//i++ cuz we know what we swap from left pointer is either 0 or 1, i's left side are all 0 and 1
                } else if (isMid(nums[i])) {
                    i++;
                } else {//isHigh(nums[i])
                    swap(nums, i, right);
                    right--;//we can't i++ cuz we don't know what we swapped from right pointer, so we still need to check later
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//5,getCategory
    public class Solution {
        //int getCategory(int n), outputs the category(1 to k) of given n
        //sort k categories in descending order
        public void sortKColors(int[] nums, int k) {//we assume input left is 0 and right is nums.length - 1
            if (nums == null || nums.length <= 1 || k <= 1) {
                return;
            }
            int left = 0;
            int right = nums.length - 1;
            int min = 1;
            int max = k;
            while (left < right) {
                int i = left;
                while (i <= right) {
                    if (getCategory(nums[i]) == min) {
                        swap(nums, i, left);
                        left++;
                        i++;
                    } else if (getCategory(nums[i]) > min && getCategory(nums[i]) < max) {
                        i++;
                    } else {
                        swap(nums, i, right);
                        right--;
                    }
                }
                min++;
                max--;
            }
        }
    }
}
