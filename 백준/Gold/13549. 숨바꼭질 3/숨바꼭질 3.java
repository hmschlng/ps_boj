import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans;
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        v = new int[100000 + 1];
        Arrays.fill(v, 999999);
        ans = 999999;
        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N,0});
        v[N] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == K) {
                ans = Math.min(ans, cur[1]);
            }

            for (int i = -1; i <= 1; i+=2) {
                int walk = cur[0] + i;

                if(!(0 <= walk && walk <= 100000)) continue;
                if(v[walk] <= cur[1] + 1) continue;

                q.offer(new int[]{walk, cur[1] + 1});
                v[walk] = cur[1] + 1;
            }

            if(cur[0] >= K) continue;
            int jump = cur[0] * 2;

            if(!(0 <= jump && jump <= 100000)) continue;
            if(v[jump] <= cur[1]) continue;

            q.offer(new int[]{jump, cur[1]});
            v[jump] = cur[1];
        }
    }
}