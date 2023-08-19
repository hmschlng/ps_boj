import java.util.*;

class Solution {
    static String[] map;
    static int N,M;
    static Set<Integer>[] delInfo;

    public int solution(int m, int n, String[] board) {
        init(m,n,board);

        int cnt = 0;
        while(true) {
            int res = destroy();
            if(res == 0) break;
            cnt += res;
        }

        return cnt;
    }

    public int destroy() {
        for(int i = 0; i < N-1; i++) {
            if(map[i].isEmpty()) continue;
            for(int j = 0; j < map[i].length()-1; j++) {
                char c = map[i].charAt(j);
                if(check(i,j)) {
                    delInfo[i].add(j);
                    delInfo[i].add(j+1);
                    delInfo[i+1].add(j);
                    delInfo[i+1].add(j+1);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < delInfo.length; i++) {
            if(!delInfo[i].isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(map[i]);
                for(int e : delInfo[i]) {
                    sb.deleteCharAt(e);
                    cnt++;
                }
                delInfo[i].clear();
                map[i] = sb.toString();
            }
        }
        return cnt;
    }

    public boolean check(int r, int c) {
        if(map[r+1] == null || map[r+1].length() < c+2) return false;
        char ch = map[r].charAt(c);
        if(map[r].charAt(c+1) == ch &&
                map[r+1].charAt(c) == ch &&
                map[r+1].charAt(c+1) == ch) return true;
        return false;
    }

    public void init(int m, int n, String[] board) {
        N = n;
        M = m;
        map = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = m-1; j >= 0; j--) {
                sb.append(board[j].charAt(i));
            }
            map[i] = sb.toString();
        }

        delInfo = new TreeSet[n];
        for(int i = 0; i < n; i++) {
            delInfo[i] = new TreeSet<>((x,y) -> Integer.compare(y,x));
        }
    }
}