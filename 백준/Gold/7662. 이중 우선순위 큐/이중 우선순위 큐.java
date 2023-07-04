import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int T,K;
    static TreeMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            K = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());

                process(cmd, val);
            }

            sb.append((map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey())).append("\n");
        }

        System.out.println(sb);
    }

    private static void process(char cmd, int val) {
        switch(cmd) {
            case 'I':
                if(map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
                break;
            case 'D':
                if(!map.isEmpty()) {
                    int key = (val == -1) ? map.firstKey() : map.lastKey();
                    if(map.get(key) > 1) {
                        map.put(key, map.get(key) - 1);
                    }
                    else {
                        map.remove(key);
                    }
                }
                break;
        }
    }
}