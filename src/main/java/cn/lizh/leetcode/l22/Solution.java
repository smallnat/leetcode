package cn.lizh.leetcode.l22;


import java.util.*;

public class Solution {

    // 左括号的数量 open; 右括号的数量 close
    public List<String> generateParenthesis(int n) {
        // 回溯
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        backtrace(ans, cur, 0, 0, n);
        return ans;
    }

    /**
     * 回溯函数
     *
     * @param ans   最终结果
     * @param cur   当前字符串
     * @param open  当前使用左括号的数量
     * @param close 当前使用右括号的数量
     * @param n     左/右括号的总数量
     */
    private void backtrace(List<String> ans, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) { // 当字符串长度达到2n时，已经使用完左右的左右括号
            ans.add(cur.toString());
            return;
        }
        if (open < n) {
            // 还可以继续放左括号
            cur.append("(");
            backtrace(ans, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (open > close) {
            cur.append(")");
            backtrace(ans, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> generateParenthesis1(int n) {
        // 暴力算法，列举所有的组合可能
        // 排列组合：P(n)
        List<String> all = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int leftNum = n;
        int rightNum = n;
        String pre = "";
        return all;
    }
}
