package cn.lizh.leetcode.l15;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, List<List<Integer>>>> cases = new ArrayList<CaseBase<Param, List<List<Integer>>>>();

    static {
        // 输出：[[-1,-1,2],[-1,0,1]]
        List<List<Integer>> result = new ArrayList<List<Integer>>(){{
            add(Arrays.asList(-1, -1, 2));
            add(Arrays.asList(-1,0,1));
        }};

        cases.add(new CaseBase<Param, List<List<Integer>>>(new Param(new int[]{-2,0,1,1,2}), new ArrayList<List<Integer>>(){{
            add(Arrays.asList(-2,0,2));
            add(Arrays.asList(-2,1,1));
        }}));
        cases.add(new CaseBase<Param, List<List<Integer>>>(new Param(new int[]{-1,0,1,2,-1,-4}), result));
        cases.add(new CaseBase<Param, List<List<Integer>>>(new Param(new int[]{}), new ArrayList<>()));
        cases.add(new CaseBase<Param, List<List<Integer>>>(new Param(new int[]{0}), new ArrayList<>()));
        cases.add(new CaseBase<Param, List<List<Integer>>>(new Param(new int[]{0, 0, 0, 0}), new ArrayList<List<Integer>>(){{
            add(Arrays.asList(0, 0, 0));
        }}));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, List<List<Integer>>> aCase : cases) {
            Param param = aCase.getParams();
            List<List<Integer>> result = solution.threeSum(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
