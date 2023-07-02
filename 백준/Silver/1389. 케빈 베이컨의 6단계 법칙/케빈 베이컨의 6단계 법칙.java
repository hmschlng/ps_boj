import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int INF = 987654321, N, M, ans;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = graph[i][0] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = graph[to][from] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if(graph[r][c] > graph[r][i] + graph[i][c]) {
                        graph[r][c] = graph[r][i] + graph[i][c];
                    }
                }
            }
        }

        int min = INF;
        ans = 0;
        for (int i = 1; i <= N; i++) {
            int sum = Arrays.stream(graph[i]).sum();
            if(sum < min) {
                min = sum;
                ans = i;

            }
        }

        System.out.println(ans);
    }
}