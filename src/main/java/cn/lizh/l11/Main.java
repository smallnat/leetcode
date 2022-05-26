package cn.lizh.l11;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Integer>> cases = new ArrayList<CaseBase<Param, Integer>>();

    static {
        cases.add(new CaseBase<Param, Integer>(new Param(new int[]{1,8,6,2,5,4,8,3,7}), 49));
        cases.add(new CaseBase<Param, Integer>(new Param(new int[]{1,1}), 1));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, Integer> aCase : cases) {
            Param param = aCase.getParams();
            Integer result = solution.maxArea(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
