package PQ;

import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 * 这题要想到了这么做才行。
 */
public class FindMedianFromSteamData {
    PriorityQueue<Integer> lower, higher;
    public FindMedianFromSteamData(){
        // MaxHeap
        lower = new PriorityQueue<>((a,b)->b-a);
        higher = new PriorityQueue<>();
    }
    public void addNum(int num) {
        lower.offer(num);
        higher.offer(lower.poll());
        if (lower.size() < higher.size()){
            lower.offer(higher.poll());
        }
    }
    public int findMedian(){
        if (lower.size() == higher.size() ){
            return  (lower.peek() + higher.peek()) /2;
        }else {
            return lower.peek();
        }
    }
}
