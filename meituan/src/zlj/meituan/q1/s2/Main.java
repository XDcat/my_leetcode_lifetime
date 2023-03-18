package zlj.meituan.q1.s2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] positions = new int[n][2];
        for (int i = 0; i < n; i++) {
            positions[i][0] = in.nextInt();
            positions[i][1] = in.nextInt();
        }
        Main main = new Main();
        System.out.println(main.solve(n, x, y, positions));
    }

    public int solve(int n, int mx, int my, int[][] positions) {
        if (n == 0) {
            return 0;
        }
        int maxCount = 0;
        int positionLoX = positions[0][0];
        int positionHiX = positions[0][0];
        int positionLoY = positions[0][1];
        int positionHiY = positions[0][1];
        for (int[] position :
                positions) {
            positionLoX = Math.min(positionLoX, position[0]);
            positionHiX = Math.max(positionHiX, position[0]);

            positionLoY = Math.min(positionLoY, position[1]);
            positionHiY = Math.max(positionHiY, position[1]);
        }

        for (int curX = positionLoX; curX <= positionHiX; curX++) {
            for (int curY = positionLoY; curY <= positionHiY; curY++) {
                // up down left right
                int[][] targets = new int[][]{{mx, -my}, {-mx, -my}, {mx, my}, {-mx, my}};
                for (int[] target : targets) {
                    int count = 0;
                    int curMx = target[0];
                    int curMy = target[1];
//                System.out.printf("(%s, %s) -> (%s, %s):\n", curX, curY, curX - curMx, curY-curMy);
                    for (int j = 0; j < n; j++) {
                        // find other node
                        int distX = curX - positions[j][0];
                        int distY = curY - positions[j][1];

                        int loX = Math.min(0, curMx);
                        int hiX = Math.max(0, curMx);
                        int loY = Math.min(0, curMy);
                        int hiY = Math.max(0, curMy);

                        if (distX >= loX && distX <= hiX && distY >= loY && distY <= hiY) {
//                            System.out.printf("\t(%s, %s)\n", positions[j][0], positions[j][1]);
                            ++count;
                        }
                    }
//                System.out.printf("\tcount=%s\n", count);
                    maxCount = Math.max(maxCount, count);
                }

            }
        }
        return maxCount;
    }
}
