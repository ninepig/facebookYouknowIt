package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/8.
 * bfs level order  tricky
 */
public class binaryTreeRightView {
    public List<TreeNode> rightView(TreeNode root){
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i < size ; i++){
                TreeNode cur = q.poll();
                if (i == 0) res.add(cur);
                if (cur.right != null) q.offer(cur.right);
                if (cur.left!=null) q.offer(cur.left);
            }
        }
        return res;
    }
}
