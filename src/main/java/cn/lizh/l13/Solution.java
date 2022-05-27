package cn.lizh.l13;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<String, Integer> ALB_NUM = new HashMap<String, Integer>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    // 定义两个相同大小的数组
    String[] roman = new String[]{"CM", "M", "CD", "D", "XC", "C", "XL", "L", "IX", "X", "IV", "V", "I"};
    int[] number = new int[]{900, 1000, 400, 500, 90, 100, 40, 50, 9, 10, 4, 5, 1};

    // 穷举
    public int romanToInt1(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'C') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'M') {
                        num += ALB_NUM.get("CM");
                        i++;
                    } else if (s.charAt(i + 1) == 'D') {
                        num += ALB_NUM.get("CD");
                        i++;
                    } else {
                        num += ALB_NUM.get("C");
                    }
                } else {
                    num += ALB_NUM.get("C");
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'C') {
                        num += ALB_NUM.get("XC");
                        i++;
                    } else if (s.charAt(i + 1) == 'L') {
                        num += ALB_NUM.get("XL");
                        i++;
                    } else {
                        num += ALB_NUM.get("X");
                    }
                } else {
                    num += ALB_NUM.get("X");
                }
            } else if (s.charAt(i) == 'I') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'X') {
                        num += ALB_NUM.get("IX");
                        i++;
                    } else if (s.charAt(i + 1) == 'V') {
                        num += ALB_NUM.get("IV");
                        i++;
                    } else {
                        num += ALB_NUM.get("I");
                    }
                } else {
                    num += ALB_NUM.get("I");
                }
            } else {
                num += ALB_NUM.get(String.valueOf(s.charAt(i)));
            }
        }

        return num;
    }


    // 通过穷举后归纳。
    public int romanToInt(String s) {
        int num = 0;
        // 获取1个获取2个字符

        for (int i = 0; i < s.length(); ) {
            String single = s.substring(i, i + 1);
            if (i < s.length() - 1) {
                String d = s.substring(i, i + 2);
                if (ALB_NUM.get(d) != null) {
                    num += ALB_NUM.get(d);
                    i += 1;
                } else {
                    num += ALB_NUM.get(single);
                }
            } else {
                num += ALB_NUM.get(single);
            }
            i++;
        }

        return num;
    }

}
