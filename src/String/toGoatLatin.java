package String;

import java.util.HashSet;

/**
 * Created by yangw on 2019/7/11.
 * 一步一步做。 没啥难的。 字符串处理的基本操作validNumber
 validParethesis
 */
public class toGoatLatin {
    public String toGoatLatin(String s){
        if (s == null || s.length() == 0) return s;
        HashSet<Character> helperSet = new HashSet(){{
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        String[] words = s.split("\\s+");

        int n = words.length;
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < n ; i++){
            if (!helperSet.contains(Character.toUpperCase(words[i].charAt(0)))){
                words[i] = words[i].substring(1) + words[i].charAt(0);
            }
            words[i] += "ma" +copyA(i+1);
            sb.append(words[i]);
            if (i != n -1){
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    private String copyA(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n; i++){
            sb.append('a');
        }
        return sb.toString();
    }
}
