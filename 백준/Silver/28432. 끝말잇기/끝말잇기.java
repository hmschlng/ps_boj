import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ans = null;
        int N = Integer.parseInt(br.readLine());;

        String[] log = new String[N];
        int idx = -1;
        for (int i = 0; i < N; i++) {
            log[i] = br.readLine();
            if("?".equals(log[i])) {
                idx = i;
            }
        }
        
        char suf = (idx == N - 1) ? '0' : log[idx+1].charAt(0);
        char pre = (idx == 0) ? '0' : log[idx-1].charAt(log[idx-1].length()-1);

        int M = Integer.parseInt(br.readLine());

        outer : for (int i = 0; i < M; i++) {
            String sol = br.readLine();
            if(N == 1) {
                ans = sol;
                break;
            }
            for (int j = 0; j < N; j++) {
                if(sol.equals(log[j])) {
                    continue outer;
                }
            }

            if(idx == 0) {
                if(sol.charAt(sol.length()-1) != suf) continue;
            } else if (idx == N - 1) {
                if(sol.charAt(0) != pre) continue;
            } else {
                if (sol.charAt(0) != pre || sol.charAt(sol.length() - 1) != suf) continue;
            }
            ans = sol;
            break;
        }

        System.out.println(ans);
    }
}