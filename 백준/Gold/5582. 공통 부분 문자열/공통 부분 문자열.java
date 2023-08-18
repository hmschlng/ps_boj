import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int ans = Math.max(getLCS(s1, s2), getLCS(s2, s1));
        System.out.println(ans);
    }

    private static int getLCS(String s1, String s2) {
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); ) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    j++;
                    continue;
                }
                int a = i;
                int cnt = 0;
                while (a < s1.length() && j < s2.length()
                        && s1.charAt(a) == s2.charAt(j)) {
                    cnt++;
                    a++;
                    j++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}