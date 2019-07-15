package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangw on 2019/7/13.
 * 先把所有的点放进去
 * 然后找到两个 x ,y bu相同的点， 找对角线上的点是否存在，存在就可以变成矩形
 */
public class mininumAreaRectangel {
    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0){
            return  0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for ( int[] point : points){
            if (!map.containsKey(point[0])){
                map.put(point[0],new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int[] p1 : points){
            for (int[] p2 : points){
                if (p1[0] == p2[0] || p1[1] == p2[1]){
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1])&&map.get(p2[0]).contains(p1[1])){
                    min = Math.min(min,Math.abs(p2[1]-p1[1])*Math.abs(p2[0] - p1[0]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
