package Tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/8.
 */
public class ClosedBinarySearchTreeValue {
    int closedValue;
    double min = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null){
            return 0;
        }
        dfs(root,target);
        return closedValue;
    }

    private void dfs(TreeNode root, double target) {
            if (root == null) return;

            if (Math.abs(root.val-target)<min){
                min = Math.abs(root.val-target);
                closedValue = root.val;
            }

            if (root.val < target){
                dfs(root.right,target);
            }
            if (root.val > target){
                dfs(root.left,target);
            }
    }

        // 用inorder来做 然后维护 k
    /*
    二叉搜索树的中序遍历是一个有序数列，假设有一个长度为k的双端队列，我们只需要遍历的时候，把遍历到的节点加入到队尾，如果队列长度超过k，则需要从对头或者队尾删除掉一个。
     */
//    private List<Integer> result;
//    private void traverse(TreeNode root, double target, int k) {
//        if (root.left != null) traverse(root.left, target, k);
//        if (result.size() < k) result.add(root.val);
//        else if (Math.abs(root.val-target) < Math.abs(result.getFirst()-target)) {
//            result.addLast(root.val);
//            result.removeFirst();
//        } else {
//            return;
//        }
//        if (root.right != null) traverse(root.right, target, k);
//    }
//    public List<Integer> closestKValues(TreeNode root, double target, int k) {
//        if (root == null) return result;
//        result = new ArrayDeque();
//        traverse(root, target, k);
//        return result;
//    }

}