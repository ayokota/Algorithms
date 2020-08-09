package practice;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ayokota on 8/8/20.
 */
public class cutOffTree {
    public int cutOffTree(List<List<Integer>> forest) {
        //trees
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        //add all trees to minHeap
        for(int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                int val = forest.get(i).get(j);
                if(val > 1) {
                    minHeap.add(new int[]{i, j, forest.get(i).get(j) });
                }
            }
        }

        int[] curLocation = new int[]{0, 0};

        int sum = 0;
        while(!minHeap.isEmpty()) {
            int[] destination = minHeap.poll();
            int steps = walk(curLocation, destination, forest);
            if(steps == -1)
                return -1;
            sum += steps;
            curLocation = destination;
        }

        return sum;
    }

    public int walk(int[] curLocation, int[] destination, List<List<Integer>> forest) {
        Queue<int[]> neighbors = new LinkedList<>();
        neighbors.add(new int[] {curLocation[0], curLocation[1], 0});
        boolean[][] mem = new boolean[forest.size()][forest.get(0).size()];
        mem[curLocation[0]][curLocation[1]] = true;

        while(!neighbors.isEmpty()) {
            int[] coord = neighbors.poll();
            int a = coord[0];
            int b = coord[1];
            int steps = coord[2];

            if(a == destination[0] && b == destination[1])
                return steps;


            if(isValid(forest, a + 1, b, mem)) {
                neighbors.add(new int[]{a + 1, b, steps + 1});
                mem[a + 1][b] = true;
            }
            if(isValid(forest, a - 1, b, mem)) {
                neighbors.add(new int[]{a - 1, b, steps + 1});
                mem[a - 1][b] = true;
            }
            if(isValid(forest, a, b + 1, mem)) {
                neighbors.add(new int[]{a, b + 1, steps + 1});
                mem[a][b + 1] = true;
            }
            if(isValid(forest, a, b - 1, mem)) {
                neighbors.add(new int[]{a, b - 1, steps + 1});
                mem[a][b - 1] = true;
            }

        }

        return -1;
    }

    public boolean isValid(List<List<Integer>> forest, int i, int j, boolean[][] mem) {
        if(i < 0 || j < 0 || i >= forest.size() || j >= forest.get(i).size() || forest.get(i).get(j) == 0 || mem[i][j] == true) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        List<Integer> a = new LinkedList<>();
        a.add(54581641);
        a.add(64080174);
        a.add(24346381);
        a.add(69107959);

        List<Integer> b = new LinkedList<>();
        b.add(86374198);
        b.add(61363882);
        b.add(68783324);
        b.add(79706116);

        List<Integer> c = new LinkedList<>();
        c.add(668150);
        c.add(92178815);
        c.add(89819108);
        c.add(94701471);

        List<Integer> d = new LinkedList<>();
        d.add(83920491);
        d.add(22724204);
        d.add(46281641);
        d.add(47531096);

        List<Integer> e = new LinkedList<>();
        e.add(89078499);
        e.add(18904913);
        e.add(25462145);
        e.add(60813308);


        List<List<Integer>> input = new LinkedList<>();
        input.add(a);
        input.add(b);
        input.add(c);
        input.add(d);
        input.add(e);

        cutOffTree solution = new cutOffTree();
        System.out.println(solution.cutOffTree(input));
    }
}
