package String;

/**
 * Created by yangw on 2019/7/11.
 */
public class permutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() ==0) return false;
        if(s1.length() > s2.length()) return false;

        int[] count = new int[26];
        int lengthA = s1.length() , lengthB = s2.length();
        for (int i = 0 ; i < lengthA ; i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) -'a']--;
        }
        if (AllZero(count)) return true;
        for (int i = lengthA ; i < lengthB ; i++){
            count[s2.charAt(i)- 'a']--;
            count[s2.charAt(i - lengthA) - 'a']++;
            if (AllZero(count))return true;
        }
        return false;
    }

    private boolean AllZero(int[] count) {
        for (int num : count){
            if (num!=0){
                return false;
            }
        }
        return true;
    }
}