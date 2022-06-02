package cn.lizh.leetcode.l22;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, List<String>>> cases = new ArrayList<>();

    static {
        cases.add(new CaseBase<>(new Param(1), new ArrayList<String>(){{add("()");}}));
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, List<String>> aCase : cases) {
            Param param = aCase.getParams();
            List<String> result = solution.generateParenthesis(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
