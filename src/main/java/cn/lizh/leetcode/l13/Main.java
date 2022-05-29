package cn.lizh.leetcode.l13;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Integer>> cases = new ArrayList<CaseBase<Param, Integer>>();

    static {
        cases.add(new CaseBase<Param, Integer>(new Param("I"), 1));
        cases.add(new CaseBase<Param, Integer>(new Param("II"), 2));
        cases.add(new CaseBase<Param, Integer>(new Param("III"), 3));
        cases.add(new CaseBase<Param, Integer>(new Param("IV"), 4));
        cases.add(new CaseBase<Param, Integer>(new Param("V"), 5));
        cases.add(new CaseBase<Param, Integer>(new Param("VI"), 6));
        cases.add(new CaseBase<Param, Integer>(new Param("VII"), 7));
        cases.add(new CaseBase<Param, Integer>(new Param("VIII"), 8));
        cases.add(new CaseBase<Param, Integer>(new Param("IX"), 9));
        cases.add(new CaseBase<Param, Integer>(new Param("X"), 10));
        cases.add(new CaseBase<Param, Integer>(new Param("MCMXCIV"), 1994));
        cases.add(new CaseBase<Param, Integer>(new Param("XX"), 20));
        cases.add(new CaseBase<Param, Integer>(new Param("LX"), 60));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, Integer> aCase : cases) {
            Param param = aCase.getParams();
            Integer result = solution.romanToInt(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
