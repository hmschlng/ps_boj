import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int T, N;
    static char[] cmds;
    static int[] res;
    static List<Integer> seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-->0) {
            cmds = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            seq = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                seq.add(Integer.parseInt(st.nextToken()));
            }

            process();

        }
        System.out.print(sb);
    }

    private static void process() {
        boolean isReversed = false;

        for (char cmd : cmds) {
            switch(cmd) {
                case 'R':
                    isReversed = !isReversed;
                    break;
                case 'D':
                    if(seq.isEmpty()) {
                        sb.append("error").append("\n");
                        return;
                    } else {
                        seq.remove(isReversed ? seq.size()-1 : 0);
                    }
                    break;
            }
        }
        sb.append("[");
        if(!seq.isEmpty()) {
            if(isReversed) {
                for (int i = seq.size()-1; i >= 0; i--) {
                    sb.append(seq.get(i)).append(",");
                }
            } else {
                for (int i = 0; i < seq.size(); i++) {
                    sb.append(seq.get(i)).append(",");
                }
            }
            sb.setLength(sb.length()-1);
        }
        sb.append("]\n");
    }
}