import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static final int INF = 987654321;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = val;
                }
            }
        }

        // Floyd
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > graph[k][j] + graph[i][k]) {
                        graph[i][j] = graph[k][j] + graph[i][k];
                    }
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switch(graph[i][j]) {
                    case INF: case 0:
                        sb.append(0); break;
                    default:
                        sb.append(1); break;
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}