package cn.lizh.l6;

public class Solution {
    /**
     * 转换函数
     * 思路：将原来的数组转为二维数组。
     * <p>
     * 执行用时：59 ms, 在所有 Java 提交中击败了5.98%的用户
     * 内存消耗：44.4 MB, 在所有 Java 提交中击败了6.53%的用户
     * 通过测试用例：1157 / 1157
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 将一维数组转为二维数组
        // 赋值的时候，不能定位到精准位置，那么用空间解决，构建一个 numRows * s.length() 大小的二维数组
        int sl = s.length();
        char[][] target = new char[numRows][sl];
        for (int i = 0; i < s.length(); i++) {
            // 获取当前数的所在行
            int x = getX(numRows, i);
            target[x][i] = s.charAt(i);
        }

        // 遍历
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < sl; j++) {
                if (target[i][j] != '\0') {
                    sb.append(target[i][j]);
                }
            }
        }


        return sb.toString();
    }

    /**
     * 获取当前数据经过Z化后作为的行
     *
     * @param numRows 行数
     * @param idx     字符位置
     * @return
     */
    private int getX(int numRows, int idx) {
        int num = 2 * numRows - 2;
        int temp = idx % num;
        return temp >= numRows ? num - temp : temp;
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); i++) {
            // 获取当前数的所在行
            int x = getX(numRows, i);
            sbs[x].append(s.charAt(i));
        }

        // 遍历
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(sbs[i]);
        }

        return sb.toString();
    }
}
