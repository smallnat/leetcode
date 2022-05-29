package cn.lizh.leetcode.l187;


import java.util.*;

public class Solution {

    // 使用HashSet替代HashMap
    // 使用hashcode替代string
    // 错误： 会有hash碰撞-> 重写一个hash方法，使不会产生碰撞
    // 滑动窗口计算hashcode，而不是单独的方法计算
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int keyHashCode = 0;
        for (int i = 0; i < 9; i++) {
            keyHashCode = (keyHashCode << 2) | map.get(s.charAt(i));
        }
        for (int i = 0; i < s.length() - 9; i++) {
            keyHashCode = ((keyHashCode << 2) | map.get(s.charAt(i + 9))) & ((1 << 20) - 1);
            if (!set.contains(keyHashCode)) {
                set.add(keyHashCode);
            } else {
                resultSet.add(s.substring(i, i + 10));
            }
        }

        return new ArrayList<>(resultSet);
    }


    // 使用HashSet替代HashMap
    // 使用hashcode替代string
    // 错误： 会有hash碰撞-> 重写一个hash方法，使不会产生碰撞
    public List<String> findRepeatedDnaSequences6(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            int keyHashCode = myHashCode(key);;
            if (!set.contains(keyHashCode)) {
                set.add(keyHashCode);
            } else {
                resultSet.add(key);
            }
        }

        return new ArrayList<>(resultSet);
    }

    private static Map<Character, Integer> map = new HashMap<Character, Integer>(4) {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    // 自定义的hashcode方法
    // 因为基因序列中只有4中字符 ACGT
    // 分别使用00，01， 10， 11 表示
    private int myHashCode1(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (map.get(key.charAt(i)) << 2 * (9 - i));
        }
        return sum;
    }

    // 并没有比上一种方法有性能的提升。--> 滑动窗口，就是不需要每次都全重新计算。
    // 这里虽然用了位操作，但每个字段串都要重新计算；
    // 滑动窗口，第一个字符串计算后，后一个字符串只要在之前的字符串上简单叠加计算就可以了
    private int myHashCode(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum = (sum << 2) | map.get(key.charAt(i));
        }
        return sum;
    }

    // 使用HashSet替代HashMap
    // 使用hashcode替代string
    // 错误： 会有hash碰撞-> 重写一个hash方法，使不会产生碰撞
    public List<String> findRepeatedDnaSequences5(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            int keyHashCode = key.hashCode();
            if (!set.contains(keyHashCode)) {
                set.add(keyHashCode);
            } else {
                resultSet.add(key);
            }
        }

        return new ArrayList<>(resultSet);
    }

    // 使用HashSet替代HashMap
    public List<String> findRepeatedDnaSequences4(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (resultSet.contains(key)) {  // 从官网测试结果看，这里去掉，反而性能更好
                continue;
            }
            if (!set.contains(key)) {
                set.add(key);
            } else {
                resultSet.add(key);
            }
        }

        return new ArrayList<>(resultSet);
    }

    // 使用HashSet替代HashMap
    public List<String> findRepeatedDnaSequences3(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (resultList.contains(key)) {
                continue;
            }
            if (!set.contains(key)) {
                set.add(key);
            } else {
                resultList.add(key);
            }
        }

        return resultList;
    }

    // 不需要统计每个出现的次数，主要判断以前是否出现过
    public List<String> findRepeatedDnaSequences2(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            if (resultList.contains(key)) {
                continue;
            }
            if (tempMap.get(key) != null) { // 只判断之前是否有，需要知道具体有多少个
                tempMap.put(key, 1);
            } else {
                resultList.add(key);
            }
        }

        return resultList;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        // 将所有可能的情况写到map中
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String key = s.substring(i, i + 10);
            tempMap.merge(key, 1, Integer::sum);
        }
        // 遍历map
        List<String> resultList = new ArrayList<>();
        tempMap.forEach((key, value) -> {
            if (value > 1) {
                resultList.add(key);
            }
        });

        return resultList;
    }
}
