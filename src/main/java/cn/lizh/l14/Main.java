package cn.lizh.l14;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, String>> cases = new ArrayList<CaseBase<Param, String>>();

    static {
        cases.add(new CaseBase<Param, String>(new Param(new String[]{"flower","flow","flight"}), "fl"));
        cases.add(new CaseBase<Param, String>(new Param(new String[]{"dog","racecar","car"}), ""));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, String> aCase : cases) {
            Param param = aCase.getParams();
            String result = solution.longestCommonPrefix(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
