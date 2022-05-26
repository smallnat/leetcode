package cn.lizh.other.fbnq;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("fbnq2(45) = " + fbnq2(45) + ". cost: " + (System.currentTimeMillis() - start) + "ms");
    }

    // 递归
    // fbnq(30) = 832040. cost: 3ms
    // fbnq(40) = 102334155. cost: 317ms
    // fbnq(45) = 1134903170. cost: 3515ms
    private static int fbnq(int i) {
        if (i == 1 || i == 2) {
            return  1;
        }
        return fbnq(i - 2) + fbnq(i - 1);
    }

    // 这个就是简化版的动态规划
    // 用两个临时变量记录
    // fbnq2(30) = 832040. cost: 0ms
    // fbnq2(40) = 102334155. cost: 1ms
    // fbnq2(45) = 1134903170. cost: 0ms
    private static int fbnq2(int i) {
        int temp1 = 1;
        int temp2 = 1;
        int cur = 0;
        for (int j = 3; j <= i; j++) {
            cur = temp1 + temp2;
            temp1 = temp2;
            temp2 = cur;
        }
        return cur;
    }
}
