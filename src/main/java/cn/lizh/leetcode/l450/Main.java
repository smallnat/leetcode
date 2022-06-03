package cn.lizh.leetcode.l450;

import cn.lizh.CaseBase;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<CaseBase<Param, TreeNode>> cases = new ArrayList<>();

    static {
        cases.add(new CaseBase<>(new Param(new TreeNode(), 2), new TreeNode()));
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution solution = new Solution();
        for (CaseBase<Param, TreeNode> aCase : cases) {
            Param param = aCase.getParams();
            TreeNode result = solution.deleteNode(param.getRoot(), param.getKey());
            String message = "aCase=" + aCase.toString() + "\nresult=" + result;
            Assert.isTrue(aCase.getResult().equals(result), message);
        }
        System.out.println("cost time : " + (System.currentTimeMillis() - start) + "ms");
    }
}
