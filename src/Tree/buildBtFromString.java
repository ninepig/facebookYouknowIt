package Tree;

import java.util.Stack;

/**
 * Created by yangw on 2019/7/8.
 * FOLLOW UP 606 BUILD STRING FROM BT
 */
public class buildBtFromString {
    private int index = 0 ;// make i global
    public TreeNode str2tree(String s){
        if (s == null || s.equals("") ) return null;
        return dfs(s);
    }

    private TreeNode dfs(String s) {
        TreeNode root = null;
        if (s.charAt(index) != '('){
            root = new TreeNode(getIntVal(s));
        }
        TreeNode left  = null, right = null;
        if (index < s.length() && s.charAt(index) == '('){
            index++;
            left = dfs(s);
        }
        if (index < s.length() && s.charAt(index) =='('){
            index++;
            right = dfs(s);
        }

        root.left = left;
        root.right = right;
        index++;
        return root;
    }

    private int getIntVal(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')')
                break;
            sb.append(s.charAt(index));
            index++;
        }
        int val = Integer.valueOf(sb.toString());
        return val;
    }

    // Stack way
    public TreeNode str2treeStack(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            if(c == ')')    stack.pop();
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null)    parent.right = currentNode;
                    else parent.left = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }



    // Follow up 606
    public String tree2str(TreeNode t) {
        StringBuffer result = new StringBuffer();

        dfs(result,t);

        return result.toString();
    }

    private void dfs(StringBuffer result, TreeNode t) {
        if(t == null){
            return;
        }
        result.append(t.val);
        if(t.left!=null||t.right!=null){
            result.append('(');
            dfs(result,t.left);
            result.append(')');
            if (t.right!=null){
                result.append('(');
                dfs(result,t.right);
                result.append(')');
            }
        }
    }
}
