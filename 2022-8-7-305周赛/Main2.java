import java.util.HashSet;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        int n = 7;
        int [][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = {4, 5};
        System.out.println(main2.reachableNodes(n,edges,restricted));
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        int rowLen = edges.length;
        if (restricted.length == 0) {
            return n;
        }

        int[] record = new int[n];
        record[0] = 1;
        int res = 0;

        // 用个HashSet来暂存一下restricted
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            set.add(restricted[i]);
        }

        for (int i = 0; i < rowLen; i++) {
            if (set.contains(edges[i][0]) || set.contains(edges[i][1])) {
                if (set.contains(edges[i][0]) && edges[i][1] != 0) {
                    set.add(edges[i][1]);
                } else if (set.contains(edges[i][1]) && edges[i][0] != 0) {
                    set.add(edges[i][0]);
                } else {
                    continue;
                }
            } else {
                record[edges[i][0]]++;
                record[edges[i][1]]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (record[i] != 0) {
                res++;
            }
        }

        return res;
    }
}
