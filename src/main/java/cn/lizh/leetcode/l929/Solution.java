package cn.lizh.leetcode.l929;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int numUniqueEmails(String[] emails) {
        // 处理本地名后，将最终发送的邮箱写到Set中，返回Set的大小
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(trans(email));
        }
        return set.size();
    }

    private String trans(String email) {
        int atIndex = email.indexOf('@');
        String localName = email.substring(0, atIndex);
        if (localName.contains("+")) {
            localName = localName.substring(0, localName.indexOf('+'));
        }
        return localName.replaceAll("\\.", "") + email.substring(atIndex);
    }


}
