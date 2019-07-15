package Tree;

import java.util.HashMap;

/**
 * Created by yangw on 2019/7/8.
 */
public class smallestSubtreeWithAlltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null){
            return root;
        }
        HashMap<TreeNode,Integer> map = new HashMap<>();
        depth(root,map);
        return dfs(root,map);
    }

    private int depth(TreeNode root,HashMap<TreeNode,Integer> map) {
        if(root == null ) return 0;
        if( map.containsKey(root) ) return map.get(root);
        int max = Math.max(depth(root.left,map),depth(root.right,map))+1;
        map.put(root,max);
        return max;
    }

    private TreeNode dfs(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return root;
        int left = depth(root.left,map);
        int right = depth(root.right,map);
        if (left == right) return root;
        if (left > right) return dfs(root.left,map);
        else{
            return dfs(root.right,map);
        }
    }
}
