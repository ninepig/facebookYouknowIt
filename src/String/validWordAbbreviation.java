package String;

/**
 * Created by yangw on 2019/7/11.
 */
public class validWordAbbreviation {
    public boolean validWordAbbreviation(String word , String abbr) {
        // edge case
        if (word == null || word.length() ==0 || abbr == null || abbr.length() ==0) return false;
        if (abbr.length() > word.length()) return  false;
        int k = 0, i = 0 , len1 = word.length(), len2 = abbr.length();

        while (i < len2){
            if (word.charAt(k) == abbr.charAt(i)){
                i++;
                k++;
                continue;
            }

            int count = 0;
            if (abbr.charAt(i) == '0') return false;
            while (Character.isDigit(abbr.charAt(i))){
                count = count * 10 + abbr.charAt(i) - '0';
                i++;
            }

            // move word
            k += count;
            if (k>len1 || word.charAt(k)!=abbr.charAt(i)) return  false;
        }

        return true;
    }
}
