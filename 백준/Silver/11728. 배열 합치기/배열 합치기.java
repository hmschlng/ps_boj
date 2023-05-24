import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int aLen, bLen;

	static int[] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		aLen = Integer.parseInt(st.nextToken());
		bLen = Integer.parseInt(st.nextToken());

		A = new int[aLen];
		B = new int[bLen];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < aLen; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < bLen; i++)
			B[i] = Integer.parseInt(st.nextToken());

		int aPoint = 0, bPoint = 0;

		while (aPoint < aLen && bPoint < bLen) {
			if (A[aPoint] < B[bPoint]) {
				sb.append(A[aPoint++]).append(" ");
			} else if (A[aPoint] > B[bPoint]) {
				sb.append(B[bPoint++]).append(" ");
			} else {
				sb.append(A[aPoint++]).append(" ").append(B[bPoint++]).append(" ");
			}
		}
		if(aPoint == aLen) {
			for (int i = bPoint; i < bLen; i++) {
				sb.append(B[i]).append(" ");
			}
		} else if (bPoint == bLen) {
			for (int i = aPoint; i < aLen; i++) {
				sb.append(A[i]).append(" ");
			}
		}

		System.out.print(sb);
	}
}