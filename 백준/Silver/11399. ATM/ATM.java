import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, ans;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            pq.offer(time);
        }
        int acc = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            int time = pq.poll();
            acc += time;
            ans += acc;
        }
        System.out.println(ans);
    }
}