package com.zlj.other;

public class PowerMod {
    /**
     * @return a ** b % 3
     */
    public static int powermod(int a, int b, int c){
        int ans = 1;
        while (b > 0){
            if (b % 2 == 1) {
                ans = (ans * a) % c;
            }
            b = b / 2;
            a = (a * a) % c;
            System.out.println(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(powermod(3, 19, 1000000007));
        System.out.println(powermod(3, 40,  1000000007) * 3 %  1000000007);
    }
}
