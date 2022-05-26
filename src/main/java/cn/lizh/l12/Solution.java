package cn.lizh.l12;

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

    public String intToRoman(int num) {
        // 个位数
        int i = num % 10;
        int s = num / 10;

        StringBuilder sb = new StringBuilder();
        if (i < 4) {
            for (int j = 0; j < i; j++) {
                sb.append(ALB_NUM.get(1));
            }
        }  else if (i == 4 || i == 5 || i == 9) {
            sb.append(ALB_NUM.get(i));
        } else  {
            sb.append(ALB_NUM.get(5));
            for (int j = 0; j < i - 5; j++) {
                sb.append(ALB_NUM.get(1));
            }
        }

        return sb.toString();
    }

}
