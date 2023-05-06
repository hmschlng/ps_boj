import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigDecimal a = new BigDecimal(Integer.parseInt(st.nextToken()));
		BigDecimal b = new BigDecimal(Integer.parseInt(st.nextToken()));

		BigDecimal res = a.add(b).multiply(a.subtract(b));
		System.out.print(res);
	}
}