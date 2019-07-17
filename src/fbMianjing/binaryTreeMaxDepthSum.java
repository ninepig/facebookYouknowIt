package fbMianjing;

import Tree.TreeNode;

/**
 * Created by yangw on 2019/7/8.
 * 同balanceTree
 * 全局变量 + travesal
 * 只不过再travel的时候对值处理的方式不同
 */
public class binaryTreeMaxDepthSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        max = Math.max(max,left+right+root.val);

        return root.val + Math.max(left,right);
    }



    // just returns the nodes in post-order
//    public Iterable<TreeNode> topSort(TreeNode root) {
//        Deque<TreeNode> result = new LinkedList<>();
//        if (root != null) {
//            Deque<TreeNode> stack = new LinkedList<>();
//            stack.push(root);
//            while (!stack.isEmpty()) {
//                TreeNode curr = stack.pop();
//                result.push(curr);
//                if (curr.right != null) stack.push(curr.right);
//                if (curr.left != null) stack.push(curr.left);
//            }
//        }
//        return result;
//    }
//
//    public int maxPathSum(TreeNode root) {
//        int result = Integer.MIN_VALUE;
//        Map<TreeNode, Integer> maxRootPath = new HashMap<>(); // cache
//        maxRootPath.put(null, 0); // for simplicity we want to handle null nodes
//        for (TreeNode node : topSort(root)) {
//            // as we process nodes in post-order their children are already cached
//            int left = Math.max(maxRootPath.get(node.left), 0);
//            int right = Math.max(maxRootPath.get(node.right), 0);
//            maxRootPath.put(node, Math.max(left, right) + node.val);
//            result = Math.max(left + right + node.val, result);
//        }
//        return result;
//    }
}
