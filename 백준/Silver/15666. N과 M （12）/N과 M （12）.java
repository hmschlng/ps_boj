import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringJoiner sj1, sj2;
    static int N, M;
    static int[] arr, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sj1 = new StringJoiner("\n");

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        res = new int[M];
        comb(0, 0);

        System.out.println(sj1);
    }

    private static void comb(int start, int cnt) {
        if (cnt == M) {
            sj2 = new StringJoiner(" ");
            for(int i : res) {
                sj2.add(String.valueOf(i));
            }
            sj1.add(sj2.toString());
            return;
        }

        int prev = 0;
        for (int i = start; i < N; i++) {
            if(prev == arr[i]) continue;
            res[cnt] = arr[i];
            comb(i, cnt + 1);
            prev = arr[i];
        }
    }
}