package DFS;

/**
 * Created by yangw on 2019/7/2.
 * dfs is much better than bfs
 * // Time complexity: O(n^2)
 // Space complexity: O(n)
 */
public class friendCycle {
    private void dfs(int[][] m, int[] visited, int studentNumber) {
        for (int i = 0 ; i < m.length ; i++ ){
            // target student is not visited && target and  current student is friend.
            if(visited[i] == 0 && m[studentNumber][i] == 1){
                visited[i] = 1;
                dfs(m,visited,i);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;

        int[] visited  = new int[M.length];
        int count = 0;
        for(int i = 0 ; i < M.length ; i++){
            // Current student is not visited
            if(visited[i] == 0){
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }

    public int findCircleNumUF(int[][] M) {
        if (M == null || M.length == 0 || M.length != M[0].length) {
            return 0;
        }
        int m = M.length;
        int res = m;
        int[] root = new int[m];
        for (int i = 0; i < m; ++i) {
            root[i] = i;
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i != j && M[i][j] == 1) {
                    int p1 = findRoot(root, i);
                    int p2 = findRoot(root, j);
                    if (p1 != p2) {
                        --res;
                        root[p2] = p1;
                    }
                }
            }
        }
        return res;
    }

    private int findRoot(int[] root, int i) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}
