package PQ;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 */
public class kthElementInStream {
    PriorityQueue<Integer> pq;
    int K ;
    public kthElementInStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.K = k;
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > K){
            pq.poll();
        }
        return pq.peek();
    }
}
