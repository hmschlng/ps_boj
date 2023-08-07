import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static int[][] graph;
    static int[] res;
    public int[] solution(String[] id_list, String[] report, int k) {
        map = new HashMap<>();
        graph = new int[id_list.length][id_list.length];
        res = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            
            graph[map.get(to)][map.get(from)] = 1;
        }
        
        for(int i = 0; i < graph.length; i++) {
            int bannCnt = Arrays.stream(graph[i]).sum();
            if(bannCnt >= k) {
                for(int j = 0; j < graph[i].length; j++) {
                    if(graph[i][j] == 1) {
                        res[j]++;
                    }                    
                }
            }
        }
        return res;
    }
}