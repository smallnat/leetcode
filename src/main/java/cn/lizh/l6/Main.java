package cn.lizh.l6;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, String>> cases = new ArrayList<CaseBase<Param, String>>();

    static {
        cases.add(new CaseBase<Param, String>(new Param("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR"));
        cases.add(new CaseBase<Param, String>(new Param("PAYPALISHIRING", 4), "PINALSIGYAHRPI"));
        cases.add(new CaseBase<Param, String>(new Param("A", 1), "A"));
    }



    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, String> aCase : cases) {
            String result = solution.convert(aCase.getParams().getX(), aCase.getParams().getNumRows());
            String message = "*** " + aCase.toString() + "\nresult=" + result;
            try {
                Assert.isTrue(aCase.getResult().equals(result), message);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }

}
