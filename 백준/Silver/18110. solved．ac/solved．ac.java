import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        int cut = (int)Math.round(n * 0.3 * 0.5);

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < cut; i++) {
            pq.remove();
        }
        int sum = 0;
        for (int i = 0; i < n - (cut*2); i++) {
            sum += pq.poll();
        }
        System.out.println(Math.round(sum / (n - cut * 2.0)));
    }
}