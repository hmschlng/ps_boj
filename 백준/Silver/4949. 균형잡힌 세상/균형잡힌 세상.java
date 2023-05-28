import java.io.*;
import java.util.*;

public class Main {
	static char[] open = {'[','('};
	static char[] close = {']',')'};
	static Stack<Integer> st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			st = new Stack<>();
			char[] line = br.readLine().toCharArray();
			if(line.length == 1 && line[0] == '.') break;

			boolean isBalanced = true;
			outer : for (int i = 0; i < line.length; i++) {
				switch(line[i]) {
					case '[': {
						st.push(0);
						break;
					}
					case '(': {
						st.push(1);
						break;
					}
					case ']': {
						if(st.isEmpty() || st.peek() == 1) {
							isBalanced = false;
							break outer;
						}
						else {
							st.pop();
						}
						break;
					}
					case ')': {
						if(st.isEmpty() || st.peek() == 0) {
							isBalanced = false;
							break outer;
						}
						else {
							st.pop();
						}
						break;
					}
				}
			}

			if(!isBalanced || !st.isEmpty()) {
				sb.append("no");
			}
			else {
				sb.append("yes");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}