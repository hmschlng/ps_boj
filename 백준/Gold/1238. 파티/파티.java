import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static final int INF = 987654321;
    static int N, M, X;
    static List<int[]>[] graph, reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new List[N+1];
        reverseGraph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to,time});
            reverseGraph[to].add(new int[]{from,time});
        }

        int[] fromEachToX = dijkstra(reverseGraph, X);
        int[] fromXToEach = dijkstra(graph, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, fromEachToX[i] + fromXToEach[i]);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(List<int[]>[] graph, int start) {
        // 탐색 대기열 PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1],y[1]));
        pq.offer(new int[] {start, 0});

        // start에서 각 노드까지의 최소거리 저장 배열 초기화
        int[] distances = new int[N+1];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        // 방문 여부 체크 배열 초기화
        boolean[] v = new boolean[N+1];
        v[start] = true;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] node : graph[cur[0]]) {
                int num = node[0], dist = node[1];
                // 현재까지 구한 start에서 num까지 가는 최소거리와,
                // 현재 다른 노드(cur)를 거쳐 num까지 가는 최소거리 중 더 작은 값을 저장 
                distances[num] = Math.min(distances[num], dist+cur[1]);
                
                // 아직 방문하지 않은 노드에 대해서만 탐색 대기열에 추가
                if(v[node[0]]) continue;
                pq.offer(new int[]{node[0], cur[1] + node[1]});
                v[cur[0]] = true;
            }
        }
        return distances;
    }
}