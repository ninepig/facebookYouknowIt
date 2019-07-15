package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/8.
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
            if ( root == null) return null;
            List<String> res = new ArrayList<>();
            dfs(root,"",res);
            return res;
    }

    private void dfs(TreeNode root, String s, List<String> res) {
        if ( root == null) return;
        if (root.right==null && root.left == null){
            res.add(s + root.val);
        }
        if (root.left != null){
            dfs(root.left , s + root.val + "->",res);
        }
        if (root.right !=null){
            dfs(root.right,s + root.val + "->",res);
        }
    }

}
