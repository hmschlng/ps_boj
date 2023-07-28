import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Collections.reverseOrder());

        left.offer(Integer.parseInt(br.readLine()));
        sb.append(left.peek()).append("\n");
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > left.peek()) {
                right.offer(num);
                if(right.size() > left.size()) {
                    left.offer(right.poll());
                }
            }
            else {
                left.offer(num);
                if(left.size() > right.size() + 1) {
                    right.offer(left.poll());
                }
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }
}