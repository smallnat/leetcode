package cn.lizh.l10;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Boolean>> cases = new ArrayList<CaseBase<Param, Boolean>>();

    static {
        cases.add(new CaseBase<Param, Boolean>(new Param("aa", "a"), false));
        cases.add(new CaseBase<Param, Boolean>(new Param("aa", "a*"), true));
        cases.add(new CaseBase<Param, Boolean>(new Param("ab", ".*"), true));
        cases.add(new CaseBase<Param, Boolean>(new Param("aab", "c*a*b*"), true));
        cases.add(new CaseBase<Param, Boolean>(new Param("ab", ".*c"), false));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, Boolean> aCase : cases) {
            Param param = aCase.getParams();
            Boolean result = solution.isMatch2(param.getX(), param.getP());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
