import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static String A, B;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        ans = -1;
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Number> q = new ArrayDeque<>();
        q.offer(new Number(A, 0));

        while (!q.isEmpty()) {
            Number cur = q.poll();

            if (B.equals(cur.num)) {
                ans = cur.times + 1;
                return;
            }

            // 2배 연산
            String doubleNum = String.valueOf(Long.parseLong(cur.num) * 2);
            if(isIn(doubleNum)) {
                q.offer(new Number(doubleNum, cur.times+1));
            }

            // 자릿수에 1 추가 연산
            String addNum = new StringBuilder(cur.num).append("1").toString();
            if (isIn(addNum)) {
                q.offer(new Number(addNum, cur.times+1));
            }
        }
    }

    private static boolean isIn(String num) {
        return Long.parseLong(num) <= Long.parseLong(B);
    }
}

class Number {
    String num;
    int times;

    public Number(String num, int times) {
        this.num = num;
        this.times = times;
    }
}