import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987_654_321;
    static StringTokenizer st;
    static int N,M;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, dist});
        }
        st = new StringTokenizer(br.readLine());

        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        int[][] fromSrc = dijkstra(src);

        int minDist = fromSrc[dest][0];
        int pathLen = fromSrc[dest][2];
        int[] path = new int[pathLen];
        for (int i = pathLen - 1 ,prev = dest; prev != -1 && i >= 0; i--) {
            path[i] = prev;
            prev = fromSrc[prev][1];
        }

        sb.append(minDist).append("\n");
        sb.append(pathLen).append("\n");
        for (int i = 0; i < pathLen; i++) {
            sb.append(path[i]).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static int[][] dijkstra(int src) {
        boolean[] v = new boolean[N+1];
        int[][] dist = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            dist[i][0] = INF;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1], y[1]));
        pq.offer(new int[]{src, 0, 1});
        dist[src][0] = 0;
        dist[src][1] = -1;
        dist[src][2] = 1;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(v[cur[0]]) continue;
            v[cur[0]] = true;
            for(int[] node : graph[cur[0]]) {
                if(v[node[0]]) continue;
                if(dist[node[0]][0] < node[1] + cur[1]) continue;

                pq.offer(new int[]{node[0], node[1] + cur[1], cur[2] + 1});
                dist[node[0]][1] = cur[0];
                dist[node[0]][0] = node[1] + cur[1];
                dist[node[0]][2] = cur[2] + 1;

            }
        }

        return dist;
    }
}