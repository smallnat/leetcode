package cn.lizh.other.it;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        // 循环中删除
        // 抛异常： java.util.ConcurrentModificationException  并发修改异常
        for (Integer num : list) {
            if (num == 40) {
                list.remove(num);
            }
        }

        // 通过迭代器删除某个元素 50
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 50) {
                it.remove();
            }
        }

        list.forEach(System.out::println);
    }


}
