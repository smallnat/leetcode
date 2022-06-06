package cn.lizh.leetcode.l48;

public class Solution {

    // 每次都是4个数的交换
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            // 代入简单的，验证 n=4: 0,0 -> 0,3  0,3->3,3 3,3->3,0 3,0->0,0
            //                    1,1 -> 1,2
            for (int j = i; j < n - 1; j++) {
                // 顺时针旋转，则逆时针赋值
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];

                // 第n-1行，第0列 （第n-1行第2列 -> 第n-2行第1列）
                matrix[n - 1 - i][j] = matrix[n - 1 - i][n - 1 - i];

                // 第n-1行，最后一列
                matrix[n - 1 - i][n - 1 - i] = matrix[j][n - i - 1];

                // 第j行，最后一列 （第1行第2列 -> 第2行最后一列）
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    // 观察规律，使用新的空间
    public void rotate1(int[][] matrix) {
        // 新申请空间
        int len = matrix.length;
        int[][] result = new int[len][len];

        // 第 i 行 -> 第 n-i 列
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[j][len - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < len; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, len);
        }
    }
}
