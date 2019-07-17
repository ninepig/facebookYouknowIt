package fbMianjing;

import Tree.TreeNode;

/**
 * Created by yangw on 2019/7/17.
 */
public class rangeSumOfBst {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) { return 0; }
        int sum = 0;
        if (root.val > L) { sum += rangeSumBST(root.left, L, R); } // left child is a possible candidate.
        if (root.val < R) { sum += rangeSumBST(root.right, L, R); } // right child is a possible candidate.
        if (root.val >= L && root.val <= R) { sum += root.val; } // count root in.
        return sum;
    }

//    public int rangeSumBST(TreeNode root, int L, int R) {
//        Queue<TreeNode> queue = new LinkedList();
//        int sum = 0;
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node != null) {
//                if (L <= node.val && node.val <= R)
//                    sum += node.val;
//
//                if (L < node.val)
//                    queue.add(node.left);
//                if (R > node.val)
//                    queue.add(node.right);
//            }
//        }
//
//        return sum;
//    }
}
