import java.io.*;
import java.util.*;

public class Main {
    static String[] star = {"  *  ", " * * ", "*****"};
    static char[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 3) {
            bw.write(star[0] + "\n");
            bw.write(star[1] + "\n");
            bw.write(star[2] + "\n");
        }
        else {
            result = new char[N][2*N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(result[i],' ');
            }

            printStar(0,0, N);

            for (int i = 0; i < N; i++) {
                bw.write(result[i]);
                bw.write("\n");
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }

    public static void printStar(int r, int c, int depth) {
        if(depth == 3) {
            printTriangle(r,c);
            return;
        }
        printStar(r,c + depth/2, depth/2);
        printStar(r + depth/2, c, depth/2);
        printStar(r + depth/2, c + depth, depth/2);
    }

    private static void printTriangle(int r, int c) {
        for (int i = r; i < r + star.length; i++) {
            for (int j = c; j < c + star[0].length(); j++) {
                result[i][j] = star[i-r].charAt(j-c);
            }
        }
    }

}