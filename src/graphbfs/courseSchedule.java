package graphbfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/13.
 */
public class courseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites ==  null || prerequisites.length == 0){
            return new int[]{};
        }
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[prerequisites.length];
        for (int i = 0 ; i < prerequisites.length ; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] node : prerequisites){
            graph.get(node[1]).add(node[0]);
            indegree[node[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0 ; i < indegree.length ; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!q.isEmpty()){
            int cur = q.poll();
            resList.add(cur);
            for (int nei : graph.get(cur)){
                if (indegree[--nei] == 0){
                    q.offer(nei);
                }
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0 ; i < resList.size();i++){
            res[i] = resList.get(i);
        }

        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0){
            return true;
        }
        List<List<Integer>> matrix = new ArrayList<>();
        //create a matrix to store ,matrix's length is the course's number ,
        //courrse is the node of graph
        for (int i = 0 ; i<numCourses;i++){
            matrix.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int i = 0;i<prerequisites.length;i++){
            //add edge
            matrix.get(prerequisites[i][1]).add(prerequisites[i][0]);
            //count indegree
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int count = numCourses;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int node:matrix.get(cur)){
                if(--indegree[node]==0){
                    queue.offer(node);
                }
            }
            count--;
        }
        return count == 0;
    }
}