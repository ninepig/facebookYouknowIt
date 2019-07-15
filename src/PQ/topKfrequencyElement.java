package PQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 */
public class topKfrequencyElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums){
           map.put(num,map.getOrDefault(num,0)+1);
        }
        // PQ , order by frequency from small to big
//        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->(map.get(n1)-map.get(n2)));
//
//        for (Integer num : map.keySet()){
//            pq.offer(num);
//            if (pq.size() > k){
//                pq.poll();
//            }
//        }
//        while (k>0){
//            res.add(pq.poll());
//            k--;
//        }

        // BucketSort
        // At least 2 (if all nums has one frequecny, we need size of two)
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()){
            int frequency = map.get(num);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            else{
                bucket[frequency].add(num);
            }
        }



        return res;
    }
}