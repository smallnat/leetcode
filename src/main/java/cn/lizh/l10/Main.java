package cn.lizh.l10;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, Boolean>> cases = new ArrayList<CaseBase<Param, Boolean>>();

    static {
        cases.add(new CaseBase<Param, Boolean>(new Param(123), false));
        cases.add(new CaseBase<Param, Boolean>(new Param(121), true));
        cases.add(new CaseBase<Param, Boolean>(new Param(-121), false));
        cases.add(new CaseBase<Param, Boolean>(new Param(10), false));
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        for (CaseBase<Param, Boolean> aCase : cases) {
            Param param = aCase.getParams();
            Boolean result = solution.isPalindrome(param.getX());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
    }
}
