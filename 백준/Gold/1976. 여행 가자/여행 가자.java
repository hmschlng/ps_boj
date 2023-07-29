import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N,M;
    static int[][] graph;
    static Set<Integer> travel;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        travel = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            travel.add(Integer.parseInt(st.nextToken()));
        }

        int start = travel.iterator().next();
        bfs(start);

        boolean canGo = true;
        for(int spot : travel) {
            if(!v[spot]) {
                canGo = false;
                break;
            }
        }
        System.out.println(canGo ? "YES" : "NO");
    }

    private static boolean bfs(int start) {
        v = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(v[cur]) continue;
            v[cur] = true;

            for (int i = 1; i <= N; i++) {
                if(graph[cur][i] != 1) continue;
                if(v[i]) continue;

                q.offer(i);
            }
        }
        return false;
    }
}