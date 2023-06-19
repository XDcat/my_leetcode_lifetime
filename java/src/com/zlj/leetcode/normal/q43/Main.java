package com.zlj.leetcode.normal.q43;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.multiply("12", "12");
        System.out.println(res);
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }

        String res = "0";
        for (int i = num2.length() - 1; i>= 0; i--){
            StringBuilder tmp = new StringBuilder();
            // fill zero
            for (int j = 0; j < num2.length() - 1 - i; j++) {
               tmp.append(0);
            }

            int n2 = num2.charAt(i) - '0';
            int carry = 0;
            for (int j = num1.length() - 1; j >=0 || carry != 0; j--) {
                int n1 = j < 0? 0: num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                tmp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            res = add(res, tmp.reverse().toString());
        }
        return res;
    }
    private String add(String num1, String num2){
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0){
            int n1 = (i >= 0 )? num1.charAt(i) - '0': 0;
            int n2 = (j >= 0 )? num2.charAt(j) - '0': 0;
            int tmp = n1 + n2 + carry;
            res.append(tmp % 10);
            carry = tmp / 10;
            i--;
            j--;
        }

        if (carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }
}
