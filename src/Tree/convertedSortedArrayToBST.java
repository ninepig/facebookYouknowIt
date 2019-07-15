package Tree;

/**
 * Created by yangw on 2019/7/8.
 */
public class convertedSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int l = 0 , r = nums.length - 1;
        TreeNode root = binarySearch(nums, l , r);
        return  root;
    }

    private TreeNode binarySearch(int[] nums, int l, int r) {
            if (l > r) return null;
            int m = (l + r)/ 2;
            TreeNode root =new TreeNode(nums[m]);
            root.left = binarySearch(nums,l,m-1);
            root.right =binarySearch(nums,m+1,r);
            return root;
    }

    public class Solution {

        private ListNode current;

        private int getListLength(ListNode head) {
            int size = 0;

            while (head != null) {
                size++;
                head = head.next;
            }
            return size;
        }

        public TreeNode sortedListToBST(ListNode head) {
            int size;

            current = head;
            size = getListLength(head);

            return sortedListToBSTHelper(size);
        }

        public TreeNode sortedListToBSTHelper(int size) {
            if (size <= 0) {
                return null;
            }
            TreeNode left = sortedListToBSTHelper(size / 2);
            TreeNode root = new TreeNode(current.val);
            current = current.next;
            TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

            root.left = left;
            root.right = right;
            return root;
        }
//
//        private ListNode buildTree(int size) {
//            if (size <= 0) {
//                return null;
//            }
//            ListNode left = buildTree(size / 2);
//            ListNode root = curr;//curr is the root of these two subtrees
//            curr = curr.next;
//            ListNode right = buildTree(size - 1 - size / 2);
//            root.prev = left;
//            root.next = right;
//            return root;
//        }
    }



}
