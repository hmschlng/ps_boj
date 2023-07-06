import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N,M;
    static Map<String, String> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {

            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }
}