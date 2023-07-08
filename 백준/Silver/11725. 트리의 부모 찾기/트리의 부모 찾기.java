import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static List<Integer>[] adjList;
    static boolean[] v;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        adjList = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        parents = new int[N+1];
        v = new boolean[N+1];
        bfs();

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        v[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int node : adjList[cur]) {
                if(v[node]) continue;
                parents[node] = cur;
                q.offer(node);
                v[node] = true;
            }
        }
    }
}