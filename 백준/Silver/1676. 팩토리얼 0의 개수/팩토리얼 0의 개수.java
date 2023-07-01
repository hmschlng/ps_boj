import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int two = 0, five = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            while (num % 5 == 0) {
                five++;
                num /= 5;
            }
            while (num % 2 == 0) {
                two++;
                num /= 2;
            }
        }
        System.out.println(Math.min(two, five));
    }
}