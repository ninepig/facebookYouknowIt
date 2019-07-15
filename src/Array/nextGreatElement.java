package Array;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/13.
 */
public class nextGreatElement {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int num : nums){
            // Find a larger element, so form the pairs
            while (!s.isEmpty()&&s.peek()<num){
                map.put(s.pop(),num);
            }
            s.push(num);
        }
        for(int i = 0 ; i < findNums.length ; i++){
            findNums[i] = map.get(findNums);
        }
        return findNums;
    }

//    way is to use a stack to facilitate the look up. First we put all indexes into the stack, smaller index on the top.
//    Then we start from end of the array look for the first element (index) in the stack which is greater than the current one.
//    That one is guaranteed to be the Next Greater Element. Then put the current element (index) into the stack.
//    Time complexity: O(n).
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }
        return result;
    }

}