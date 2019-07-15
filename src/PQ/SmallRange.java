package PQ;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 * https://leetcode.com/problems/smallest-range/discuss/104893/Java-Code-using-PriorityQueue.-similar-to-merge-k-array
 * 保证3个变量不断变化 start end range ，用pq的方式，不断地更新这三个值 最终range 最小的是我们的目标
 */
public class SmallRange {
    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }

    public int[] smallestRange(int[][] nums) {
        if (nums == null || nums.length == 0) return null;
        PriorityQueue<Element> pq = new PriorityQueue<>(
                (a, b) -> (a.val - b.val)
        );
        int range = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // intial , put first element of each range into pq.
        for (int i = 0; i < nums.length; i++) {
            Element e = new Element(i, 0, nums[i][0]);
            pq.offer(e);
            max = Math.max(max, nums[i][0]);
        }

        int start = -1, end = -1;

        while (pq.size() == nums.length) {

            Element cur = pq.poll();
            if (max - cur.val < range) {
                range = max - cur.val;
                start = cur.val;
                end = max;
            }
            if (cur.idx + 1 < nums[cur.row].length) {
                cur.idx = cur.idx + 1;
                cur.val = nums[cur.row][cur.idx];
                pq.offer(cur);
                if (cur.val > max) {
                    max = cur.val;
                }
            }
        }

        return new int[]{start, end};

    }

    public int[] smallestRange2(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return null;
        int max = Integer.MIN_VALUE, range = Integer.MAX_VALUE;
        PriorityQueue<Element> pq = new PriorityQueue<>(
                (a,b)->(a.val - b.val)
        );
        for(int i = 0 ; i < nums.size() ; i++){
            Element e = new Element(i,0,nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max,nums.get(i).get(0));
        }

        int start = -1 , end = -1;
        while (nums.size() == pq.size()){
            Element curr = pq.poll();
            if (max - curr.val < range){
                range = max - curr.val;
                start = curr.val;
                end = max;

            }
            if (curr.idx +1 < nums.get(curr.row).size()){
                curr.idx += 1;
                curr.val = nums.get(curr.row).get(curr.idx);
                pq.offer(curr);
                if (curr.val > max){
                    max = curr.val;
                }
            }
        }
        return new int[]{start,end};

    }
}