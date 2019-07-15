package String;

/**
 * Created by yangw on 2019/7/10.
 */
public class compressString {
    public int compress(char[] chars) {
        if (chars == null || chars.length ==0){
            return 0;
        }
        int index = 0;
        while (index < chars.length ){
            char current = chars[index];
            int count = 0;
            while (count < chars.length && chars[index] == current){
                count++;
                index++;
            }
            chars[index++] = current;
            if (count!=1){
                for (char c: Integer.toString(count).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}