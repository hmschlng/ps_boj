import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, lis;
//    static List<Integer> lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        lis = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        lis[0] = arr[0];
        int lastIdx = 0;
        for (int i = 1; i < N; i++) {
            int num = arr[i];

            // num이 현재 LIS의 마지막 원소보다 클 경우 뒤에 추가한다.
            if(lis[lastIdx] < num) {
                lis[++lastIdx] = num;
            }
            // num이 현재 LIS의 마지막 원소보다 작을 경우 이분탐색으로 lower bound를 찾아 대체한다.
            else {
                int target = getLowerBound(lis, lastIdx, num);
                if(lis[target] != num) {
                    lis[target] = num;
                }
            }
        }

        System.out.println(lastIdx + 1);
    }

    private static int getLowerBound(int[] lis, int len, int num) {
        int low = 0, high = len;
        while(low < high) {
            int mid = (low + high) / 2;
            if(lis[mid] < num) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}