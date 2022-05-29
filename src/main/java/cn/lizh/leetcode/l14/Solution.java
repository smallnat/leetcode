package cn.lizh.leetcode.l14;


public class Solution {

    public String longestCommonPrefix(String[] strs) {
        // 获取最短字符串长度
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        // 遍历所有的字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char cur = strs[0].charAt(i);
            boolean bEqual = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != cur) {
                    bEqual = false;
                    break;
                }
            }
            if (bEqual) {
                sb.append(cur);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
