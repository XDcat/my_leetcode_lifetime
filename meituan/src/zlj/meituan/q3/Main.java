package zlj.meituan.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        Main main = new Main();
        System.out.println(main.solve(s));
    }

    public String solve(String s) {
        char[] chars = s.toCharArray();
        if (isValid(s)) {
            // valid
            return imporve(chars);
        }
        {
            // invalid
            int length = s.length();
            int n = s.length() / 2 - 1;
            List<Integer> changes = new ArrayList<>();
            // to special string
            for (int i = 0; i <= n; i++) {
                int hi = length - i - 1;
                if (chars[i] != chars[hi]) {
                    chars[hi] = chars[i];
                    changes.add(i);
                }
            }

            // improve
            if (changes.size() == 2) {
                return String.valueOf(chars);
            } else {
                char minChar = chars[0];
                for (int i = 0; i <= n; i++) {
                    minChar = (char) Math.min(minChar, chars[i]);
                }
                int changeIndex = changes.get(0);
                int n1 = minChar + chars[changeIndex] * 2;
                int n2 = chars[n + 1] + 2 * minChar;
                if (n1 <= n2) {
                    // change middle
                    chars[n + 1] = minChar;
                } else {
                    chars[changeIndex] = minChar;
                    chars[length - changeIndex - 1] = minChar;
                }
                return String.valueOf(chars);
            }
        }
    }

    private String imporve(char[] chars) {
        int length = chars.length;
        int n = chars.length / 2 - 1;
        char minChar = chars[0];
        char maxChar = chars[0];
        for (int i = 0; i <= n; i++) {
            minChar = (char) Math.min(minChar, chars[i]);
            maxChar = (char) Math.max(maxChar, chars[i]);
        }
        if (minChar != maxChar) {
            int maxCharIndex = 0;
            for (int i = 0; i <= n; i++) {
                if (chars[i] == maxChar) {
                    maxCharIndex = i;
                }
            }

            int changeIndex = maxCharIndex;
            int n1 = minChar + chars[changeIndex] * 2;
            int n2 = chars[n + 1] + 2 * minChar;
            if (n1 <= n2) {
                // change middle
                chars[n + 1] = minChar;
            } else {
                chars[changeIndex] = minChar;
                chars[length - changeIndex - 1] = minChar;
            }
        } else {
            chars[n + 1] = minChar;
        }
        return String.valueOf(chars);

    }

    private boolean isValid(String s) {
        int length = s.length();
        int n = s.length() / 2 - 1;
        // to special string
        for (int i = 0; i <= n; i++) {
            int hi = length - i - 1;
            if (s.charAt(i) != s.charAt(hi)) {
                return false;
            }
        }
        return true;
    }

}
