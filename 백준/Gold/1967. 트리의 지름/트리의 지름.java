import javax.crypto.CipherOutputStream;
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, longestLeaf, ans;
    static List<int[]>[] tree;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()),
                to = Integer.parseInt(st.nextToken()),
                weight = Integer.parseInt(st.nextToken());

            tree[from].add(new int[]{to, weight});
            tree[to].add(new int[]{from, weight});
        }

        // 트리의 지름 == 리프노드와 리프노드 사이의 거리 중 최대값
        v = new boolean[N+1];
        v[1] = true;
        longestLeaf = 0;
        dfs(1, 0, 1, v);
        v = new boolean[N+1];

        if(longestLeaf != 0) {
            v[longestLeaf] = true;
            dfs(longestLeaf, 0, longestLeaf, v);
        }

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