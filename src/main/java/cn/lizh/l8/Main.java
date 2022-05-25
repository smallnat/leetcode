package cn.lizh.l8;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Integer>> cases = new ArrayList<CaseBase<Param, Integer>>();

    static {
        cases.add(new CaseBase<Param, Integer>(new Param("42"), 42));
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        for (CaseBase<Param, Integer> aCase : cases) {
            Param param = aCase.getParams();
            Integer result = solution.myAtoi(param.getS());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
    }
}
