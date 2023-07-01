import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N,M;
    static Set<String> set;
    static PriorityQueue<String> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                pq.offer(name);
            }
        }
        int size = pq.size();
        sb.append(size).append("\n");
        
        for (int i = 0; i < size; i++) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }
}