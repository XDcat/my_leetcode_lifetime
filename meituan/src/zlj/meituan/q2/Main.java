package zlj.meituan.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = in.nextInt();
        }
        Main main = new Main();
        System.out.println(main.solve(k, colors));
    }

    public int solve(int k, int[] colors) {
        if (colors.length == 0) {
            return 0;
        }
        // res
        int count = 0;
        // windows
        int lo = 0;
        int hi = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(colors[0], 1);
        while (hi < colors.length) {
            while (map.size() <= k) {
                ++hi;
                if (hi >= colors.length){
                    break;
                }
                int c = colors[hi];
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            count = Math.max(count, hi - lo);
            if (hi >= colors.length){
                break;
            }
            // remove valid hi
            mapRemove(map, colors[hi]);
            --hi;
            // update lo
            mapRemove(map, colors[lo]);
            ++lo;
        }

        return count;
    }

    private void mapRemove(Map<Integer, Integer> map, int color) {
        int value = map.get(color);
        if (value <= 1){
            map.remove(color);
        } else {
            map.put(color, value - 1);
        }
    }


}
