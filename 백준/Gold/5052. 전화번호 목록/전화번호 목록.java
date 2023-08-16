import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            String[] pNum = new String[N];
            for (int i = 0; i < N; i++) {
                pNum[i] = br.readLine();
            }

            Arrays.sort(pNum);

            boolean isConsistent = true;
            String prev = pNum[0];
            
            for (int i = 0; i < N-1; i++) {
                String cur = pNum[i+1];
                if(cur.length() <= prev.length()) {
                    prev = cur;
                    continue;
                }
                if(cur.substring(0,prev.length()).equals(prev)) {
                    isConsistent = false;
                    break;
                }
                prev = cur;
            }
            sj.add(isConsistent ? "YES" : "NO");
        }

        System.out.print(sj);
    }
}