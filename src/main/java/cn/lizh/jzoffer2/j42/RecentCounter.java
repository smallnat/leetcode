package cn.lizh.jzoffer2.j42;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> times;
    private int windowSize;

    public RecentCounter() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (times.peek() + windowSize < t) {
            times.poll();
        }
        return times.size();
    }
}
