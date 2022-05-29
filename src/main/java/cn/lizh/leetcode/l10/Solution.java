package cn.lizh.leetcode.l10;

// * 表示0个或者多个，关键处理0个的情况。也就意味着顺序处理过程中，需要将a*左右整体考虑，而不能先匹配a，再处理*。
public class Solution {
    public boolean isMatch(String s, String p) {
        // 从左往右判断字符串中的字符是否相等
        int j = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '.') {
                // 匹配单个任意字符...这里不能直接，还要看下一个字符是否为* todo
                j++;
            } else if (ch == '*') {
                // 匹配0-n个前面的字符，由题目保证 p.charAt(i - 1) 不会越界，可以是*么？
                // 假设规则表达式是精简的，不会出现 a*ada 这种 -> aa*da
                // 但会出现.*aada   adfaaaada
                char beforeCh = p.charAt(i - 1);
                if (beforeCh == '.') {
                    // 可以匹配任何字符
                    // 后面再有字符，从哪里开始匹配？*** 丢多少个字符？
                    if (i + 1 < p.length()) {
                        char afterCh = p.charAt(i + 1);
                        // s可以丢弃任意个字符
                        //
                        while (s.charAt(j) != afterCh) { // 先丢掉不同的
                            j++;
                        }
                        // 字符相同的情况
                        // 因为前面是.*，所以后面的匹配可以和任意右子串
                        // todo . 这里有点复杂
                        // 这里可以选择丢掉，也可以选择不丢
                        return isMatch(p.substring(i - 1), s.substring(j));
                    } else {
                        // 后面没字符了。
                        return true;
                    }
                } else {
                    while (j < s.length() && s.charAt(j) == beforeCh) {
                        j++;
                    }
                }
            } else {
                // 除了通配符以外的其他字符
                if (ch != s.charAt(j)) {
                    if (p.charAt(i + 1) == '*') { // 如果下一个字符为"*",则字符不一致也认为匹配
                        i++;
                    } else {
                        return false;
                    }
                } else {
                    j++;
                }
            }
        }
        return j >= s.length();
    }

    // 状态转换
    // 由子字符串的状态得到
    public boolean isMatch2(String s, String p) {
        int sn = s.length() - 1;
        int pn = p.length() - 1;
        if (pn == -1 && sn == -1) {
            return true;
        }
        if (sn == -1 || pn == -1) {
            return false;
        }
        if (p.charAt(pn) == '*') {
            if (matchs(s.charAt(sn), p.charAt(pn - 1))) {
                return isMatch2(s, p.substring(0, pn - 1)) || isMatch2(s.substring(0, sn), p);
            } else {
                return isMatch2(s, p.substring(0, pn - 1));
            }
        } else {
            if (matchs(p.charAt(pn), s.charAt(sn))) {
                return isMatch2(s.substring(0, sn), p.substring(0, pn));
            } else {
                return false;
            }
        }
    }

    // p只能为字母或者.
    private boolean matchs(char s, char p) {
        return s == p || p == '.';
    }
}
