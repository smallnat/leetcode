package cn.lizh.leetcode.l16;


public class Solution {
    // 数字求和问题
    // 3个数的和
    // 先来暴力的
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int closest = Math.abs(result - target);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < closest) {
                        result = sum;
                        closest = Math.abs(target - sum);
                    }
                }
            }
        }
        return result;
    }

    // 之前做过。。排序，双指针。。但没有印象了

}
