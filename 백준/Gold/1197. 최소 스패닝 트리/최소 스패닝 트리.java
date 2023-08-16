import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int V, E;
    static List<long[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new long[]{to,weight});
            graph[to].add(new long[]{from, weight});
        }

        long ans = prim(1);

        System.out.println(ans);
    }

    private static long prim(int src) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((x,y)
                -> Long.compare(x[1], y[1]));

        boolean[] v = new boolean[V+1];
        pq.offer(new long[] {src, 0});

        long res = 0;
        while(!pq.isEmpty()) {
            long[] cur = pq.poll();

            if(v[(int)cur[0]]) continue;
            v[(int)cur[0]] = true;
            res += cur[1];

            for(long[] node : graph[(int)cur[0]]) {
                if(v[(int)node[0]]) continue;
                pq.offer(node);
            }
        }
        return res;
    }
}