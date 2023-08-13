import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for (int i = 0; i < 5; i++) {
            int sox = Integer.parseInt(br.readLine());
            arr[sox]++;
            
            if(arr[sox] == 2) arr[sox] = 0;
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if(arr[i] != 0) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}