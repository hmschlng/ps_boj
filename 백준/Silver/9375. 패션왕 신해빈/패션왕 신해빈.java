import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, ans;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            map = new HashMap<>();
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름은 무시
                String type = st.nextToken();

                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 2);
                }
            }

            ans = 1;
            for (int type : map.values()) {
                ans *= type;
            }
            sb.append(ans-1).append("\n");
        }

        System.out.print(sb);
    }
}