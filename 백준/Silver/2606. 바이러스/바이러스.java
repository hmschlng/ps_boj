import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] graph;
    static Boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        v = new Boolean[N + 1];
        Arrays.fill(v, false);
        bfs(1);

        long ans = Arrays.stream(v).filter(x -> x).count();
        System.out.println(ans - 1);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        v[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int to : graph[cur]) {
                if(v[to]) continue;
                q.offer(to);
                v[to] = true;
            }
        }
    }
}