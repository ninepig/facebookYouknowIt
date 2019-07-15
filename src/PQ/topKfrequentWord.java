package PQ;

import java.util.*;

/**
 * Created by yangw on 2019/7/9.
 * 因为k frequent 但是这是单词，所以要注意单词排序的问题。 所以就要再多一层判断
 */
public class topKfrequentWord {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) return null;
        List<String> res= new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        //PQ , 这道题还有这个问题啊！！
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if (pq.size()>k){
                pq.poll();
            }
        }

        while(!pq.isEmpty())
            res.add(0, pq.poll().getKey());

        return res;
    }


    public List<String> topKFrequentT(String[] words, int k) {
        // calculate frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        // build the buckets
        TrieNode[] count = new TrieNode[words.length + 1];
        for(String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if(count[freq] == null) {
                count[freq] = new TrieNode();
            }
            addWord(count[freq], word);
        }
        // get k frequent words
        List<String> list = new LinkedList<>();
        for(int f = count.length - 1; f >= 1 && list.size() < k; f--) {
            if(count[f] == null) continue;
            getWords(count[f], list, k);
        }
        return list;
    }

    private void getWords(TrieNode node, List<String> list, int k) {
        if(node == null) return;
        if(node.word != null) {
            list.add(node.word);
        }
        if(list.size() == k) return;
        for(int i = 0; i < 26; i++) {
            if(node.next[i] != null) {
                getWords(node.next[i], list, k);
            }
        }
    }

    private boolean addWord(TrieNode root, String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new TrieNode();
            }
            curr = curr.next[c - 'a'];
        }
        curr.word = word;
        return true;
    }

class TrieNode {
    TrieNode[] next;
    String word;
    TrieNode() {
        this.next = new TrieNode[26];
        this.word = null;
    }
}
}