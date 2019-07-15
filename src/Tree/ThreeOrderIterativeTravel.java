package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 */
public class ThreeOrderIterativeTravel {
    List<TreeNode> inOrderTravel(TreeNode root){
        if (root == null) return null;
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur!=null){
            while (root!=null){
                s.push(root);
                root = root.left;
            }
            cur = s.pop();
            res.add(cur);
            root = cur.right;
        }
        return res;
    }


    List<TreeNode> preOrderTravel(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        s.push(cur);
        while (!s.isEmpty()){
            cur = s.pop();
            res.add(cur);
            if (cur.left!=null){
                s.push(cur.left);
            }
            if (cur.right!=null){
                s.push(cur.right);
            }
        }
        return res;
    }

    // 非常巧妙地方法
    List<TreeNode> postOrderTravel(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        s.push(cur);
        while (!s.isEmpty()){
            cur = s.pop();
            res.add(0,cur);
            // push the left first, because we add right to head at first, then left.
            // So it still will be left, right ,root order.
            if (cur.left != null) s.push(cur.left);
            if (cur.right != null) s.push(cur.right);
        }
        return res;
    }

}
