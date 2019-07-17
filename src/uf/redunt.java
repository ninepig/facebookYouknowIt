package uf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangw on 2019/7/17.
 */
public class redunt {
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            if (dfs(new HashSet<>(), map, edge[0], edge[1])) return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return new int[]{-1,-1};
    }

    private boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map,
                        int src, int target) {
        if (src == target) return true;
        visited.add(src);
        for (int next : map.get(src)) {
            if (!visited.contains(next)) {
                if (dfs(visited, map, next, target)) return true;
            }
        }
        return false;
    }

//    BFS

//    public int[] findRedundantConnection2(int[][] edges) {
//        int m = edges.length;
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        for (int i = 1; i <= m; i++) {
//            map.put(i, new HashSet<>());
//        }
//
//        for (int[] edge : edges) {
//            if (bfs(map, edge[0], edge[1])) return edge;
//            map.get(edge[0]).add(edge[1]);
//            map.get(edge[1]).add(edge[0]);
//        }
//
//        return new int[]{-1,-1};
//    }
//
//    private boolean bfs(Map<Integer, Set<Integer>> map,
//                        int src, int target) {
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(src);
//        Set<Integer> visited = new HashSet<>();
//        visited.add(src);
//
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//            if (cur == target) return true;
//            for (int next : map.get(cur)) {
//                if (visited.add(next)) {
//                    q.offer(next);
//                }
//            }
//        }
//
//        return false;
//    }


    int[] parent;

    public int[] findRedundantConnection3(int[][] edges) {
        int m = edges.length;
        parent = new int[m + 1];
        for (int i = 0; i < m; i++) parent[i] = i;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return edge;
        }

        return new int[]{-1,-1};
    }

    private boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) return false;
        parent[p1] = p2;
        return true;
    }

    private int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
            parent[x] = parent[parent[x]];
        }
        return x;
    }
}
