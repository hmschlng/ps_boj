class Solution {
    public long solution(int price, int money, int count) {
        long sub = 1;
        long sum = 0;
        for(int i = 1; i <= count; i++) {
            sum += i;
        }
        sub = sum * price;
        if(money > sub) {
            return 0;
        } else return sub - money;
    }
}