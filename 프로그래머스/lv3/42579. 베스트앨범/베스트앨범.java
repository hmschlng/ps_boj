import java.util.*;

class Solution {
    static Map<String, Genre> map;
    
    public int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            Genre g = map.containsKey(genres[i]) ? map.get(genres[i]) : new Genre();
            g.total += plays[i];
            g.songs.offer(new int[]{i, plays[i]});
            map.put(genres[i], g);
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>();        
        for(String k : map.keySet()) {
            pq.offer(map.get(k));
        }
        List<Integer> list = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            var s = pq.poll().songs;
            int sCnt = 0;
            while(!s.isEmpty() && sCnt++ < 2) {
                list.add(s.poll()[0]);
            }
        }
        
        return list.stream().mapToInt(x -> x).toArray();
    }
}

class Genre implements Comparable<Genre> {
    int total;
    PriorityQueue<int[]> songs;
    
    public Genre() {
        this.total = 0;
        this.songs = new PriorityQueue<>((x,y) -> {
            int res = Integer.compare(y[1], x[1]);
            if(res == 0) return Integer.compare(x[0], y[0]);
            return res;});
    }
    
    public int compareTo(Genre o) {
        return Integer.compare(o.total, this.total);
    }
}