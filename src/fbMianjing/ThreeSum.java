package fbMianjing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/7/5.
 * 经典老题，想明白再做
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null ||nums.length == 0) return  null;
        List<List<Integer>> res =  new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length - 2 ; i++){
            if (i==0 || (i>0 && nums[i-1] != nums[i])){
                int low = i+1 , high = nums.length - 1 , target  = -nums[i];
                while (low < high){
                    if (nums[low] + nums[high] == - nums[i]){
                        res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while (low < high && nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }else if (nums[low] + nums[high] < -nums[i] ){
                        low++;
                    }else {
                        high--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-3 ; i++){
            if(i == 0 || (i> 0 &&nums[i] != nums[i-1])){
                for(int j = i+1; j< nums.length-2 ; j++){
                    if(j == i+1 || (j > i+1 && nums[j] != nums[j-1])){
                        int left = j + 1 , right = nums.length - 1 ;
                        while(left < right){
                            int sum = nums[left] + nums[right] + nums[i] + nums[j];
                            if(sum == target){
                                res.add(Arrays.asList(nums[i],nums[j],nums[right],nums[left]));
                                while(left < right && nums[left] == nums[left+1]) left++;
                                while(left < right && nums[right] == nums[right -1]) right--;
                                left++;
                                right--;
                            }else if (sum > target){
                                right --;
                            }else {
                                left++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}