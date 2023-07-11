class Solution {
    static String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
    static int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    public String solution(int a, int b) {
        int passed = 0;
        for(int i = 1; i < a; i++) {
            passed += month[i];
        }
        passed += b - 1;
        return days[passed%7];
    }
}