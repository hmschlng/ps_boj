import java.util.*;
class Solution {
    static TreeMap<Integer, Integer> distMap;
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        distMap = new TreeMap<>();
        graph = new List[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        bfs(n);
        
        return distMap.lastEntry().getValue();
    }
    
    public void bfs(int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[n+1];
        
        q.offer(new int[]{1,0});
        v[1] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int node : graph[cur[0]]) {
                if(v[node]) continue;
                distMap.put(cur[1] + 1, distMap.getOrDefault(cur[1] + 1, 0) + 1);
                q.offer(new int[]{node, cur[1] + 1});
                v[node] = true;
            }
        }
    }
}