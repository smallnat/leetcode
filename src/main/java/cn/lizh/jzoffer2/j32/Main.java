package cn.lizh.jzoffer2.j32;

public class Main {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isMatch(String s, String t) {
        if (s == null || t == null) {  // 其中之一为null
            return false;
        }
        if (s.length() != t.length()) { // 长度不相当
            return false;
        }
        if (s.isEmpty()) { // 空字符串 是否应该去掉
            return false;
        }

        // 统计每个字符的个数
        // 使用26长度的数组
        int[] letters = new int[26];  // 是否要初始化为0？
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            letters[index] += 1;
        }

        int[] lettert = new int[26];  // 是否要初始化为0？
//        for (int i = 0; i < t.length(); i++) {
//            int index = t.charAt(i) - 'a';
//            lettert[index] += 1;
//        }
        // 上面的统计，可更改为以下方式
        for (char ch : t.toCharArray()) {   // toCharArray 创建了一个新的数组； charAt直接使用String内部的数组
            lettert[ch - 'a']++;  // 对于+1/-1操作记得使用++/--操作
        }

        // 判断数组中每个值是否相等，并不需要等计算完结果
        for (int i = 0; i < 26; i++) {
            if (letters[i] != lettert[i]) {
                return false;
            }
        }
        return true;
    }

    // 参考书本代码，重写
    // 时间复杂度： O(n)
    // 空间复杂度： O(1)
    private static boolean isAnagram(String s, String t) {
        // 外面确保字符串不为空
        if (s.length() != t.length()) { // 长度不等
            return false;
        }
        int[] ss = new int[26];
        for (char ch : s.toCharArray()) {
            ss[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (ss[ch - 'a'] == 0) {
                return false;
            }
            ss[ch - 'a']--;
        }
        return true;
    }
}
