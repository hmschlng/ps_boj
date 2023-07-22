import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 98_765_432;
    static StringTokenizer st;
    static int N, E, A, B;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프 객체 초기화
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 정보 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, dist});
            graph[to].add(new int[]{from, dist});
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());



        int[] from1 = dijkstra(1); // 1 --> A, B
        int[] fromN = dijkstra(N); // N --> A, B
        int[] fromA = dijkstra(A); // A --> B

        int p_1ABN = from1[A] + fromA[B] + fromN[B];
        int p_1BAN = from1[B] + fromA[B] + fromN[A];
        
        if(A==1 && B==N && A==N && B==1) {
            System.out.println(from1[N]);
            return;
        }
        if(p_1ABN >= INF || p_1BAN >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(p_1ABN, p_1BAN));
    }

    private static int[] dijkstra(int src) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        boolean[] v = new boolean[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1],y[1]));

        pq.offer(new int[]{src,0});
        v[src] = true;
        dist[src] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            for(int[] node : graph[cur[0]]) {
                if(v[node[0]] && dist[node[0]] < cur[1] + node[1]) continue;

                pq.offer(new int[]{node[0], cur[1] + node[1]});
                dist[node[0]] = Math.min(dist[node[0]], cur[1] + node[1]);
                v[node[0]] = true;
            }
        }

        return dist;
    }
}