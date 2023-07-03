import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int N, M;
    static char[] S;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        S = br.readLine().toCharArray();

        String target = "I";
        for (int i = 0; i < N; i++) {
            target = target.concat("OI");
        }
        map.put(target, 0);
        
        for (int i = 0; i < (N * 2) + 1; i++) {
            sb.append(S[i]);
        }
        map.put(sb.toString(), 1);

        for (int i = (N * 2) + 1; i < M; i++) {
            sb.deleteCharAt(0);
            sb.append(S[i]);
            if(map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString())+1);
            } else {
                map.put(sb.toString(), 1);
            }
        }

        System.out.println(map.get(target));
    }
}