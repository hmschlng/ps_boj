import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

	static BigDecimal A,B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = new BigDecimal(st.nextToken());
		B = new BigDecimal(st.nextToken());

		System.out.println(A.subtract(B).abs());
	}
}