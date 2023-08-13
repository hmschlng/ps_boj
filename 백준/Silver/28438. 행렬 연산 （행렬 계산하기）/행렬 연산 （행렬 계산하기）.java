import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] r = new int[N];
        int[] c = new int[M];

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                r[a] += b;
            }
            else {
                c[a] += b;
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(r[i] + c[j]).append(" ");
            }
            sb.setLength(sb.length()-1);
            sj.add(sb.toString());
        }
        bw.write(sj.toString());
        bw.flush();

        br.close();bw.close();
    }
}