import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int T, N, ans;
    static int[] mbtiList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            N = (N > 32) ? 33 : N;
            mbtiList = new int[N];
            for (int i = 0; i < N; i++) {
                mbtiList[i] = categorize(st.nextToken());
            }

            ans = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        ans = Math.min(ans, getDistance(mbtiList[i], mbtiList[j], mbtiList[k]));
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static int categorize(String mbti) {
        int idx = 0;
        for (int i = 3, shift = 0; i >= 0; i--, shift++) {
            char type = mbti.charAt(i);
            if (type == 'E' || type == 'S' || type == 'T' || type == 'J') {
                idx += 1 << shift;
            }
        }
        return idx;
    }

    private static int getDistance(int type1, int type2, int type3) {
        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if((type1 & 1 << i) != (type2 & 1 << i)) dist++;
            if((type2 & 1 << i) != (type3 & 1 << i)) dist++;
            if((type3 & 1 << i) != (type1 & 1 << i)) dist++;
        } // getDistance(11 ^ 13)
        return dist;
    }
}