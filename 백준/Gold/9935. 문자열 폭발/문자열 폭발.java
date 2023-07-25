import java.io.*;
import java.util.*;

public class Main {
    static char[] key;
    static StringBuilder sb;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        key = br.readLine().toCharArray();

        sb = new StringBuilder();
        ans = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(sb.length() < key.length) continue;
            tryExplode();
        }

        if(sb.length() == 0) {
            bw.write("FRULA");
        }
        else {
            bw.write(sb.toString());
        }
        bw.flush();

        br.close();
        bw.close();
    }

    private static void tryExplode() {
        for (int i = 0; i < key.length; i++) {
            if(sb.charAt(sb.length()-key.length+i) != key[i]) {
                return;
            }
        }
        sb.setLength(sb.length()-key.length);
    }
}