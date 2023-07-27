import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;

        int[] lis = new int[N];
        int[] lds = new int[N];

        if(N != 1) {
            for (int i = 0, j = N - 1; i < N && j >= 0; i++, j--) {
                lis[i] = 1;
                lds[j] = 1;
                for (int k = 0, l = N - 1; k < i && l > j; k++, l--) {
                    if(arr[k] < arr[i] && lis[i] < lis[k] + 1) {
                        lis[i] = lis[k] + 1;
                    }
                    if(arr[l] < arr[j] && lds[j] < lds[l] + 1) {
                        lds[j] = lds[l] + 1;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, lis[i] + lds[i] - 1);
            }
        }

        System.out.println(ans);
    }
}