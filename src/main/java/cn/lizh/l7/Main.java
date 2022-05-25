package cn.lizh.l7;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Integer>> cases = new ArrayList<CaseBase<Param, Integer>>();

    static {
        cases.add(new CaseBase<Param, Integer>(new Param(123), 321));
        cases.add(new CaseBase<Param, Integer>(new Param(-123), -321));
        cases.add(new CaseBase<Param, Integer>(new Param(120), 21));
        cases.add(new CaseBase<Param, Integer>(new Param(0), 0));
        cases.add(new CaseBase<Param, Integer>(new Param(1534236469), 0));
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        for (CaseBase<Param, Integer> aCase : cases) {
            Param param = aCase.getParams();
            Integer result = solution.reverse(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
    }
}
