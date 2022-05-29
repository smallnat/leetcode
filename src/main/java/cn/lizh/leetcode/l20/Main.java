package cn.lizh.leetcode.l20;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Boolean>> cases = new ArrayList<>();

    static {
        cases.add(new CaseBase<>(new Param("{}"), true));
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, Boolean> aCase : cases) {
            Param param = aCase.getParams();
            Boolean result = solution.isValid(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
