import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int T;
    static boolean[] v;
    static Number A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T--> 0) {
            st = new StringTokenizer(br.readLine());

            A = new Number(Integer.parseInt(st.nextToken()), "");
            B = new Number(Integer.parseInt(st.nextToken()), "");

//            A.D();
//            System.out.println(Arrays.toString(A.digit) + " -> " + A.cmd);
            v = new boolean[10000];

            sb.append(bfs().cmd).append("\n");
        }
        System.out.print(sb);
    }

    private static Number bfs() {
        Queue<Number> q = new ArrayDeque<>();
        q.offer(A);
        v[A.getAsInt()] = true;

        while(!q.isEmpty()) {
            Number cur = q.poll();
//            System.out.println(Arrays.toString(cur.digit) + " -> " + cur.cmd);
            if(cur.getAsInt() == B.getAsInt()) {
                return cur;
            }

            Number d = cur.clone();
            d.D();
            if(!v[d.getAsInt()]) {
                v[d.getAsInt()] = true;
                d.cmd += "D";
                q.offer(d);
            }

            d = cur.clone();
            d.S();
            if(!v[d.getAsInt()]) {
                v[d.getAsInt()] = true;
                d.cmd += "S";
                q.offer(d);
            }

            d = cur.clone();
            d.L();
            if(!v[d.getAsInt()]) {
                v[d.getAsInt()] = true;
                d.cmd += "L";
                q.offer(d);
            }

            d = cur.clone();
            d.R();
            if(!v[d.getAsInt()]) {
                v[d.getAsInt()] = true;
                d.cmd += "R";
                q.offer(d);
            }
        }
        return null;
    }
}
class Number {
    int[] digit;
    String cmd;
    public Number() {}
    public Number(int digit, String cmd) {
        this.cmd = cmd;
        this.digit = new int[4];
        char[] ch = Integer.toString(digit).toCharArray();
        int len = ch.length;
        for (int i = 4-len; i < 4; i++) {
            this.digit[i] = ch[i - (4-len)] - '0';
        }
    }
    public Number clone() {
        Number clone = new Number();
        clone.digit = this.digit.clone();
        clone.cmd = this.cmd;
        return clone;
    }

    public void D() {
        for (int i = 3; i >= 0; i--) {
            digit[i] *= 2;
        }
        for (int i = 3; i >= 1; i--) {
            if(digit[i] >= 10) {
                digit[i-1] += (digit[i]/10);
                digit[i] %= 10;
            }
        }
        digit[0] %= 10;
    }

    public void S() {
        boolean token = true;
        for (int i = 3; i >= 0; i--) {
            if(!token) break;
            if(digit[i] == 0) {
                token = true;
                digit[i] = 9;
            }
            else {
                token = false;
                digit[i]--;
            }
        }
    }

    public void L() {
        int temp = digit[0];
        digit[0] = digit[1];
        digit[1] = digit[2];
        digit[2] = digit[3];
        digit[3] = temp;
    }

    public void R() {
        int temp = digit[3];
        digit[3] = digit[2];
        digit[2] = digit[1];
        digit[1] = digit[0];
        digit[0] = temp;
    }

    public int getAsInt() {
        return digit[0] * 1000 + digit[1] * 100 + digit[2] * 10 + digit[3];
    }
}