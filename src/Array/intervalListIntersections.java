package Array;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/4.
 * 新题 ， 就是一个一个比较，画图做
 */
public class intervalListIntersections {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
      if(A == null || A.length == 0||B == null || B.length == 0){
          return new Interval[]{};
      }
      List<Interval> res = new ArrayList<>();
      int i = 0, j = 0 ;
      int m = A.length , n = B.length;
      while (i < m && j < n){
          Interval a = A[i];
          Interval b = B[i];

          int startMax = Math.max(a.start,b.start);
          int endMin = Math.min(a.end,b.end);
          if (endMin >= startMax){
              res.add(new Interval(startMax,endMin));
          }
          if (a.end == endMin) i++;
          if (b.end == endMin) j++;
      }
      return res.toArray(new Interval[0]);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];
            if (a[1] < b[0]) {
                i++;
                continue;
            } else if(b[1]  < a[0]) {
                j++;
                continue;
            }

            res.add(new int[]{Math.max(a[0],b[0]), Math.min(a[1],b[1])});
            if (a[1] > b[1]) {
                j++;
            } else if (a[1] < b[1]) {
                i++;
            } else {
                i++;j++;
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int z = 0; z < ans.length;z++) {
            ans[z] = res.get(z);
        }
        return ans;
    }
}
