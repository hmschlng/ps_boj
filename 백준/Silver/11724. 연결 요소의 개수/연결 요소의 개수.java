import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, ans;
    static List<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        v = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        ans = 0;
        for (int i = 1; i <= N; i++) {
            if(!v[i]) {
                ans++;
                bfs(i);
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int to : graph[cur]) {
                if(v[to]) continue;
                q.offer(to);
                v[to] = true;
            }
        }
    }
}