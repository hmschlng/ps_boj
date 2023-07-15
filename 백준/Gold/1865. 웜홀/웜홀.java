import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] graph;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-->0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()),
                M = Integer.parseInt(st.nextToken()),
                W = Integer.parseInt(st.nextToken());

            graph = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(graph[i], 1, N+1, INF);
//                graph[i][i] = 0;
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()),
                        E = Integer.parseInt(st.nextToken()),
                        T = Integer.parseInt(st.nextToken());

                graph[S][E] = Math.min(graph[S][E], T);
                graph[E][S] = Math.min(graph[E][S], T);
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken()),
                        E = Integer.parseInt(st.nextToken()),
                        T = Integer.parseInt(st.nextToken());

                graph[S][E] = Math.min(graph[S][E], -T);
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }

            boolean isYes = false;
            for (int i = 1; i <= N; i++) {
                if(graph[i][i] < 0) {
                    isYes = true;
                    break;
                }
            }
            sb.append(isYes ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}