package PQ;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 * 最小堆PQ 默认是的是从小排到大， poll出来的是头部的值！！ 一直没搞懂 妈的b
 * 所以这个poll 是把最小的poll出来，
 * 然后k的话 头部就变成了第k小的值
 */
public class kthLargementElement {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
//        PriorityQueue<Integer> minHeap =
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int n : nums){
            if (pq.size()< k){
                pq.offer(n);
            }else if(pq.peek() < n) {
                pq.poll();
                pq.offer(n);
            }
        }
        return pq.poll();
    }
}