import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int[] ans;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{val, i});
        }

        int prev = pq.peek()[0];
        int cnt = 0;
        ans = new int[N];

        while(N-->0) {
            int[] cur = pq.poll();
            if(cur[0] != prev) {
                cnt++;
            }
            ans[cur[1]] = cnt;
            prev = cur[0];
        }

        for (int i : ans) {
            sb.append(i).append(" ");
        }
        
        System.out.println(sb);
    }
}