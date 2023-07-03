import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int N, M;
    static char[] S;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            sb.append("IO");
        }
        String target = sb.append("I").toString();
        sb.setLength(0);

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            if(i >= (N*2)+1) {
                sb.deleteCharAt(0);
            }
            sb.append(S[i]);

            if(sb.toString().equals(target)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}