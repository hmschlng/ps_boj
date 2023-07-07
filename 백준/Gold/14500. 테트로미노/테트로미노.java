import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, L(i, j));
                max = Math.max(max, ㅁ(i, j));
                max = Math.max(max, I(i, j));
                max = Math.max(max, ㅗ(i, j));
                max = Math.max(max, S(i, j));
            }
        }
        System.out.println(max);
    }

    private static int L(int r, int c) {
        int max = 0;
        if (isIn(r - 1, c, r - 2, c, r, c - 1)) {
            max = Math.max(max, paper[r][c] + paper[r - 1][c] + paper[r - 2][c] + paper[r][c - 1]);
        }
        if (isIn(r - 1, c, r - 2, c, r, c + 1)) {
            max = Math.max(max, paper[r][c] + paper[r - 1][c] + paper[r - 2][c] + paper[r][c + 1]);
        }
        if (isIn(r + 1, c, r + 2, c, r, c - 1)) {
            max = Math.max(max, paper[r][c] + paper[r + 1][c] + paper[r + 2][c] + paper[r][c - 1]);
        }
        if (isIn(r + 1, c, r + 2, c, r, c + 1)) {
            max = Math.max(max, paper[r][c] + paper[r + 1][c] + paper[r + 2][c] + paper[r][c + 1]);
        }
        if (isIn(r - 1, c, r, c - 1, r, c - 2)) {
            max = Math.max(max, paper[r][c] + paper[r - 1][c] + paper[r][c - 1] + paper[r][c - 2]);
        }
        if (isIn(r - 1, c, r, c + 1, r, c + 2)) {
            max = Math.max(max, paper[r][c] + paper[r - 1][c] + paper[r][c + 1] + paper[r][c + 2]);
        }
        if (isIn(r + 1, c, r, c - 1, r, c - 2)) {
            max = Math.max(max, paper[r][c] + paper[r + 1][c] + paper[r][c - 1] + paper[r][c - 2]);
        }
        if (isIn(r + 1, c, r, c + 1, r, c + 2)) {
            max = Math.max(max, paper[r][c] + paper[r + 1][c] + paper[r][c + 1] + paper[r][c + 2]);
        }
        return max;
    }

    private static int ㅁ(int r, int c) {
        int max = 0;
        if (isIn(r, c + 1, r + 1, c, r + 1, c + 1)) {
            return paper[r][c] + paper[r][c + 1] + paper[r + 1][c] + paper[r + 1][c + 1];
        }
        return max;
    }

    private static int I(int r, int c) {
        int max = 0;
        if (isIn(r, c + 1, r, c + 2, r, c + 3)) {
            max = Math.max(max, paper[r][c] + paper[r][c + 1] + paper[r][c + 2] + paper[r][c + 3]);
        }
        if (isIn(r+1, c, r+2, c, r+3, c)) {
            max = Math.max(max, paper[r][c] + paper[r+1][c] + paper[r+2][c] + paper[r+3][c]);
        }
        return max;
    }

    private static int ㅗ(int r, int c) {
        int max = 0;
        if(isIn(r-1, c, r, c+1, r+1, c)){
            max = Math.max(max, paper[r][c]+paper[r-1][c]+paper[r][c+1]+paper[r+1][c]);
        }
        if(isIn(r-1, c, r, c-1, r+1, c)){
            max = Math.max(max, paper[r][c]+paper[r-1][c]+paper[r][c-1]+paper[r+1][c]);
        }
        if(isIn(r, c-1, r+1, c, r, c+1)){
            max = Math.max(max, paper[r][c]+paper[r][c-1]+paper[r+1][c]+paper[r][c+1]);
        }
        if(isIn(r, c-1, r-1, c, r, c+1)){
            max = Math.max(max, paper[r][c]+paper[r][c-1]+paper[r-1][c]+paper[r][c+1]);
        }

        return max;
    }

    private static int S(int r, int c) {
        int max = 0;
        if(isIn(r+1,c,r+1,c-1,r+2,c-1)){
            max = Math.max(max, paper[r][c]+paper[r+1][c]+paper[r+1][c-1]+paper[r+2][c-1]);
        }
        if(isIn(r+1,c,r+1,c+1,r+2,c+1)){
            max = Math.max(max, paper[r][c]+paper[r+1][c]+paper[r+1][c+1]+paper[r+2][c+1]);
        }
        if(isIn(r,c+1,r+1,c+1,r+1,c+2)){
            max = Math.max(max, paper[r][c]+paper[r][c+1]+paper[r+1][c+1]+paper[r+1][c+2]);
        }
        if(isIn(r,c+1,r-1,c+1,r-1,c+2)){
            max = Math.max(max, paper[r][c]+paper[r][c+1]+paper[r-1][c+1]+paper[r-1][c+2]);
        }
        return max;
    }

    private static boolean isIn(int a1, int a2, int b1, int b2, int c1, int c2) {
        return (0 <= a1 && a1 < N) && (0 <= a2 && a2 < M) &&
                (0 <= b1 && b1 < N) && (0 <= b2 && b2 < M) &&
                (0 <= c1 && c1 < N) && (0 <= c2 && c2 < M);
    }
}