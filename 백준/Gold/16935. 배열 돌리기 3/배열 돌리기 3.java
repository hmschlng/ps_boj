import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N,M,R;

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());;
            }
        }

        st = new StringTokenizer(br.readLine());
        while(R-->0) {
            String cmd = st.nextToken();
            switch (cmd) {
                case "1": func1(); break;
                case "2": func2(); break;
                case "3": func3(); break;
                case "4": func4(); break;
                case "5": func5(); break;
                case "6": func6(); break;
            }
        }


        StringJoiner sj2 = new StringJoiner("\n");
        for (int i = 0; i < arr.length; i++) {
            StringJoiner sj1 = new StringJoiner(" ");
            for (int j = 0; j < arr[0].length; j++) {
                sj1.add(String.valueOf(arr[i][j]));
            }
            sj2.add(sj1.toString());
        }
        System.out.println(sj2);
    }

    private static int[][] init(int r, int c) {
        return new int[r][c];
    }
    private static void func1() {
        int[][] res = init(arr.length, arr[0].length);

        for (int i = res.length-1, j = 0; i >= 0 && j < res.length; i--, j++) {
            res[i] = arr[j].clone();
        }
        arr = res;
    }
    private static void func2() {
        int[][] res = init(arr.length, arr[0].length);

        for (int i = 0; i < arr.length; i++) {
            for (int k = res[0].length-1, j = 0; k >= 0 && j < res[0].length; k--, j++) {
                res[i][j] = arr[i][k];
            }
        }
        arr = res;
    }
    private static void func3() {
        int[][] res = init(arr[0].length, arr.length);

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0, k = arr.length-1; j < arr.length && k >= 0; j++, k--) {
                res[i][j] = arr[k][i];
            }
        }
        arr = res;
    }
    private static void func4() {
        int[][] res = init(arr[0].length, arr.length);

        for (int i = 0, k = arr[0].length-1; i < arr[0].length && k >= 0; i++, k--) {
            for (int j = 0; j < arr.length; j++) {
                res[i][j] = arr[j][k];
            }
        }
        arr = res;
    }
    private static void func5() {
        int[][] res = init(arr.length, arr[0].length);

        int[] I = {0, arr.length/2, arr.length/2, 0},
                J = {arr[0].length/2, arr[0].length/2, 0, 0};
        int[] K = {0, 0, arr.length/2, arr.length/2},
                L = {0, arr[0].length/2, arr[0].length/2, 0};
        int rLen = arr.length/2;
        int cLen = arr[0].length/2;

        for (int x = 0; x < 4; x++) {
            for (int i = I[x], k = K[x]; i < I[x] + rLen && k < K[x] + rLen; i++, k++) {
                for (int j = J[x], l = L[x]; j < J[x] + cLen && l < L[x] + cLen; j++, l++) {
                    res[i][j] = arr[k][l];
                }
            }
        }
        arr = res;
    }
    private static void func6() {
        int[][] res = init(arr.length, arr[0].length);
        int[] resFrom = {}, resTo;
        int[] arrFrom = {}, arrTo;
        int[]   I = {0, 0, arr.length/2, arr.length/2},
                J = {0, arr[0].length/2, arr[0].length/2, 0};
        int[]   K = {0, arr.length/2, arr.length/2, 0},
                L = {arr[0].length/2, arr[0].length/2, 0, 0};
        int rLen = arr.length/2;
        int cLen = arr[0].length/2;

        for (int x = 0; x < 4; x++) {
            for (int i = I[x], k = K[x]; i < I[x] + rLen && k < K[x] + rLen; i++, k++) {
                for (int j = J[x], l = L[x]; j < J[x] + cLen && l < L[x] + cLen; j++, l++) {
                    res[i][j] = arr[k][l];
                }
            }
        }
        arr = res;
    }

}