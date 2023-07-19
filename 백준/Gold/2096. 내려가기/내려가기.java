import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] max = new int[N+1][3],
                min = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            max[i][0] = Math.max(max[i-1][0],max[i-1][1]) + A;
            max[i][1] = Math.max(max[i-1][0],Math.max(max[i-1][1], max[i-1][2])) + B;
            max[i][2] = Math.max(max[i-1][1],max[i-1][2]) + C;

            min[i][0] = Math.min(min[i-1][0],min[i-1][1]) + A;
            min[i][1] = Math.min(min[i-1][0],Math.min(min[i-1][1], min[i-1][2])) + B;
            min[i][2] = Math.min(min[i-1][1],min[i-1][2]) + C;
        }

        System.out.println(Arrays.stream(max[N]).max().getAsInt() + " " + Arrays.stream(min[N]).min().getAsInt());
    }
}