package fbMianjing;

import java.util.*;

/**
 * Created by yangw on 2019/7/12.
 */
public class bipaGraph {
    /**
     * 对于bfs而言，存一个点，如果他没被访问过，设置1 ， 再走他的邻居，如果有0，设置位反的，如果不是0， 看是都是反色即可
     */
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0 ; i < graph.length ; i++){
            if (graph[i].length != 0 && visited[i] == 0){
                visited[i] = 1;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                while (!q.isEmpty()){
                    int current = q.poll();
                    for (int c : graph[current]){
                        if (visited[c] == 0){
                            visited[c] = (visited[current] == 1) ? 2 : 1;
                            q.offer(c);
                        }else {
                            if (visited[c] == visited[current]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteList(List<List<Integer>> graph) {
        if (graph == null || graph.size() == 0) return false;
        int[] color = new int[graph.size()];
        for (int i = 0 ; i < graph.size() ; i++){
            if (graph.get(i).size() != 0 && color[i] == 0){
                color[i] = 1;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                while (!q.isEmpty()){
                    int current = q.poll();
                    for (int c : graph.get(current)){
                        if (color[c] == 0){
                            color[c] = color[current] == 1 ? 2 : 1;
                        }else {
                            if (color[c] == color[current]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartiteList(HashMap<Integer,HashSet<Integer>> graph) {
        if (graph == null || graph.size() == 0) return  false;
        HashMap<Integer,Integer> color = new HashMap<>();
        // Initial color
        for (int node : graph.keySet()){
            color.put(node, 0);
        }

        for (int node : graph.keySet()){
            if (graph.get(node).size() != 0 && color.get(node) == 0){
                Queue<Integer> q = new ArrayDeque<>();
                color.put(node,1);
                q.offer(node);
                while (!q.isEmpty()){
                    int cur = q.poll();
                    for (int nei : graph.get(cur)){
                        if (color.get(nei) == 0){
                            int thisColor = color.get(cur) == 1 ? 2 : 1;
                            color.put(nei,thisColor);
                        }else {
                            if (color.get(nei) == color.get(cur)) return false;
                        }
                    }
                }
            }
        }
        return true;
    }


        public boolean isBipaDfs(int[][] graph){
        int[] visit = new int[graph.length];
        for ( int i = 0 ; i< graph.length ; i++){
            if (visit[i] == 0 && !validColor(graph,visit,1,i)){
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] visit, int color, int pos) {
        if (visit[pos] != 0){
            return visit[pos] == color;
        }
        visit[pos] = color;
        for (int next : graph[pos]){
            if (!validColor(graph,visit,-color,next)){
                return false;
            }
        }
        return true;
    }

}