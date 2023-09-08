import java.util.*;

public class Solution {
    static boolean[][] v;
    static int[][] map, tbl;
    static List<Piece> puzzles;
    static int size;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};

    public int solution(int[][] game_board, int[][] table) {
        int ans = 0;

        size = game_board.length;
        map = game_board;
        tbl = table;
        puzzles = new ArrayList<>();

        v = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(v[i][j] || tbl[i][j] == 0) continue;
                Piece puzzle = bfs(i, j, tbl, 1);
                puzzles.add(puzzle);
            }
        }

        v = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(v[i][j] || map[i][j] == 1) continue;
                Piece hole = bfs(i, j, map, 0);
                ans += putPuzzle(hole);
            }
        }
        return ans;
    }

    public int putPuzzle(Piece hole) {
        for(int i = 0; i < puzzles.size(); i++) {
            Piece puzz = puzzles.get(i);

            if(puzz.size != hole.size) continue;

            for(int j = 0; j < 4; j++) {
                if(isMatch(hole, puzz)) {
                    int size = puzz.size;
                    puzzles.remove(i);
                    return size;
                } else {
                    rotate(hole);
                }
            }
        }

        return 0;
    }

    public boolean isMatch(Piece p1, Piece p2) {
        if(p1.w != p2.w || p1.h != p2.h) return false;

        for(int i = 0; i < p1.h; i++) {
            for(int j = 0; j < p1.w; j++) {
                if(p1.info[i][j] == p2.info[i][j]) return false;
            }
        }

        return true;
    }

    public void rotate(Piece p) {
        int[][] rotate = new int[p.w][p.h];

        for(int i = 0, k = 0; i < rotate.length && k < p.w; i++, k++) {
            for(int j = 0, l = p.h-1; j < rotate[0].length && l >= 0; j++, l--) {
                rotate[i][j] = p.info[l][k];
            }
        }

        p.info = rotate;
        p.h = rotate.length;
        p.w = rotate[0].length;
    }

    public Piece bfs(int r, int c, int[][] arr, int target) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] range = {r,c,r,c};                    // minR, minC, maxR, maxC
        int size = 1;

        q.offer(new int[]{r,c});
        v[r][c] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(!isIn(nr, nc) || v[nr][nc] || arr[nr][nc] != target) continue;

                range = updateRange(nr, nc, range);
                size++;
                q.offer(new int[] {nr, nc});
                v[nr][nc] = true;
            }
        }

        int[][] info = new int[range[2] - range[0] + 1][range[3] - range[1] + 1];
        for(int i = 0; i < info.length; i++) {
            for(int j = 0; j < info[0].length; j++) {
                info[i][j] = arr[range[0] + i][range[1] + j];
            }
        }
        return new Piece(info, range[3] - range[1] + 1, range[2] - range[0] + 1, size);
    }

    public int[] updateRange(int r, int c, int[] range) {
        return new int[] { Math.min(r,range[0]), Math.min(c,range[1]), Math.max(r,range[2]), Math.max(c,range[3]) };
    }

    public boolean isIn(int r, int c) {
        return 0<=r&&r<size && 0<=c&&c<size;
    }
}

class Piece {
    int[][] info;
    int w,h,size;

    public Piece(int[][] info, int w, int h, int size) {
        this.info = info;
        this.w = w;
        this.h = h;
        this.size = size;
    }
}

