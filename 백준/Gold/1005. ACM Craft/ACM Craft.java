import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N,K,ans;
    static List<Integer>[] graph;
    static int[] times, indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new List[N+1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            times = new int[N+1];
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N+1];
            // reverse graph
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indegree[to]++;
            }

            int dst = Integer.parseInt(br.readLine());

            int ans = topologicalSort(dst);

            sj.add(String.valueOf(ans));
        }
        System.out.println(sj);
    }

    private static int topologicalSort(int dst) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)
                -> Integer.compare(x[1], y[1]));

        for (int i = 1; i <= N; i++)
            if(indegree[i] == 0)
                pq.offer(new int[] {i, times[i]});

        int res = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[0] == dst) {
                res = cur[1];
                continue;
            }

            for(int node : graph[cur[0]]) {
                indegree[node]--;
                if(indegree[node] == 0) {
                    pq.offer(new int[]{node, cur[1] + times[node]});
                }
            }
        }

        return res;
    }
}