package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangw on 2019/7/8.
 */
public class PathSumSerial {
    // 招所有的点加起来sum 的情况
    public int pathSum3(TreeNode root, int sum) {
        if(root == null) return 0;

        return getSum(root,sum)+pathSum3(root.left,sum) + pathSum3(root.right,sum);
    }
    private int getSum(TreeNode root, int sum){
        int res = 0;
        if(root == null) return 0;

        if(root.val == sum)res++;

        res += getSum(root.left, sum-root.val);
        res += getSum(root.right, sum-root.val);

        return res;
    }

    boolean ifExit = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        helper(root, sum);
        return ifExit;
    }

    private void helper(TreeNode root, int sum){
        if(root == null) return ;
        if(root.val == sum && root.left== null && root.right == null){
            ifExit = true;
        }
        helper(root.left , sum - root.val);
        helper(root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper2(res,cur,root,sum);
        return res;
    }

    private void helper2(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
        if(root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size()-1);
            return;
        }else{
            helper2(res,cur,root.left,sum-root.val);
            helper2(res,cur,root.right,sum-root.val);

        }
        cur.remove(cur.size()-1);
    }


    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();

    public int pathSum4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }

        traverse(nums[0] / 10, 0);

        return sum;
    }

    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;

        int curSum = preSum + tree.get(root);

        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }

        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }
}
