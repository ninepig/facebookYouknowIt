package palindrome;

/**
 * Created by yangw on 2019/7/11.
 */
public class PalindromeNumber {

    public boolean isPalindrom(int x){
        if ( x < 0){
            return false;
        }
        if ( x == 0){
            return true;
        }
        int newX = 0;
        int temp = x;
        while (x > 0){
            newX = newX*10 + temp%10;
            temp = temp/10;
        }
        return x == newX;
    }
}
