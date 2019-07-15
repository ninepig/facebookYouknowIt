package String;

/**
 * Created by yangw on 2019/7/10.
 */
public class addString {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i =num1.length()-1, j = num2.length() -1 ; i >= 0 || j >= 0;){
            if (i >= 0){
                carry += num1.charAt(i) - '0' ;
                i--;
            }
            if (j >= 0){
                carry += num2.charAt(j) - '0';
                j--;
            }
            int digit = carry % 10;
            carry = carry / 10;
            sb.insert(0,digit);
        }
        if (carry!= 0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }
}
