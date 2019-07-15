package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/7/1.
 */
public class wordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null&&word==null){
            return true;
        }
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];

        for(int i = 0 ; i <board.length;i++){
            for(int j = 0 ;j<board[0].length;j++){
                boolean res = helper(board,word,i,j,0,used);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board,String word,int i, int j,int index,boolean[][] used){
        if(word.length()==index){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[0].length||used[i][j]||board[i][j]!=word.charAt(index)){
            return false;
        }
        used[i][j]=true;
        boolean res = helper(board,word,i+1,j,index+1,used)||helper(board,word,i,j+1,index+1,used)||
                helper(board,word,i-1,j,index+1,used)||helper(board,word,i,j-1,index+1,used);
        used[i][j]=false;
        return res;
    }



    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
