import java.io.*;
import java.util.*;

public class Main {

	static Integer N,v,num;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(br.readLine());
		
		int count = 0;

		while(st.hasMoreTokens()) {
			if((num=Integer.parseInt(st.nextToken())) == v) {
				count++;
			}
		}
		System.out.print(count);
	}
}