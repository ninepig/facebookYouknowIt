package String;

import sun.security.util.Length;

/**
 * Created by yangw on 2019/7/10.
 */
public class multplyString {
    public String multiply(String num1, String num2) {
        int lengthA = num1.length(), lengthB = num2.length();
        int[] prodcut = new int[lengthA + lengthB];
        for (int i = lengthA - 1; i >= 0 ;i--){
            for (int j = lengthB - 1 ; j >= 0 ; j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                prodcut[i+j+1] += a*b;
            }
        }
        int carry = 0;
        for (int i = prodcut.length - 1 ; i>=0 ; i--){
            int temp = (prodcut[i] + carry)%10;
            carry = (prodcut[i] + carry) / 10;
            prodcut[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for(int num : prodcut){
            sb.append(num);
        }
        while (sb.length()!=0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}