package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ayokota on 8/4/20.
 */
public class tarjan {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int curdepth=0;

        int[] low = new int[n];
        int[] label = new int[n];

        for(List<Integer> con: connections){
            int i = con.get(0);
            int j = con.get(1);
            adj[i].add(j);
            adj[j].add(i);
        }

        boolean [] visited = new boolean[n];
        dfs(visited, 0, -1, curdepth, label, low, adj, result);

        for(int l : low)
            System.out.println(l + ", ");
        System.out.println();

        return result;
    }

    public static void dfs(boolean[] visited, int node, int parentNode, int depth, int[] label, int[] low, List<Integer>[] adj, List<List<Integer>> result ) {
        visited[node] = true;
        label[node] = depth;
        low[node] = depth;
        depth++;

        for(int neighbor : adj[node]) {
            if(neighbor == parentNode)
                continue;

            if(!visited[neighbor]) {
                dfs(visited, neighbor, node, depth, label, low, adj, result);

                low[node] = Math.min(low[node], low[neighbor]);

                if(label[node] < low[neighbor]){
                    result.add(Arrays.asList(node, neighbor));
                }
            } else {
                int newLow = Math.min(low[node], low[neighbor]);
                low[node] = newLow;
            }
        }


    }

    public static void main(String[] args) {
        List<List<Integer>> input = new LinkedList<List<Integer>>();
        List<Integer> input1 = new LinkedList<>();
        input1.add(0);
        input1.add(1);
        input.add(input1);
        List<Integer> input2 = new LinkedList<>();
        input2.add(1);
        input2.add(2);
        input.add(input2);
        List<Integer> input3 = new LinkedList<>();
        input3.add(2);
        input3.add(0);
        input.add(input3);
        List<Integer> input4 = new LinkedList<>();
        input4.add(1);
        input4.add(3);
        input.add(input4);
        List<Integer> input5 = new LinkedList<>();
        input5.add(3);
        input5.add(4);
        input.add(input5);
        List<Integer> input6 = new LinkedList<>();
        input6.add(4);
        input6.add(5);
        input.add(input6);
        List<Integer> input7 = new LinkedList<>();
        input7.add(5);
        input7.add(3);
        input.add(input7);
        List<Integer> input8 = new LinkedList<>();
        input8.add(1);
        input8.add(6);
        input.add(input8);
        List<Integer> input9 = new LinkedList<>();
        input9.add(6);
        input9.add(7);
        input.add(input9);
        List<Integer> input10 = new LinkedList<>();
        input10.add(7);
        input10.add(8);
        input.add(input10);
        List<Integer> input11 = new LinkedList<>();
        input11.add(8);
        input11.add(2);
        input.add(input11);


        List<List<Integer>> result = criticalConnections(9, input);
        for(List<Integer> con : result) {
            System.out.println(con.get(0) + ", " + con.get(1));
        }

    }
}
