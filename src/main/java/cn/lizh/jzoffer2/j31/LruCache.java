package cn.lizh.jzoffer2.j31;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 可采用hashmap + 链表
public class LruCache<K, V> {
    private static int maxCap = 1000; // 最大容量
    private int linkNum; // 当前已存数据量
    private Map<K, V> map = new HashMap<>();
    private LinkedList<K> list = new LinkedList<>();

    // 获取
    public V get(K key) {
        // 怎么将链表中的数据移到 表尾？找到key值的时间复杂度为O(n)
        // 允许链表中存在相同的数据，这样就不用找到原来值得位置了。链表数据会越来越长
        list.add(key);
        if (list.getFirst().equals(key)) {
            list.removeFirst();
        }
        return map.get(key);
    }

    // 设置
    public void put(K key, V value) {
        // 先看该值是否存在
        if (map.containsKey(key)) {

        }
        if (map.size() >= maxCap) {
            // 需要删除一个
//            list.getFirst()
        }
//        map.get(key)
    }
}
