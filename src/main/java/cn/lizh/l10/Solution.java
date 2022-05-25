package cn.lizh.l10;

public class Solution {
    public boolean isMatch(String s, String p) {
        // 从左往右判断字符串中的字符是否相等
        int j = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '.') {
                // 匹配任意个任意字符
                // 也就是可以匹配0个或者多个字符。匹配完后，还要看在字符串p是否还有字符，校验后面的字符是否匹配
            }
            if (ch == '*') {
                // 匹配多个前面的字符，由题目保证 p.charAt(i - 1) 不会越界
                char beforeCh = p.charAt(i - 1);
                char afterCh = p.charAt(i + 1); // 是否后面还有字符，需要判断
            }
//            for (int j = 0; j < s.length(); j++) {
//
//            }

        }
        return true;
    }
}
