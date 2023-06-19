package com.zlj.leetcode.normal.q1803;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 4, 2, 7};
        int res = solution.countPairs(nums, 2, 6);
        System.out.println(res);
    }
}

class Solution {
    private final static int MAX_SIZE = 15;
    private Trie root;
    public int countPairs(int[] nums, int low, int high) {
        return count(nums, high) - count(nums, low - 1);
    }

    private int count(int[] nums, int x){
        root = new Trie();
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            res += search(x, nums[i]);
        }
        return res;
    }

    private void add(int n){
        Trie cur = root;
        for (int i = MAX_SIZE; i >=0 ; i--){
            int child = (n >> i) & 1;
            if (cur.children[child] == null){
                cur.children[child] = new Trie();
            }
            cur = cur.children[child];
            cur.count++;
        }
    }

    private int search(int target, int n){
        Trie cur = root;
        int count = 0;
        for (int i = MAX_SIZE; i >= 0; i--){
            int child = (n >> i) & 1;
            if (((target >> i) & 1) == 0){
                // 没有满足条件的值，继续搜索
                if (cur.children[child] == null) {
                    // 无法搜索，停止
                    return count;
                }
                cur = cur.children[child];
            } else {
                // 要找不同的值
                //  * 如果存在，继续搜索；
                //  * 如果不存在，返回结果；
                if (cur.children[child] != null) {
                    // 相同的，肯定是小于target，则增加个数
                    // 这也是唯一增加的地方
                    count += cur.children[child].count;
                }

                if (cur.children[child ^ 1] == null){
                    return count;
                } else {
                    cur = cur.children[child ^ 1];
                }
            }
        }
        /*
        上述两种判断继续选择下面的节点，所以需要再对最有一个节点进行判断
            * 如果 target 最后一位为 0，则当前位也为 0，执行增加操作；
            * 如果 target 最后一位为 1，则当前位位不同的那个，异或结果为 0，执行增加操作；
        其实，进入下一个节点隐含的条件就是满足条件，继续搜索。
         */
        count += cur.count;
        return count;
    }
}

class Trie{
    Trie[] children = new Trie[2];
    int count = 0;
}
