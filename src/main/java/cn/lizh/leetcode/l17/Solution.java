package cn.lizh.leetcode.l17;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) { // 数字长度为0
            return combinations;
        }

        // 数字和字符的对应表
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        // 关键在于回溯函数的设计
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    // 递归
    // 为什么这里叫回溯？
    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) { // 如果是最后一个数字了。
            combinations.add(sb.toString());
        } else {
            char digit = digits.charAt(index); // 获取单个数字，从第0个数字开始获取
            String letters = phoneMap.get(digit); // 获取数字对应的字符串
            int lettersCount = letters.length(); // 字符串长度
            for (int i = 0; i < lettersCount; i++) {  // 这个循环是关键。
                sb.append(letters.charAt(i));  // 取其中一个字符，写到字符串中。
                backtrack(combinations, phoneMap, digits, index + 1, sb);  // 这里会继续在第一个字符上增加其他的字符，直到最后一个放入结果List中
                sb.deleteCharAt(index); // 删除sb中的字符
            }
        }
    }
}
