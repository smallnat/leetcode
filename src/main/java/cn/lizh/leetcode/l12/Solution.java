package cn.lizh.leetcode.l12;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Integer, String> ALB_NUM = new HashMap<Integer, String>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    // 穷举
    public String intToRoman1(int num) {
        // 个位数
        int i = num % 10;
        int s = num / 10;

        StringBuilder sb1 = new StringBuilder();
        if (i < 4) {
            for (int j = 0; j < i; j++) {
                sb1.append(ALB_NUM.get(1));
            }
        } else if (i == 4 || i == 5 || i == 9) {
            sb1.append(ALB_NUM.get(i));
        } else {
            sb1.append(ALB_NUM.get(5));
            for (int j = 0; j < i - 5; j++) {
                sb1.append(ALB_NUM.get(1));
            }
        }

        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        // 十位数
        if (s > 0) {
            i = s % 10;
            s = s / 10;
            if (i < 4) {
                for (int j = 0; j < i; j++) {
                    sb2.append(ALB_NUM.get(10));
                }
            } else if (i == 4 || i == 5 || i == 9) {
                sb2.append(ALB_NUM.get(i * 10));
            } else {
                sb2.append(ALB_NUM.get(50));
                for (int j = 0; j < i - 5; j++) {
                    sb2.append(ALB_NUM.get(10));
                }
            }

            // 百位数
            if (s > 0) {
                i = s % 10;
                s = s / 10;
                if (i < 4) {
                    for (int j = 0; j < i; j++) {
                        sb3.append(ALB_NUM.get(100));
                    }
                } else if (i == 4 || i == 5 || i == 9) {
                    sb3.append(ALB_NUM.get(i * 100));
                } else {
                    sb3.append(ALB_NUM.get(500));
                    for (int j = 0; j < i - 5; j++) {
                        sb3.append(ALB_NUM.get(100));
                    }
                }
            }

            // 千位数
            if (s > 0) {
                i = s % 10;
                for (int j = 0; j < i; j++) {
                    sb4.append(ALB_NUM.get(1000));
                }
            }
        }


        return sb4.append(sb3).
                append(sb2).
                append(sb1).
                toString();
    }

    // 定义两个相同大小的数组
    String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] number = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    // 数字相减
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            while (num >= number[i]) {
                sb.append(roman[i]);
                num -= number[i];
            }
        }
        return sb.toString();
    }

}
