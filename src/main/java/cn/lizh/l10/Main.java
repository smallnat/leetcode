package cn.lizh.l10;

import cn.lizh.CaseBase;
import cn.lizh.l11.Param;
import cn.lizh.l11.Solution;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<cn.lizh.l11.Param, Boolean>> cases = new ArrayList<CaseBase<cn.lizh.l11.Param, Boolean>>();

    static {
        cases.add(new CaseBase<cn.lizh.l11.Param, Boolean>(new cn.lizh.l11.Param("aa", "a"), false));
        cases.add(new CaseBase<cn.lizh.l11.Param, Boolean>(new cn.lizh.l11.Param("aa", "a*"), true));
        cases.add(new CaseBase<cn.lizh.l11.Param, Boolean>(new cn.lizh.l11.Param("ab", ".*"), true));
        cases.add(new CaseBase<cn.lizh.l11.Param, Boolean>(new cn.lizh.l11.Param("aab", "c*a*b*"), true));
        cases.add(new CaseBase<cn.lizh.l11.Param, Boolean>(new cn.lizh.l11.Param("ab", ".*c"), false));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        cn.lizh.l11.Solution solution = new Solution();
        for (CaseBase<cn.lizh.l11.Param, Boolean> aCase : cases) {
            Param param = aCase.getParams();
            Boolean result = solution.isMatch(param.getX(), param.getP());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
