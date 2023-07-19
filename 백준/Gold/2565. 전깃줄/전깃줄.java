import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static List<Integer> lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] wire = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            wire[i] = new int[]{from, to};
        }

        Arrays.sort(wire, (x, y) -> Integer.compare(x[0], y[0]));

        lis = new ArrayList<>();
        lis.add(wire[0][1]);

        for (int i = 1; i < N; i++) {
            if(lis.get(lis.size()-1) < wire[i][1]) {
                lis.add(wire[i][1]);
            }
            else {
                int idx = getLowerBound(wire[i][1]);
                if(lis.get(idx) != wire[i][1]) {
                    lis.set(idx, wire[i][1]);
                }
            }
        }

        System.out.println(N-lis.size());
    }

    private static int getLowerBound(int target) {
        int low = 0; int high = lis.size()-1;

        while(low < high) {
            int mid = (low + high) / 2;

            if(target > lis.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}