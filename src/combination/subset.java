package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/7/9.
 */
public class subset {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,nums,0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int pos) {
        res.add(new ArrayList<>(cur));
        for (int i = pos ; i < nums.length ; i++){
            cur.add(nums[i]);
            helper(res,cur,nums,i+1);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        helper2(res,cur,nums,0);
        return res;
    }

    private void helper2(List<List<Integer>> res, List<Integer> cur, int[] nums, int pos) {
        res.add(new ArrayList<>(cur));
        for (int i = pos ; i < nums.length ; i++){
            // 去重
            if (i!=pos && nums[i-1]==nums[i])continue;
            cur.add(nums[i]);
            helper(res,cur,nums,i+1);
            cur.remove(cur.size() - 1);
        }
    }
}
