package cn.lizh.l11;

public class Solution {
    public int maxArea(int[] x) {
        int first = 0;
        int end = x.length - 1;
        int max = Math.min(x[first], x[end]) * (end - first);
        while (first < end) {
            if (x[first] > x[end]) {
                // 移动尾指针，直到出现比当前数大的
                int temp = x[end];
                do {
                    end--;
                } while (x[end] <= temp && end > first);
            } else {
                int temp = x[first];
                do {
                    first++;
                } while (temp >= x[first]  && end > first);
            }
            if (end > first) {
                max = Math.max(max, Math.min(x[first], x[end]) * (end - first));
            }
        }
        return max;
    }
}
