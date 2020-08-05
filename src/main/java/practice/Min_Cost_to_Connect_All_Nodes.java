package practice;

import java.util.Arrays;

/**
 * Created by ayokota on 8/5/20.
 */
public class Min_Cost_to_Connect_All_Nodes {

    public static int solution(int n, int[][] edges, int[][] newEdges) {
        int count = 0;
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        int sum = 0;

        for(int[] existingEdges : edges) {
            int pA = findParent(parents, existingEdges[0]);
            int pB = findParent(parents, existingEdges[1]);

            if(pA == pB)
                continue;
            parents[pA] = pB;
            count++;
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        for(int[] newEdge : newEdges) {
            int pA = findParent(parents, newEdge[0]);
            int pB = findParent(parents, newEdge[1]);

            if(pA == pB)
                continue;

            parents[pA] = pB;
            sum+= newEdge[2];
            count++;
        }


        return count + 1 == n ? sum : -1;
    }

    public static int findParent(int[] parents, int node) {
        if(parents[node] == -1) {
            return node;
        }

        parents[node] = findParent(parents, parents[node]);
        return parents[node];
    }

    public static void main(String[] args) {
        System.out.println( solution(6,
                new int[][] { {1, 4}, {4, 5}, {2, 3}},
                new int[][] {
                        {1, 2, 5},
                        {1, 3, 10},
                        {1, 6, 2},
                        {5, 6, 5},
                }
                ));
    }
}
