package fbMianjing;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by yangw on 2019/7/12.
 */
public class slidingWindowMediem {
    // on for remove operation so the overall will Be o kn
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1; // 结果的尺寸
        double[] res = new double[m];
        // 两个堆，一个最大堆，一个最小
        // MaxHeap 用来保存比较小的一堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 让maxHeap始终保存小于一半的值，minHeap保存大于一半的，正好两半
            if (maxHeap.size() == 0 || maxHeap.peek() >= num)
                maxHeap.add(num);
            else
                minHeap.add(num);
            // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            // 如果需要输出
            if (i - k + 1 >= 0) {
                if (k % 2 == 1)
                    res[i - k + 1] = maxHeap.peek();
                else
                    res[i - k + 1] = (maxHeap.peek() / 2.0 + minHeap.peek() / 2.0); // 小心溢出
                // 移除并更新
                int toBeRemove = nums[i - k + 1];
                if (toBeRemove <= maxHeap.peek())
                    maxHeap.remove(toBeRemove);
                else
                    minHeap.remove(toBeRemove);
                // 维护两个堆，保证两个堆得大小，要么保持一致（偶数时），要么maxHeap多一个（奇数时）
                if (minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
                if (maxHeap.size() > minHeap.size() + 1)
                    minHeap.add(maxHeap.poll());

            }
        }
        return res;
    }

//    维护二叉排序树hiSet与loSet，其中：
//
//    hiSet的最小元素 > loSet的最大元素
//
//    hiSet的大小 - loSet的大小 ∈ [0, 1]
//
//    获取中位数：
//
//    若hiSet的大小 > loSet的大小，则返回hiSet.minValue
//
//    否则，返回(hiSet.minValue + loSet.maxValue) / 2
//
//    新增元素：
//
//    若hiSet为空，或者新元素 > hiSet.minValue，则加入hiSet
//
//            否则加入loSet
//
//    调整hiSet, loSet
//
//    移除元素：
//
//    若hiSet包含目标元素，则从hiSet中移除
//
//    否则，从loSet中移除
//
//            调整hiSet, loSet
//
//    调整元素：
//
//    若loSet的大小 > hiSet的大小，则将loSet的最大值弹出，加入hiSet
//
//    否则，若hiSet的大小 - loSet的大小 > 1，则将hiSet的最小值弹出，加入loSet
//    Java代码：

    public class Solution {
        class Point{
            // value
            int X;
            int Y;

            public int getX() {
                return X;
            }

            public void setX(int x) {
                X = x;
            }

            public int getY() {
                return Y;
            }

            public void setY(int y) {
                Y = y;
            }

            // index

            public Point(int val , int pos){
                this.X  = val;
                this.Y = pos;
            }
        }
        private Comparator<Point> cmp = new Comparator<Point>(){
            public int compare(Point a, Point b) {
                if (a.getX() != b.getX())
                    return Double.valueOf(b.getX()).compareTo(Double.valueOf(a.getX()));
                return Double.valueOf(b.getY()).compareTo(Double.valueOf(a.getY()));
            }
        };

        private TreeSet<Point> hiSet = new TreeSet<>(cmp);
        private TreeSet<Point> loSet = new TreeSet<>(cmp);

        private double getMedian() {
            if (hiSet.size() > loSet.size()) {
                return hiSet.last().getX();
            }
            return ((hiSet.last().getX()) + (loSet.first().getX())) / 2;
        }

        private void addValue(int val, int i) {
            Point p = new Point(val, i);
            if (hiSet.isEmpty() || hiSet.last().getX() < p.getX()) {
                hiSet.add(p);
            } else {
                loSet.add(p);
            }
            adjustSet();
        }

        private void removeValue(int val, int i) {
            Point p = new Point(val, i);
            if (hiSet.contains(p)) {
                hiSet.remove(p);
            } else {
                loSet.remove(p);
            }
            adjustSet();
        }

        private void adjustSet() {
            if (loSet.size() > hiSet.size()) {
                hiSet.add(loSet.pollFirst());
            } else if (hiSet.size() > loSet.size() + 1) {
                loSet.add(hiSet.pollLast());
            }
        }

        public double[] medianSlidingWindow(int[] nums, int k) {
            double[] ans = new double[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                if (i >= k) {
                    removeValue(nums[i - k], i - k);
                }
                addValue(nums[i], i);
                if (i >= k - 1) {
                    ans[i - k + 1] = getMedian();
                }
            }
            return ans;
        }
    }


    // binary search
//    public double[] medianSlidingWindow(int[] nums, int k) {
//        List<Integer> current = new ArrayList<>();
//        double[] res = new double[nums.length - k + 1];
//        for (int i = 0; i < k; i++) {
//            int index = Collections.binarySearch(current, nums[i]);
//            if (index < 0) {
//                index = -index - 1;
//            }
//            current.add(index, nums[i]);
//        }
//        res[0] = getMedian(current);
//        for (int i = k; i < nums.length; i++) {
//            int remove = Collections.binarySearch(current, nums[i - k]);
//            current.remove(remove);
//            int index = Collections.binarySearch(current, nums[i]);
//            if (index < 0) {
//                index = -index - 1;
//            }
//            current.add(index, nums[i]);
//            res[i - k + 1] = getMedian(current);
//        }
//        return res;
//    }
//
//    private double getMedian(List<Integer> current) {
//        int size = current.size();
//        if (size % 2 == 0) {
//            return current.get(size / 2 - 1) / 2.0 + current.get(size / 2) / 2.0;
//        } else {
//            return (double) current.get(size / 2);
//        }
//    }
}
