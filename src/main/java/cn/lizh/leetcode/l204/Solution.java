package cn.lizh.leetcode.l204;

public class Solution {

    public int countPrimes(int n) {
        if (n <= 2) { // 直接能观察到的边界情况
            return 0;
        }

        int[] nums = new int[n - 2];
        for (int i = 2; i < n; i++) {
            for (int j = 2; j * j < i; j++) {
                if (i != j && i % j == 0) {
                    nums[i - 2] = 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum++;
            }
        }

        return sum;

    }
}
