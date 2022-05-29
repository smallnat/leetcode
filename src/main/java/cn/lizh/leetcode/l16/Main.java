package cn.lizh.leetcode.l16;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Integer>> cases = new ArrayList<>();

    static {
        cases.add(new CaseBase<>(new Param(new int[]{-1, 2, 1, -4}, 1), 2));
        cases.add(new CaseBase<>(new Param(new int[]{0, 0, 0}, 1), 0));
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, Integer> aCase : cases) {
            Param param = aCase.getParams();
            Integer result = solution.threeSumClosest(param.getNums(), param.getTarget());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
