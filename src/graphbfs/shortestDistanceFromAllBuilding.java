package graphbfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yangw on 2019/7/13.
 * 经典的bfs题，遍历所有的 类似sudoku那道
 */
public class shortestDistanceFromAllBuilding {
    final private int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};

    // 0 means can pass 1 means building  , 2 means dead
    public int shortestDistance(int [][] grid){
        if (grid == null || grid.length == 0){
            return -1;
        }
        int row = grid.length , col = grid[0].length;
        // record final distance for each node
        int[][] cost = new int[row][col];
        for (int i = 0 ; i < row; i++){
            for (int j = 0 ; j < col ; j++){
                if (grid[i][j] == 1){
                    bfs(cost,grid,i,j);
                }
            }
        }

        int minCost = 0;
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col;j++){
                if (grid[i][j] == 0 && cost[i][j]!=0){
                    minCost = Math.min(cost[i][j],minCost);
                }
            }
        }
        return minCost;
    }

    private void bfs(int[][] cost, int[][] grid, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        int distance = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int k = 0 ; k < size ; k++){
                int[] cur = q.poll();
                for (int p = 0 ; p < direction.length ; p++){
                    int newX = i + direction[p][0];
                    int newY = j +direction[p][1];
                    if (newX >=0 &&newY >=0 && newX < grid.length && newY< grid[0].length &&!visited[newX][newY]&&grid[newX][newY]==0){
                        q.offer(new int[]{newX,newY});
                        visited[newX][newY] =true;
                        cost[newX][newY] += distance;
                    }
                }
            }
            distance++;
        }
        // improving by set node never be visited to obstacal. So we can skip that next time
        for (int r = 0 ; r < grid.length; r++){
            for (int p = 0 ; p < grid[0].length ;p++){
                if (grid[r][p] == 0 && visited[r][p] == false){
                    grid[r][p] = 2;
                }
            }
        }
    }
}
