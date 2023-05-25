import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
	static int N, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			char[] word = br.readLine().toCharArray();
			int left = 0, right = word.length - 1, ans = 0, wrongCnt = 0;
			char leftCache = 0, rightCache = 0;

			while(left <= right && wrongCnt < 2) {
				if(word[left] == word[right]) {
					left++;
					right--;
				}
				else {
					int palindromeCnt = 0;
					// case 1: 왼쪽 글자를 날린 경우에서 회문 찾기
					boolean isLeft = isPalindrome(word, left+1, right);
					// case 2: 오른쪽 글자를 날린 경우에서 회문 찾기
					boolean isRight = isPalindrome(word, left, right-1);
					if(!isLeft && !isRight) {
						ans = 2;
					}
					else {
						ans = 1;
					}
					break;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isPalindrome(char[] word, int left, int right) {
		while(left <= right) {
			if(word[left] != word[right]) {
				return false;
			}
			else {
				left++;
				right--;
			}
		}
		return true;
	}
}