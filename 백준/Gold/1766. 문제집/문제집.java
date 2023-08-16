import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static StringTokenizer st;
    static int N,M;
    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            indegree[to]++;
        }

        topologicalSort(sj);

        System.out.println(sj);
    }

    private static void topologicalSort(StringJoiner sj) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++)
            if(indegree[i] == 0)
                pq.offer(i);

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            sj.add(String.valueOf(cur));

            for (int node : graph[cur]) {
                indegree[node]--;
                if(indegree[node] == 0) {
                    pq.offer(node);
                }
            }
        }
    }


}