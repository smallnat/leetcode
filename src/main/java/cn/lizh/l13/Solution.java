package cn.lizh.l13;

public class Solution {

    // 定义两个相同大小的数组
    String[] roman = new String[]{"CM", "M", "CD", "D", "XC", "C", "XL", "L", "IX", "X", "IV", "V", "I"};
    int[] number = new int[]{900, 1000, 400, 500, 90, 100, 40, 50, 9, 10, 4, 5, 1};

    // 数字相减
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < roman.length; i++) {
            while (s.startsWith(roman[i])) {
                num += number[i];
                s = s.substring(roman[i].length());
            }
        }
        return num;
    }

}
