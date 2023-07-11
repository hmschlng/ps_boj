import javax.crypto.CipherOutputStream;
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, ans;
    static List<int[]>[] tree;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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

        for (int i = 1; i <= N; i++) {
            if(isLeaf(tree[i])) {
                v = new boolean[N+1];
                v[i] = true;
                dfs(i, 0, i);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int cur, int total, int start) {
        if(isLeaf(tree[cur]) && cur != start) {
            ans = Integer.max(ans, total);
            v[cur] = true;
            return;
        }
        for (int[] node : tree[cur]) {
            if(!v[node[0]]) {
                v[node[0]] = true;
                dfs(node[0], total + node[1], start);
            }
        }
    }

    private static boolean isLeaf(List<int[]> node) {
        return node.size() == 1;
    }
}