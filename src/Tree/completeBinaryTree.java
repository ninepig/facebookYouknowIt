package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/8.
 * bfs 一层一层走
 * 检查left 如果是空，但是有right 则说明不是complete tree
 * 然后最后一层节点的时候 只要任意点有子节点 就说明不对
 */
public class completeBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (true){
            TreeNode node = q.poll();
            if (node.left == null){
                if (node.right!=null){
                    return  false;
                }
            }
            q.offer(node.left);
            if (node.right == null) break;
            q.offer(node.right);
        }
        // 最后一层点了
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node.left != null || node.right != null){
                return false;
            }
        }
        return true;
    }
}
