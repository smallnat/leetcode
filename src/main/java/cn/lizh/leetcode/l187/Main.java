package cn.lizh.leetcode.l187;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, List<String>>> cases = new ArrayList<>();

    static {
        cases.add(new CaseBase<>(new Param("AAAAAAAAAAA"), new ArrayList<String>(){{add("AAAAAAAAAA");}}));
        cases.add(new CaseBase<>(new Param("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"), new ArrayList<String>(2){{
            add("AAAAACCCCC");
            add("CCCCCAAAAA");
        }}));
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, List<String>> aCase : cases) {
            Param param = aCase.getParams();
            List<String> result = solution.findRepeatedDnaSequences(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
