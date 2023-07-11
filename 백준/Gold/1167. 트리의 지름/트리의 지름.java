import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int V, ans;
    static List<int[]>[] tree;
    static boolean[] v;
    static int longestLeaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(br.readLine());
        tree = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }
        int leaf = 0;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[from].add(new int[]{to, w});
            }
        }

        ans = 0;
        v = new boolean[V + 1];
        v[1] = true;
        dfs(1, 0, 1, v);

        v = new boolean[V + 1];
        v[longestLeaf] = true;
        dfs(longestLeaf, 0, longestLeaf, v);

        System.out.println(ans);
    }

    private static void dfs(int cur, int total, int start, boolean[] v) {
        if (start != cur && isLeaf(tree[cur])) {
            if (ans < total) {
                longestLeaf = cur;
                ans = total;
            }
            return;
        }
        for (int[] node : tree[cur]) {
            if (v[node[0]]) continue;
            v[node[0]] = true;
            dfs(node[0], total + node[1], start, v);
        }
    }

    private static boolean isLeaf(List<int[]> node) {
        return node.size() == 1;
    }
}