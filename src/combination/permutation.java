package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangw on 2019/7/9.
 * 去重要排序
 */
public class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        dfs(nums,0,res,cur);
        return res;
    }

    private void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> cur) {
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
        }else {
            for (int i = pos ; i < nums.length ; i++){
                if (cur.contains(nums[i])){
                    continue;
                }
                cur.add(nums[i]);
                // permutation 这里是pos，其实就是0，因为purmutation 是从头开始，所以也不需要这个中间值传递
                dfs(nums,pos,res,cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs2(used,cur,res,nums);
        return res;
    }

    private void dfs2(boolean[] used, List<Integer> cur, List<List<Integer>> res, int[] nums) {
        if (nums.length == cur.size()){
            res.add(new ArrayList<>(cur));
        }else {
            for ( int i = 0 ; i < nums.length ; i++){
                if (used[i])continue;

                // if 112 if we want used second 1 , first one must be used.
                if (i > 0 && nums[i]==nums[i-1]&&!used[i-1]){
                    continue;
                }
                used[i]= true;
                cur.add(nums[i]);
                // permutation 这里是pos，其实就是0，因为purmutation 是从头开始，所以也不需要这个中间值传递
                dfs2(used,cur,res,nums);
                cur.remove(cur.size() - 1);
                used[i] = false;

            }
        }
    }


}
