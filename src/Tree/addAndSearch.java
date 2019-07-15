package Tree;

/**
 * Created by yangw on 2019/7/8.
 * trie tree的标准应用
 */
public class addAndSearch {
    class trieNode{
        trieNode[] children ;
        String item;
        public trieNode(){
            children = new trieNode[26];
        }
    }

    private  trieNode root = new trieNode();

    /*
    26个节点对应的是一个字母，每加入一个字母就到新的一层，关键是在最后一层加入字符串。
     */
    public void addWord(String word){
        trieNode root = this.root;
        for (int i = 0 ; i < word.length() ; i++){
            char curChar = word.charAt(i);
            if (root.children[curChar - 'a'] == null){
                root.children[curChar - 'a'] = new trieNode();
            }
            root = root.children[curChar - 'a'];
        }
        root.item = word;
    }

    /*
    关键是search的过程
     */
    public boolean search(String word){

        return  match(word.toCharArray(),0,root);
    }

    private boolean match(char[] chars, int k, trieNode root) {
        // 递归结束条件
        if (k == chars.length){
            return !root.item.equals("");
        }
        if (chars[k] == '.'){
            // if k is not '.' , it must exist and dfs to next level.
            return  root.children[chars[k] - 'a'] != null && match(chars,k+1,root.children[chars[k] - 'a']);
        }else {
            // if k is . , any children could be ok.
            for (int i = 0 ; i < root.children.length ; i++){
                if (root.children[i] != null){
                    if (match(chars,k+1 , root.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
