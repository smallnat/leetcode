package cn.lizh.l12;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, String>> cases = new ArrayList<CaseBase<Param, String>>();

    static {
        cases.add(new CaseBase<Param, String>(new Param(1), "I"));
        cases.add(new CaseBase<Param, String>(new Param(2), "II"));
        cases.add(new CaseBase<Param, String>(new Param(3), "III"));
        cases.add(new CaseBase<Param, String>(new Param(4), "IV"));
        cases.add(new CaseBase<Param, String>(new Param(5), "V"));
        cases.add(new CaseBase<Param, String>(new Param(6), "VI"));
        cases.add(new CaseBase<Param, String>(new Param(7), "VII"));
        cases.add(new CaseBase<Param, String>(new Param(8), "VIII"));
        cases.add(new CaseBase<Param, String>(new Param(9), "IX"));
        cases.add(new CaseBase<Param, String>(new Param(9), "IX"));
        cases.add(new CaseBase<Param, String>(new Param(1994), "MCMXCIV"));
        cases.add(new CaseBase<Param, String>(new Param(20), "XX"));
        cases.add(new CaseBase<Param, String>(new Param(60), "LX"));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, String> aCase : cases) {
            Param param = aCase.getParams();
            String result = solution.intToRoman(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
