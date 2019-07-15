package design;

import java.util.*;

/**
 * Created by yangw on 2019/7/12.
 */
public class slidingWindowMaxium {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] maxs = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque ();
        for (int i = 0; i < nums.length; i++) {
            // compare and select numbers potential to be max
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.removeLast();
            }
            // remove number slided out of window, here is why store index in window
            if (!window.isEmpty() && window.peekFirst() < i + 1 - k) {
                window.removeFirst();
            }
            window.addLast(i);

            if (i + 1 - k >= 0) {
                maxs[i+1-k] = nums[window.peekFirst()];
            }
        }
        return maxs;
    }

    // use Elem class to wrap value and its index
    // in order to compare idx when pop out
    class Elem {
        int val;
        int idx;

        Elem(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int getVal() {
            return val;
        }

        public int getIdx() {
            return idx;
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] maxs = new int[nums.length - k + 1];
        // max heap
        Queue<Elem> queue = new PriorityQueue<>((e1, e2) -> e2.val - e1.val);

        for(int i = 0; i < k; i ++){
            queue.add(new Elem(nums[i], i));
        }
        maxs[0] = queue.peek().getVal();
        for(int i = k; i < nums.length; i++){
            queue.add(new Elem(nums[i], i));
            while(queue.peek().getIdx() <= i-k) {
                queue.remove();
            }
            maxs[i - k + 1] = queue.peek().getVal();
        }

        return maxs;
    }


}
