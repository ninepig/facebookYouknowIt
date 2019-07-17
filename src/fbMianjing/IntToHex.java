package fbMianjing;

/**
 * Created by yangw on 2019/7/8.
 */
public class IntToHex {
    // 每次向右移动4位， 然后和1111 与
    String IntegerToHex(int num){
        if (num == 0) return "0";
        char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            //15 --> 1111
            sb.append(map[num&15]);
            num = num>>>4;
        }
        return  sb.toString();
    }
}
