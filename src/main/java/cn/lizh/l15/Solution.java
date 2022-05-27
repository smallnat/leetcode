package cn.lizh.l15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // 如何去掉重复的？
    // 不容易。。终于调试过了。但逻辑没有理的很清楚。
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 对数组进行排序
//        int[] nums = Arrays.stream(nums).sorted().toArray();
        // 看了官网的，先优化一下排序，比之前好一点。
        Arrays.sort(nums);
        
        // 固定一个，移动两个指针
        for (int i = 0; i < nums.length - 2; i++) {
            int fixedNum = nums[i];
            if (i > 0 && nums[i - 1] == fixedNum) { // 在数组的比较中，和上一个字符比较不需要临时变量
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (fixedNum + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(fixedNum, nums[j], nums[k]));
                    // 不允许重复，那同时移动指针
                    k--;
                    j++;
                    while (j< k && nums[k] == nums[k+1] ) {
                        k--;
                    }
                    while (j< k &&  nums[j] == nums[j-1]) {
                        j++;
                    }
                } else if (nums[j] + nums[k] > -fixedNum) {
                    k--;
                    while (j< k && nums[k] == nums[k+1] ) {
                        k--;
                    }

                } else if (nums[j] + nums[k] < -fixedNum) {
                    j++;
                    while (j< k && nums[j] == nums[j-1] ) {
                        j++;
                    }
                }
            }
        }
        return result;
    }


    // 不再看了，贴了官网提供的解法
    // 性能好了不止一点点
    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
