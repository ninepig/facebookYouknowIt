package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/7/14.
 */
public class buildTreeFromTwoOrderThreeBro {
    public TreeNode buildTreeInAndPost(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || postorder.length == 0 || inorder.length!=postorder.length){
            return null;
        }
        return helper(inorder, 0, inorder.length - 1 , postorder , postorder.length-1);
    }

    private TreeNode helper(int[] inorder, int start, int end, int[] postorder, int post_pos) {
        if(start > end || post_pos < 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_pos]);
        int index = start;
        while(index <= end ){
            if(inorder[index] == postorder[post_pos]){
                break;
            }
            index++;
        }
        root.left = helper(inorder,start,index-1,postorder,post_pos - (end - index)-1);
        root.right = helper(inorder,index+1,end,postorder,post_pos-1);
        return root;
    }

    public TreeNode buildTreeFromPreAndIn(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || preorder.length!=inorder.length){
            return null;
        }
        return helper(preorder,inorder,0,0,inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder,int pre_pos , int in_begin, int in_end){
        if(pre_pos >= preorder.length || in_begin > in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_pos]);
        int i = in_begin;
        while(i <= in_end){
            if(inorder[i] == preorder[pre_pos]){
                break;
            }
            i++;
        }
        root.left = helper(preorder,inorder,pre_pos+1,in_begin,i-1);
        root.right = helper(preorder,inorder,pre_pos+(i-in_begin)+1,i+1,in_end);

        return root;
    }


    Map<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length;
        for(int i = 0; i < post.length; i++) {
            postMap.put(post[i], i);
        }

        return build(0, length - 1, 0, length - 1, pre, post);
    }

    private TreeNode build(int preLeft, int preRight, int postLeft, int postRight, int[] pre, int[] post) {
        if(preLeft > preRight || postLeft > postRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preLeft]);

        if(preLeft + 1 <= preRight) {
            int index = postMap.get(pre[preLeft + 1]);
            int sum = index - postLeft;
            root.left = build(preLeft + 1, preLeft + sum + 1, postLeft, postLeft + sum, pre, post);
            root.right = build(preLeft + sum + 2, preRight, postLeft + sum + 1, postRight - 1, pre, post);
        }

        return root;
    }
}
