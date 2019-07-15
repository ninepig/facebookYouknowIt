package Tree;

import sun.invoke.util.VerifyAccess;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by yangw on 2019/7/8.
 */
public class seAndDebstAndBt {
    private String SPLITTER = ",";
    private String NULL = "X";
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLITTER);
        }else {
            sb.append(root.val).append(SPLITTER);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public TreeNode deserialize(String data){
        Deque<String> nodes = new ArrayDeque<>();
        String[] treeNodes = data.split(SPLITTER);
        nodes.addAll(Arrays.asList(treeNodes));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL)) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
