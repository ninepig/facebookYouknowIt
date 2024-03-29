package fbMianjing;

import java.util.*;

/**
 * Created by yangw on 2019/7/14.
 */
public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();

        reached.add(beginWord);
        int ladder = 1;

        while(!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for(String str:reached){
                for(int i = 0 ; i < str.length() ; i++){
                    // Bug i made, you can only change once a step!
                    char[] curArray = str.toCharArray();
                    for (char ch = 'a';ch<='z';ch++){
                        curArray[i] = ch;
                        String newStr = new String(curArray);
                        if(dict.contains(newStr)){
                            toAdd.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
            ladder++;
            if(toAdd.size()==0){
                return 0;
            }
            reached = toAdd;
        }
        return ladder;
    }


    List<List<String>> results;
    List<String> list;
    Map<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        results= new ArrayList<List<String>>();
        if (dict.size() == 0)
            return results;

        int curr=1,next=0;
        boolean found=false;
        list = new LinkedList<String>();
        map = new HashMap<String,List<String>>();

        Queue<String> queue= new ArrayDeque<String>();
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> visited = new HashSet<String>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();
                    if (unvisited.contains(new_word)){
                        //Handle queue
                        if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else{
                            List<String> l= new LinkedList<String>();
                            l.add(word);
                            map.put(new_word, l);
                        }

                        if (new_word.equals(end)&&!found) found=true;

                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr==0){
                if (found) break;
                curr=next;
                next=0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(end,start);

        return results;
    }
    private void backTrace(String word,String start){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null)
            for (String s:map.get(word))
                backTrace(s,start);
        list.remove(0);
    }
}
