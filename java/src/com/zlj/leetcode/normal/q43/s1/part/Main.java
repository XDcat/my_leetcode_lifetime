package com.zlj.leetcode.normal.q43.s1.part;

public class Main {
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 || num2.length() == 1){
            return String.valueOf(
                    Integer.parseInt(num1) * Integer.parseInt(num2)
            );
        }
        // fill 0
        int maxLength = Math.max(num1.length(), num2.length());
        if (maxLength % 2 == 1) {
            maxLength++;
        }
        for (int i = 0; i < maxLength - num1.length(); i++) {
            num1 = " " + num1;
        }

        for (int i = 0; i < maxLength - num2.length(); i++) {
            num2 = " " + num2;
        }

        int n = maxLength >> 1; // divide
        String a = num1.substring(0, n), b = num1.substring(n);
        String c = num2.substring(0, n), d = num1.substring(n);
        String ac = multiply(a, c);
        String bd = multiply(b, d);

        return "";
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
        }

        if (carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }
}
