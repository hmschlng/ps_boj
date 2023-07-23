import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987_654_321;
    static StringTokenizer st;
    static int N,M;
    static List<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new int[] {to, time});
        }
        
        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        
        int[] res = dijkstra(src);

        System.out.println(res[dest]);
    }

    private static int[] dijkstra(int src) {
        boolean[] v = new boolean[N+1];
        int[] dist = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1], y[1]));

        Arrays.fill(dist, INF);
        pq.offer(new int[]{src, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(v[cur[0]]) continue;
            v[cur[0]] = true;

            for(int[] node : graph[cur[0]]) {
                int to = node[0];
                int time = node[1];

                if(!v[to] && dist[to] > cur[1] + time) {
                    dist[to] = cur[1] + time;
                    pq.offer(new int[]{to, cur[1] + time});
                }
            }
        }

        return dist;
    }
}