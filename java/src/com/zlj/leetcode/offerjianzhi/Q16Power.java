package com.zlj.leetcode.offerjianzhi;

public class Q16Power {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.myPow(3, 3));
        System.out.println(s.myPow(3, 0));
        System.out.println(s.myPow(2, -2147483648));
    }

    class Solution1 {
        public double myPow(double x, int n) {
            if (n == 0 || x == 1.0) {
                return 1;
            }

            double res = x;
            for (int i = 0; i < Math.abs(n) - 1; i++) {
                res *= x;
            }
            if (n > 0) {
                return res;
            } else {
                return 1 / res;
            }
        }
    }

    static class Solution2 {
        public double myPow(double x, int n) {
            long N = n;
            return (n > 0) ? quickMul(x, N) : 1 / quickMul(x, -N);
        }

        private double quickMul(double x, long n) {
            if (n == 0) {
                return 1.0;
            }

            double y = quickMul(x, n / 2);
            return (n % 2 == 1) ? y * y * x : y * y;
        }
    }

    static class Solution3 {
        public double myPow(double x, int n) {
            long N = n;
            return (n > 0) ? quickMul(x, N) : 1 / quickMul(x, -N);
        }

        private double quickMul(double x, long n) {
            double res = 1.0;
            double contribution = x;
            while (n > 0) {
                if (n % 2 == 1) {
                    res *= contribution;
                }
                contribution *= contribution;
                n = n / 2;
            }
            return res;
        }
    }
}
