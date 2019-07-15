package PQ;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yangw on 2019/7/9.
 * 这个就是最大堆了，距离最远的在头部，poll出最远的 懂了！！
 */
public class kClosedPoint {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0) return points;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)->(  b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1])
        );
        for (int[] point : points){
            pq.offer(point);
            if (pq.size() > K){
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (!pq.isEmpty()){
            res[K--] = pq.poll();
        }
        return res;
    }

    public int[][] kclosedQs(int[][] points , int k ){
        if (points == null || points.length == 0) return points;
        int l = 0 , r = points.length - 1;
        while (l <= r){
            int mid = partition(points,l,r);
            if (mid == k)break;
            else if (mid < k) l = mid + 1;
            else r = mid - 1;
        }
        return Arrays.copyOf(points,k);
    }

    // 在原数组上替换的做法
    private int partition(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l <= r){
            // first right one less than pivot
            while (l<r && compare(points[r],pivot) >= 0 ) r--;
            points[l] = points[r];
            // first left one bigger than pivot
            while (l < r && compare(points[l],pivot)<=0) l++;
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}