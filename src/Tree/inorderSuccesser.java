package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/8.
 */
public class inorderSuccesser {

    public TreeNode inorderSuccessorBST(TreeNode root, TreeNode p) {
        if (root ==null || p == null){
            return null;
        }
        if (root.val <= p.val){
            return inorderSuccessorBST(root.right,p);
        }else {
            // root.val 比 p的大 就说明left 后面的这个节点就是p的successor
            TreeNode left = inorderSuccessorBST(root.left,p);
            return left == null ? root : null;
        }
   }

    // 贱招。
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        List<TreeNode> path = inOrder(root);
        int index = path.indexOf(p);
        return index == -1 || index == path.size() - 1 ? null : path.get(index + 1);
    }

    private List<TreeNode> inOrder(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> left = inOrder(root.left);
        List<TreeNode> right = inOrder(root.right);
        result.addAll(left);
        result.add(root);
        result.addAll(right);
        return result;
    }
}