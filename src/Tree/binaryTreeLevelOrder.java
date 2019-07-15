package Tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/8.
 */
public class binaryTreeLevelOrder {
    List<List<TreeNode>> postOrderTravel(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new ArrayDeque<>();
        List<TreeNode> curLevel;
        List<List<TreeNode>> res = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            curLevel = new ArrayList<>();
            for ( int i = 0 ; i < size ; i++){
                TreeNode cur = q.poll();
                curLevel.add(cur);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right!=null) q.offer(cur.right);
            }
            res.add(curLevel);
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList();
        }
        List<List<Integer>> resultList = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for(int i = 0; i< size; i++){
                TreeNode temp = queue.poll();
                currentLevelList.add(temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            resultList.add(0,currentLevelList);

        }

        return resultList;

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()){
            int curSize = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0 ;  i < curSize ; i++){
                TreeNode curNode = q.poll();
                if(level % 2 == 1){
                    cur.add(curNode.val);
                }else{
                    cur.add(0,curNode.val);
                }
                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null)q.offer(curNode.right);
            }
            res.add(cur);
            level++;
        }
        return res;
    }

}