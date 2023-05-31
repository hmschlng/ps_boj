import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Map<Integer, Integer> map;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		pq = new PriorityQueue<>();
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int sum = 0;
		int maxFreq = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			if(map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
				maxFreq = Math.max(maxFreq, map.get(num));
			} else {
				map.put(num, 1);
			}
			pq.offer(num);
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		for (int i = 0; i < N/2; i++) {
			pq.poll();
		}

		int avg = (int) Math.round(sum / (N * 1.0));
		int mid = pq.peek();
		int freq = 0;
		int range = max - min;

		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == maxFreq) {
				pq2.offer(entry.getKey());
			}
		}
		if(pq2.size() > 1) {
			pq2.poll();
		}
		freq = pq2.poll();
		StringBuilder sb = new StringBuilder();
		sb.append(avg).append(" \n")
			.append(mid).append(" \n")
			.append(freq).append(" \n")
			.append(range).append(" \n");

		System.out.print(sb);
	}
}