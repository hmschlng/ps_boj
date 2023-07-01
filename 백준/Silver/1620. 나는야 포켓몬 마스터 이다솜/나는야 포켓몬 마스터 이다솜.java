import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M;
    static Map<String, Integer> strIndex;
    static Map<Integer, String> intIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        strIndex = new HashMap<>();
        intIndex = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            strIndex.put(name, i);
            intIndex.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            if(quiz.matches("^[0-9]*")) {
                sb.append(intIndex.get(Integer.parseInt(quiz)));
            }
            else {
                sb.append(strIndex.get(quiz));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}