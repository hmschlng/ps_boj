import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int ans;
    static Set<Integer>[] graph;
    static Set<Integer> knows;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new Set[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashSet<>();
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        if(k == 0) {
            System.out.println(M);
        } else {
            knows = new HashSet<>();
            for (int i = 0; i < k; i++) {
                int idx = Integer.parseInt(st.nextToken());
                knows.add(idx);
            }

            List<Integer>[] parties = new List[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                k = Integer.parseInt(st.nextToken());
                List<Integer> members = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    members.add(Integer.parseInt(st.nextToken()));
                }
                parties[i] = members;
                for (int j = 0; j < k; j++) {
                    for (int l = 0; l < k; l++) {
                        if(j==l) continue;
                        graph[members.get(j)].add(members.get(l));
                    }
                }
            }
            v = new boolean[N+1];
            for (int know : knows) {
                if(!v[know]) {
                    bfs(know);
                }
            }
            ans = M;
            for (List<Integer> party : parties) {
                for (int member : party) {
                    if(v[member]) {
                        ans--;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void bfs(int know) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(know);
        v[know] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int node : graph[cur]) {
                if(v[node]) continue;
                q.offer(node);
                v[node] = true;
            }
        }
    }
}