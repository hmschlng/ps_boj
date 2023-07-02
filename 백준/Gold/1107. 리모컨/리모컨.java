import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, ans;
    static Map<Integer, Integer> buttons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        buttons = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            buttons.put(i, 0);
        }

        M = Integer.parseInt(br.readLine());
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            buttons.remove(Integer.parseInt(st.nextToken()));
        }
        ans = Math.abs(100 - N);
        for (int i = 0; i < 1_000_000; i++) {
            if(!canFigure(i)) continue;

            int dist = String.valueOf(i).length() + Math.abs(i - N);
            if(dist < ans) {
                ans = dist;
            }
        }

        System.out.println(ans);
    }

    private static boolean canFigure(int num) {
        String val = String.valueOf(num);
        for (int i = 0; i < val.length(); i++) {
            if (!buttons.containsKey(val.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }

}