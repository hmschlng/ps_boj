import java.util.*;

class Solution {
    static List<Integer> collatz;
    static List<Double> areas;
    public double[] solution(int k, int[][] ranges) {
        // 콜라츠 추측 배열 만들기
        collatz = new ArrayList<>();
        collatz.add(k);
        areas = new ArrayList<>();
        while(k > 1) {
            if(k%2 == 0)    k/=2;
            else            k = (k*3) + 1;
            collatz.add(k);
            
            int size = collatz.size();
            double area = (collatz.get(size-2) + collatz.get(size-1)) / 2.0;
            areas.add(area);
        }
        // collatz.forEach(num -> System.out.print(num + " "));
        // System.out.println();
        // areas.forEach(area -> System.out.print(area + " "));
        // System.out.println();
        
        // ranges에 대해 구간 변환하기
        int n = areas.size();
        for(int i = 0; i < ranges.length; i++) {
            ranges[i][1] = (n + ranges[i][1]);
        }
        // for(int[] a : ranges) System.out.println(Arrays.toString(a));
        
        // 넓이 구하기
        double[] answer = new double[ranges.length];
        for(int i = 0; i < ranges.length; i++) {
            int s = ranges[i][0], e = ranges[i][1];
            if(s <= e) {
                for(int j = s; j < e; j++) {
                    answer[i] += areas.get(j);
                }
            } else {
                answer[i] = -1.0;
            }
        }
        return answer;
    }
}