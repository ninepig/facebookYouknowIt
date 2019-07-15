package Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 * 因为要求返回最小的value must be in order!
 */
public class bstIterator {
    TreeNode curr;
    Stack<TreeNode> s;
    public bstIterator(TreeNode root) {
        curr = root;
        s = new Stack<>();
    }

    public boolean hasNext() {
        return !s.isEmpty()|| curr != null;
    }

    public int next() {
        while (curr!=null){
            s.push(curr);
            curr = curr.left;
        }
        TreeNode temp = s.pop();
        curr = temp.right;
        return temp.val;
    }
}
