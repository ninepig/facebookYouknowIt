package fbMianjing;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yangw on 2019/7/17.
 */
public class kthBst {
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    public int kthSmallest2(TreeNode root, int k){
        if (root == null) return 0;
        TreeNode cur = root;
        int count = 0;
        int res = 0;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty()||cur!=null){
            while(cur != null){
                s.push(cur);
                cur =cur.left;
            }
            cur = s.pop();
            count++;
            if (count == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return res;
    }
}
