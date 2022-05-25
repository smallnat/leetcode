package cn.lizh.l9;

public class Solution {
    public boolean isPalindrome1(int x) {
        // 转为字符数组，然后双指针
        char[] ch = Integer.toString(x).toCharArray();
        int len = ch.length;
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            if (ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        // 如果是负数，肯定是false
        if (x < 0) {
            return false;
        }
        // 如果是0，肯定是true
        if (x == 0) {
            return true;
        }
        // 最后一位为0，肯定为false
        if (x % 10 == 0) {
            return false;
        }
        // 如果是正数，通过不停的获取最左值和最右值来判断是否为回文
        // 难点：最左数字的获取? 能够获取数字的位数
        // 先转为字符数组?
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % 10);
            x = x / 10;
        }
        char[] ch = sb.toString().toCharArray();
        int len = ch.length;
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            if (ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
    }

    // 主要在于临界的判断:翻转一半的数字，什么时候到一半
    // 可以翻转所有的数字，要出来int数字溢出
    public boolean isPalindrome(int x) {
        // 如果是负数，肯定是false
        if (x < 0) {
            return false;
        }
        // 如果是0，肯定是true
        if (x == 0) {
            return true;
        }
        // 最后一位为0，肯定为false
        if (x % 10 == 0) {
            return false;
        }
        // 翻转一半数字
        int left = x;
        int right = 0;
        while (true) {
            int t = left % 10;
            left = left / 10;
            if (right == left || right * 10 + t == left) {
                return true;
            } else if (right * 10 + t > left) {
                return false;
            }
            right = right * 10 + t;
        }
    }
}
