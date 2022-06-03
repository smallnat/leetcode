package cn.lizh.leetcode.l27;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Integer>> cases = new ArrayList<>();

    static {
        cases.add(new CaseBase<>(new Param(10), 4));
        cases.add(new CaseBase<>(new Param(3), 1));
        cases.add(new CaseBase<>(new Param(1), 0));
        cases.add(new CaseBase<>(new Param(2), 0));
        cases.add(new CaseBase<>(new Param(5), 2)); // 2, 3
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, Integer> aCase : cases) {
            Param param = aCase.getParams();
            Integer result = solution.countPrimes(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
