import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());
            switch(cmd) {
                case 0:
                    if(pq.isEmpty()) {
                        sb.append(0).append("\n");
                    }
                    else {
                        sb.append(pq.poll()).append("\n");
                    }
                    break;
                default:
                    pq.offer(cmd);
            }
        }
        System.out.println(sb);
    }
}