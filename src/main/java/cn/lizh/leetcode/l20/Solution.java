package cn.lizh.leetcode.l20;


import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ('(' == cur || '{' == cur || '[' == cur) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char out = stack.pop();
                if ((')' == cur && out == '(') || ('}' == cur && out == '{') || (']' == cur && out == '[')) {
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
