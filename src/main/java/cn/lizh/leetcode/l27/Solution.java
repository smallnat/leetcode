package cn.lizh.leetcode.l27;

import java.util.Arrays;

public class Solution {

    /**
     * 删除元素
     *
     * @param nums 数字数组
     * @param val  删除的数字
     * @return  删除元素后新数组的长度
     */
    public int removeElement(int[] nums, int val) {
        // 数组删除数据，可能会使其他数据也不停的移动
        // 先替换数字，然后统一排序。因为题目中原数字最大为100，将==val的数字替换为101，然后再排序
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
                ans--;
            }
        }
        Arrays.sort(nums);  // 快速排序
        return ans;
    }
}
