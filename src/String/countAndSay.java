package String;

/**
 * Created by yangw on 2019/7/10.
 */
public class countAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder pre = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        cur.append(1);
        for (int i = 2; i <= n ; i++){
            pre = cur;
            char say = pre.charAt(0);
            int count = 1;
            cur = new StringBuilder();
            for (int j = 1 ; j < pre.length() ; j++){
                if (say != pre.charAt(j)){
                    cur.append(count).append(say);
                    say = pre.charAt(j);
                    count = 1;
                }else {
                    count++;
                }
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }

}
