import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        sb.append(s2);

        while(sb.length() > s1.length()) {
            char c = sb.charAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);

            if(c == 'B') {
                sb.reverse();
            }
        }
        System.out.println(s1.equals(sb.toString()) ? "1" : "0");
    }
}