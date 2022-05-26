package cn.lizh.l11;

// * 表示0个或者多个，关键处理0个的情况。也就意味着顺序处理过程中，需要将a*左右整体考虑，而不能先匹配a，再处理*。
public class Solution {
    public boolean isMatch(String s, String p) {
        // 从左往右判断字符串中的字符是否相等
        int j = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (ch == '.') {
                // 匹配单个任意字符
                j++;
            } else if (ch == '*') {
                // 匹配0-n个前面的字符，由题目保证 p.charAt(i - 1) 不会越界，可以是*么？
                // 假设规则表达式是精简的，不会出现 a*ada 这种 -> aa*da
                // 但会出现.*ada
                char beforeCh = p.charAt(i - 1);
                if (beforeCh == '.') {
                    // 可以匹配任何字符
                    // 后面再有字符，从哪里开始匹配？***
                    return true;
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
}
