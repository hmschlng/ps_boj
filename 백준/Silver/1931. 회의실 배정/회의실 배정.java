import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, ans;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((x,y) -> {
            if(x[1] == y[1]) {
                return Integer.compare(x[0], y[0]);
            }
            else {
                return Integer.compare(x[1], y[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        ans = 0;
        while(!pq.isEmpty()) {
            int[] meet = pq.poll();
            ans++;
            while(!pq.isEmpty() && pq.peek()[0] < meet[1]) pq.poll();
        }

        System.out.println(ans);
    }
}