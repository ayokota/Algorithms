package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ayokota on 8/18/20.
 */
public class FreqStack {
    class Node {
        int val;
        int order;
        int freq;
        public Node (int val, int order, int freq) {
            this.val = val;
            this.order = order;
            this.freq = freq;
        }
    }

    Map<Integer, Integer> frequencyMap;
    PriorityQueue<Node> maxHeap;
    int order;

    public FreqStack() {
        order = 1;
        frequencyMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) ->{


            if(a.freq != b.freq)
                return b.freq - a.freq;

            return b.order - a.order;
        });
    }

    public void push(int x) {
        int count = frequencyMap.getOrDefault(x, 0) + 1;
        frequencyMap.put(x, count);

        maxHeap.add(new Node(x, order++, count));
    }

    public int pop() {
        Node result = maxHeap.poll();

        int count = frequencyMap.get(result.val) - 1;
        frequencyMap.put(result.val, count);

        return result.val;
    }

    public static void main(String[] args) {
        FreqStack f = new FreqStack();
        f.push(5);
        f.push(7);
        f.push(5);
        f.push(7);
        f.push(4);
        f.push(5);
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());

    }
}