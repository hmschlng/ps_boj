import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static Position[] v;
    static List<Integer> path;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        v = new Position[100_000 + 1];
        ans = 0;
        bfs(N, M);
    }

    private static void bfs(int src, int dst) {
        Queue<Position> q = new ArrayDeque<>();
        Position start = new Position(src, 0, -1);
        q.offer(start);
        v[src] = start;

        while (!q.isEmpty()) {
            Position cur = q.poll();

            if (cur.pos == dst) {
                System.out.println(cur.time);

                StringJoiner sj = new StringJoiner(" ");
                Stack<Integer> stack = new Stack<>();
                stack.push(cur.pos);
                while(cur.prev != -1) {
                    stack.push(cur.prev);
                    cur = v[cur.prev];
                }
                while(!stack.isEmpty()) {
                    sj.add(String.valueOf(stack.pop()));
                }
                System.out.println(sj);
                return;
            }

            int[] di = {-1, 1, cur.pos};
            for (int d = 0; d < 3; d++) {
                int ni = cur.pos + di[d];
                if(!isIn(ni)) continue;
                if(v[ni] != null && cur.time + 1 > v[ni].time) continue;

                Position np = new Position(ni, cur.time+1, cur.pos);
                q.offer(np);
                v[ni] = np;
            }
        }
    }

    private static boolean isIn(int idx) {
        return 0 <= idx && idx <= 100_000;
    }
}
class Position {
    int pos;
    int time;
    int prev;

    public Position(int pos, int time, int prev) {
        this.pos = pos;
        this.time = time;
        this.prev = prev;
    }
}