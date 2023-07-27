import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeSet();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case 0:
                    union(a,b);
                    break;
                case 1:
                    sb.append(findSet(a) == findSet(b) ? "YES" : "NO").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void makeSet() {
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
    }

    private static int findSet(int a) {
        if(a == p[a]) return a;
        return p[a] = findSet(p[a]);
    }

    private static boolean union(int a, int b) {
        if(findSet(a) == findSet(b)) return false;
        else {
            p[findSet(b)] = findSet(a);
            return true;
        }
    }
}