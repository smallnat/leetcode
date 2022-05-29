package cn.lizh.leetcode.l7;

public class Solution {
    public int reverse(int x) {
        char[] chOrigin = Integer.toString(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if ('-' == chOrigin[0]) {
            flag = true;
            sb.append('-');
        }
        boolean bZero = true;
        for (int i = chOrigin.length - 1; i >= 0 ; i--) {
            if (bZero && '0' != chOrigin[i]) {
                bZero = false;
            }
            if (bZero) {
                continue;
            }
            if (flag && i == 0) {
                continue;
            }
            sb.append(chOrigin[i]);
        }
        if (sb.toString().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
