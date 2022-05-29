package cn.lizh.leetcode.l204;

public class Solution {

    // 提供的答案也会超时。。
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += isPrimes(i) ? 1 : 0;
        }

        return ans;
    }

    private boolean isPrimes(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 以下结果不正确
    public int countPrimes1(int n) {
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
