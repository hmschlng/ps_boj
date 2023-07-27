import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        int[] res = new int[N];
        Arrays.fill(res, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()[0] < num) {
                int[] pop = stack.pop();
                res[pop[1]] = num;
            }
            stack.push(new int[] {num, i});
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i : res) {
            sj.add(String.valueOf(i));
        }

        System.out.println(sj);
    }
}